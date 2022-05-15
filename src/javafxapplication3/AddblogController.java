/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Modal.Posts;
import Services.ServicePosts;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import Connectivity.copyImage;
import Services.LoginSession;
import javafx.scene.control.Label;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddblogController implements Initializable {

    @FXML
    private Button add;

    @FXML
    private TextField contentfield;

    @FXML
    private TextField titlefield;

    @FXML
    private Text label_photo;
    @FXML
    private Button browse;
    private String absolutePathPhotoAnnonce;

    ValidationSupport validationsupport = new ValidationSupport();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        validationsupport.registerValidator(titlefield, Validator.createEmptyValidator("titlefield is required"));

    }

    @FXML
    void add(ActionEvent event) {
        if (titlefield.getText().equals("") || contentfield.getText().equals("")) {
            validationsupport.registerValidator(contentfield, Validator.createEmptyValidator("Contentfield is required"));
            validationsupport.registerValidator(titlefield, Validator.createEmptyValidator("titlefield is required"));
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("control saisie");
            alert.setHeaderText("attention");
            alert.setContentText("veuillez remplir tous les champs");
            alert.showAndWait();
        } else {
            Posts p = new Posts();
            p.setPicture(label_photo.getText());
            p.setTitle(titlefield.getText());
            p.setContent(contentfield.getText());
            p.setUser_id(LoginSession.UID);
            copyImage.deplacerVers(label_photo, absolutePathPhotoAnnonce, "C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\img");

            Alert a1 = new Alert(AlertType.NONE,
                    "Voulez vous ajouter", ButtonType.APPLY);

            // show the dialog
            a1.show();

            // show the dialog
            a1.show();
            ServicePosts sp = new ServicePosts();
            sp.ajouter(p);
        }
    }

      @FXML
    void addimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        browse.setOnAction(e -> {
            File choix = fileChooser.showOpenDialog(null);
            if (choix != null) {
                System.out.println(choix.getAbsolutePath());
                absolutePathPhotoAnnonce = choix.getAbsolutePath();
                System.out.println("TEST" + absolutePathPhotoAnnonce);
                label_photo.setText(choix.getName());

            } else {
                System.out.println("Image introuvable");
            }
        });

    }

}


    
//}
