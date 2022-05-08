/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Modal.Category;
import Services.ServiceArticle;
import Services.ServiceCategory;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ModifierblogController implements Initializable {

    private Connection cnx = ConnectionClass.getInstance().getCnx();

    private Article a;
    ValidationSupport validationsupport = new ValidationSupport();

    public void setA(Article a) {
        this.a = a;
        titlefield.setText("" + a.getContent());
    }

    @FXML
    private TextField contentfield;

    @FXML
    private Button modifier;

    @FXML
    private TextField titlefield;
    @FXML
    private Label title;
 @FXML
    private ComboBox<String> tfcategory;
    private ServiceCategory servicecategorie = new ServiceCategory();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("from ui modif ------------" + a);
List<String> combolist = new ArrayList<>();
        combolist = servicecategorie.afficher().stream().map(Category::getNom).collect(Collectors.toList());
        tfcategory.getItems().addAll(combolist);

        // title.setText(""+a.getId());
 String nom = tfcategory.getSelectionModel().getSelectedItem();
Category c = new Category();
        Article p = new Article();
         c.setNom(nom);

        c.setNom(tfcategory.getSelectionModel().getSelectedItem());

        ServiceArticle sp = new ServiceArticle();
          c.setNom(tfcategory.getSelectionModel().getSelectedItem());
 
          sp.addtocategory(p, nom);
    }

    public void setData(Article a) {
 validationsupport.registerValidator(contentfield, Validator.createEmptyValidator("Contentfield is required"));
     validationsupport.registerValidator(titlefield, Validator.createEmptyValidator("titlefield is required"));

        titlefield.setText("" + a.getTitle());
        contentfield.setText(a.getContent());
        title.setText("" + a.getId());

    }

    @FXML
    void Modifier(ActionEvent event) {

        int id = Integer.parseInt(title.getText());
        String query = "UPDATE article SET title='" + titlefield.getText() + "',content='" + contentfield.getText() + "'  WHERE id=" + id + "";
Alert a1 = new Alert(Alert.AlertType.NONE,
                              "Voulez vous ajouter",ButtonType.APPLY);
 
                // show the dialog
                a1.show();

        // show the dialog
        a1.show();
        executeQuery(query);

    }

@FXML
    void Accdat(ActionEvent event) {
 String nom = tfcategory.getSelectionModel().getSelectedItem();
Category c = new Category();
        Article p = new Article();
         c.setNom(nom);

        c.setNom(tfcategory.getSelectionModel().getSelectedItem());

        ServiceArticle sp = new ServiceArticle();
          c.setNom(tfcategory.getSelectionModel().getSelectedItem());
 
          sp.addtocategory(p, nom);
    }


    public void executeQuery(String query) {
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
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
