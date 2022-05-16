
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import Modal.Event;
import Modal.Categorie;
import Services.ServiceE;
import Services.ServiceC;
import javafx.stage.Stage;

public class FXMLEVController implements Initializable {

  
    
    private Event ev;
    @FXML
    private Button upd;
   

    //private Parent root;
    //private Label idpost;
    /**
     *
     * Initializes the controller class.
     */
    private javafx.stage.Stage stage, stage1;
    private Scene scene, scene1;
    private Parent root, root1;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label lieu;
    @FXML
    private Label id;
    @FXML
    private Label description;
    @FXML
    private Label picture;
    @FXML
    private Label categorie;
    @FXML
    private Button supp;
  
 
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    // TODO

    void setData(Event ev) {

        this.ev = ev;
        id.setText(String.valueOf(ev.getId()));
        categorie.setText(String.valueOf(ev.getCategorie()));
        name.setText(ev.getName());
        date.setText(ev.getDate());
        lieu.setText(ev.getLieu());
                description.setText(ev.getDescription());
                        picture.setText(ev.getPicture());
       
        System.out.println("mmmm");
        upd.setOnAction(
                event -> {
//                    try { 

try {
//            root = FXMLLoader.load(getClass().getResource("commentgrid.fxml"));
//            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//        }
                        switchToEditPage(event, ev);
                    } catch (IOException ex) {

                    }
                }
        );
        //  idpost.setText(String.valueOf(comment.getId_post()));

    }

    @FXML
   private void delete(ActionEvent event) {

        ServiceE scomment = new ServiceE();
        scomment.arch(ev);

        try {
            root = FXMLLoader.load(getClass().getResource("eventaffichage.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }

    }

//    @FXML
//    public void pass() {
//        upd.setOnAction(kk -> {
//            ServiceRep scomment = new ServiceRep();
//            try {
//                root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
//            } catch (IOException ex) {
//
//            }
//            showAlert(Alert.AlertType.INFORMATION, ((Node) kk.getSource()).getScene().getWindow(),
//                    "go update!", "modifier votre commentaire");
//
//        });
//    }

    public void switchToEditPage(ActionEvent event, Event comment) throws IOException {
        switchPage(event, "updateevnt.fxml", comment);

    }

    public void switchPage(ActionEvent event, String path, Event comment) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setUserData(comment);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void switchToEditPage(ActionEvent event) {
    }
 
    

   


}
