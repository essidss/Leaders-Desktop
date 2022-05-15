



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
import Modal.Reponse;
import Modal.Reclamation;
import javafx.stage.Stage;
import Services.ServiceRep;
import Services.ServiceReclam;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.StageStyle;








   





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
    @FXML
    private Button team;
    @FXML
    private Button btnAnnonces;
    @FXML
    private Button dash;
    @FXML
    private Button signout;
    @FXML
    private ImageView profil;

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

    
    
    
    
     @FXML
    public void switchToDash(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
      public void showblog(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLArticles.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
 public void showTeam(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Team.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
    public void switchProfilePopup() throws IOException{
        
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("Profile.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Profile");
        stage.setScene(new Scene(root1));
        stage.show();
    }  
   
    
    @FXML
    public void switchToAnnonces(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EventAffichageFront.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToReclamation(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Add_Reclamation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }


}

