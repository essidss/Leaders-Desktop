



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
import Model.Reponse;
import Model.Reclamation;
import javafx.stage.Stage;
import Services.ServiceRep;
import Services.ServiceReclam;
import javafx.scene.control.TextArea;








   





public class ModifierReclamController implements Initializable {

   
    @FXML
    private Button update;
    private javafx.stage.Stage stage;
    private Scene scene;
    private Parent root;
    private int countEvents = 0;
    private Reclamation reponse;
    @FXML
    private TextField tfsujet;
    @FXML
    private TextArea tfdescription;
    @FXML
    private TextField tfdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
 @FXML
    private void modifier(ActionEvent event) {
        ServiceReclam spost = new ServiceReclam();
        reponse.setSujet(tfsujet.getText());
        reponse.setDescription(tfdescription.getText());
        reponse.setDate(tfdate.getText());
        spost.modifierReclamation(reponse);
        try {
            root = FXMLLoader.load(getClass().getResource("reclamationgrid.fxml"));
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
            Reclamation c = (Reclamation) stage.getUserData();
            reponse = c;
            // Step 3
            tfsujet.setText(c.getSujet());
            tfdescription.setText(c.getDescription());
            tfdate.setText(c.getDate());
            //txtEmail.setText(u.getEmail());

            countEvents++;

        }

    }
    

    
    
    
    

    private void rett(ActionEvent event) {
          try {
            root = FXMLLoader.load(getClass().getResource("reclamationgrid.fxml"));
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
            root = FXMLLoader.load(getClass().getResource("reclamationgrid.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
    }

}

