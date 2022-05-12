/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;



import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class FrontController implements Initializable {

    @FXML
    private Button team;
    @FXML
    private Button signout;
    @FXML
    private ImageView profil;
    @FXML
    private VBox vboxTeam;
    @FXML
    private Button dash;
    
    @FXML
    private Button btnAnnonces;
    
     private Stage stage; 
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* if(LoginSession.Role.equals("Role_USER")){
            dash.setDisable(true);
            dash.setVisible(false);
        }*/
    }    
    
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
   
    
    public void switchToAnnonces(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EventAffichageFront.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToReclamation(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Add_Reclamation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
}
