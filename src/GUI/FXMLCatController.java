
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
import Model.Event;
import Model.Categorie;
import Services.ServiceE;
import Services.ServiceC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLCatController implements Initializable {

  
    
    private Categorie cat;
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
    private Label name;
    @FXML
    private Label description;
   

 

 
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

    void setData(Categorie cat) {
  this.cat = cat;
         id.setText(String.valueOf(cat.getId()));
        name.setText(cat.getName());
         description.setText(cat.getDescription());
        
       
        
         upd.setOnAction(
                 
                event -> {
            try {
                System.out.println("jjjjjjjjj");
                switchToEditPage(event, cat);
            } catch (IOException ex) {
            }
                }
        );
        //  idpost.setText(String.valueOf(comment.getId_post()));

    }

    @FXML
   private void delete(ActionEvent event) {

        ServiceC scomment = new ServiceC();
        scomment.arch(cat);

        try {
            root = FXMLLoader.load(getClass().getResource("categoriegrid.fxml"));
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

    public void switchToEditPage(ActionEvent event, Categorie comment) throws IOException {
        switchPage(event, "./modifiercat.fxml", comment);

    }

    public void switchPage(ActionEvent event, String path, Categorie comment) throws IOException {

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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     @FXML
//    private void delete(ActionEvent event) {
//    ServiceC scomment = new ServiceC();
//    scomment.arch(cat);
//  //Categorie c = .getSelectionModel().getSelectedItem();
//  // int idd = Integer.parseInt(idddd.getText());
//
//    ObservableList<Categorie> list = FXCollections.observableArrayList(scomment.afficherCategorie());
//
//    //tableCategorie.setItems(list);
//  //LBshow.setText("aa"); 
//  //LBshow.setText("aa");
//    }   
//}






    
    
}
    
    
    
    
    
    
    
    
    
    
