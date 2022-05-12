


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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import Model.Event;
import javafx.stage.Stage;
import Services.ServiceE;
import javafx.scene.control.TextArea;


public class UpdateevntController implements Initializable {

    @FXML
   private Button update;
    private javafx.stage.Stage stage;
    private Scene scene;
    private Parent root;
    private int countEvents = 0;
    private Event ev;
    @FXML
    private TextField name;
    @FXML
    private TextField date;
    @FXML
    private TextField lieu;
    @FXML
    private TextArea description;
    @FXML
    private TextField picture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
 @FXML
    private void modifier(ActionEvent event) {
              ServiceE spost = new ServiceE();
        ev.setName(name.getText());
        ev.setDate(date.getText());
          ev.setLieu(lieu.getText());
            ev.setDescription(description.getText());
              ev.setPicture(picture.getText());
               
        spost.modifierEvent(ev);
        try {
            root = FXMLLoader.load(getClass().getResource("eventaffichage.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {

        }
    }

    @FXML
    private void receiveData(MouseEvent event) {

        if (countEvents == 0) { // Step 1
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            // Step 2
            Event c = (Event) stage.getUserData();
            ev = c;
            // Step 3
            name.setText(c.getName());
            date.setText(c.getDate());
             lieu.setText(c.getLieu());
              description.setText(c.getDescription());
               picture.setText(c.getPicture());
                
            //txtEmail.setText(u.getEmail());

            countEvents++;

        }

    }

    private void rett(ActionEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("eventaffichage.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
    }

    @FXML
    private void retour(ActionEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("eventaffichage.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       
    @FXML
       public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Eventaffichage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToEventCategorie(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("categoriegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToListReponse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToClaims(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reclamationgridBack.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
