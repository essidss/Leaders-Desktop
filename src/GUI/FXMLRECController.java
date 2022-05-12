///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package GUI;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.fxml.Initializable;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.stage.Window;
//import Model.Reponse;
//import Model.Reclamation;
//import Services.ServiceRep;
//import Services.ServiceReclam;
//import javafx.stage.Stage;
//
//
//public class FXMLRECController implements Initializable {
//
//  
//   
//    private Reclamation reclamation;
//    @FXML
//    private Button supp;
//    @FXML
//    private Button upd;
//    @FXML
//    private Label date;
//    @FXML
//    private Label id;
//    @FXML
//    private Label sujet;
//    @FXML
//    private Label description;
//
//
//    //private Parent root;
//    //private Label idpost;
//    /**
//     *
//     * Initializes the controller class.
//     */
//    private javafx.stage.Stage stage, stage1;
//    private Scene scene, scene1;
//    private Parent root, root1;
//   
// 
//    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
//        Alert alert = new Alert(alertType);
//        alert.setTitle(title);
//        alert.setHeaderText(null);
//        alert.setContentText(message);
//        alert.initOwner(owner);
//        alert.show();
//    }
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//    }
//    // TODO
//
//    void setData(Reclamation reclamation) {
//
//        this.reclamation = reclamation;
//       id.setText(String.valueOf(reclamation.getId()));
//        sujet.setText(reclamation.getSujet());
//        date.setText(reclamation.getDate());
//        description.setText(reclamation.getDescription());
//       
//        System.out.println("mmmm");
//        upd.setOnAction(
//                event -> {
////                    try { 
//
//try {
////            root = FXMLLoader.load(getClass().getResource("commentgrid.fxml"));
////            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
////            scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (IOException ex) {
////        }
//                        switchToEditPage(event, reclamation);
//                    } catch (IOException ex) {
//
//                    }
//                }
//        );
//        //  idpost.setText(String.valueOf(comment.getId_post()));
//
//    }
//
//    @FXML
//   private void delete(ActionEvent event) {
//
//        ServiceReclam scomment = new ServiceReclam();
//        scomment.supprimerReclamation(reclamation);
//
//        try {
//            root = FXMLLoader.load(getClass().getResource("reclamationgrid.fxml"));
//            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//        }
//
//    }
//
////    @FXML
////    public void pass() {
////        upd.setOnAction(kk -> {
////            ServiceRep scomment = new ServiceRep();
////            try {
////                root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
////            } catch (IOException ex) {
////
////            }
////            showAlert(Alert.AlertType.INFORMATION, ((Node) kk.getSource()).getScene().getWindow(),
////                    "go update!", "modifier votre commentaire");
////
////        });
////    }
//
//    public void switchToEditPage(ActionEvent event, Reclamation comment) throws IOException {
//        switchPage(event, "./modifierreponse.fxml", comment);
//
//    }
//
//    public void switchPage(ActionEvent event, String path, Reclamation comment) throws IOException {
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
//        Parent root = loader.load();
//
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//
//        stage.setUserData(comment);
//
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
// 
//    
//
//   
//
////    @FXML
////    private void delete(ActionEvent event) {
////    }
//
//    @FXML
//    private void switchToEditPage(ActionEvent event) {
//    }
//
//}



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import Model.Reponse;
import Model.Reclamation;
import Services.ServiceRep;
import Services.ServiceReclam;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLRECController implements Initializable {

  
    
    private Reclamation comment;
    @FXML
    private Button supp;
    @FXML
    private Button upd;

   @FXML
    private Label id;

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
    private Label tfsujet;
    @FXML
    private Label tfdate;
   
    @FXML
    private Label tddescription;
 

 
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

    void setData(Reclamation comment) {
  this.comment = comment;
  id.setText(String.valueOf(comment.getId()));
        tfsujet.setText(comment.getSujet());
        
        tddescription.setText(comment.getDescription());
        tfdate.setText(comment.getDate());
        
         upd.setOnAction(
                 
                event -> {
            try {
                System.out.println("jjjjjjjjj");
                switchToEditPage(event, comment);
            } catch (IOException ex) {
            }
                }
        );
        //  idpost.setText(String.valueOf(comment.getId_post()));

    }

    @FXML
   private void delete(ActionEvent event) {

        ServiceReclam scomment = new ServiceReclam();
        scomment.arch(comment);

        try {
            root = FXMLLoader.load(getClass().getResource("reclamationgrid.fxml"));
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

    public void switchToEditPage(ActionEvent event, Reclamation comment) throws IOException {
        switchPage(event, "./modifierReclam.fxml", comment);

    }

    public void switchPage(ActionEvent event, String path, Reclamation comment) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setUserData(comment);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
 
    

   

//    @FXML
//    private void delete(ActionEvent event) {
//    }

    @FXML
    private void switchToEditPage(ActionEvent event) {
    }

}
