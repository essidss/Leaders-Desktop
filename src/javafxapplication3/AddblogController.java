/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Modal.Article;
import Services.ServiceArticle;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class AddblogController implements Initializable {
  @FXML
    private Button add;

    @FXML
    private TextArea contentfield;

    @FXML
    private TextField titlefield;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



@FXML
    void add(ActionEvent event) {
        Article p = new Article();
        p.setTitle(titlefield.getText());
        p.setContent(contentfield.getText());

        Alert a1 = new Alert(AlertType.NONE,
                              "Voulez vous ajouter",ButtonType.APPLY);
 
                // show the dialog
                a1.show();

        // show the dialog
        a1.show();
        ServiceArticle sp = new ServiceArticle();
        sp.ajouter(p);
    }




    
}
