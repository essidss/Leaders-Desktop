/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.copyImage;
import Modal.Posts;
import Modal.Category;
import Services.ServicePosts;
import Services.ServiceCategory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddcategorieController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button add;

    @FXML
    private TextField name;
    ValidationSupport validationsupport = new ValidationSupport();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        validationsupport.registerValidator(name, Validator.createEmptyValidator("name categorie is required"));

    }

    @FXML
    void add(ActionEvent event) {
        validationsupport.registerValidator(name, Validator.createEmptyValidator("name categorie is required"));

        if (name.getText().equals("")) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("control saisie");
            alert.setHeaderText("attention");
            alert.setContentText("veuillez remplir tous les champs");
            alert.showAndWait();
        } else {
            Category p = new Category();
            p.setNom(name.getText());

            Alert a1 = new Alert(Alert.AlertType.NONE,
                    "Voulez vous ajouter", ButtonType.APPLY);

             a1.show();

             a1.show();
            ServiceCategory sp = new ServiceCategory();
            sp.ajouter(p);
        }
    }
 @FXML
    void Acceuil(MouseEvent event) throws IOException {

        Parent window3; //we need to load the layout that we want to swap
        window3 = FXMLLoader.load(getClass().getResource("FXMLArticles.fxml"));

        Scene newScene; //then we create a new scene with our new layout
        newScene = new Scene(window3);

        Stage mainWindow; //Here is the magic. We get the reference to main Stage.
        mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        mainWindow.setScene(newScene); //here we simply set the new scene

    }
}
