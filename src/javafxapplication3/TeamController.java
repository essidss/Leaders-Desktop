/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Modal.Team;
import Services.ServiceTeam;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TeamController implements Initializable {
    private List<Team> teams;

  Popup popup = new Popup();
 private Stage stage; 
    private Scene scene;
    private Parent root;
    
    ServiceTeam serviceTeam =new ServiceTeam();
    ServiceUser serviceUser =new ServiceUser();

    /**
     * Initializes the controller class.
     */
@FXML
    private Button addblog;

    @FXML
    private GridPane bookContainer;

    @FXML
    private Label categorie;

    @FXML
    private Button dash;

    @FXML
    private ImageView profil;

    @FXML
    private Button signout;

    @FXML
    private Button team;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        teams = new ArrayList<>(serviceTeam.afficher());

        int colum = 0;
        int row = 1;
        try {

             
            for (Iterator<Team> i = teams.iterator(); i.hasNext();) {
                Team item = i.next();
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("Teamcard.fxml"));
                VBox box1 = fxmlLoader1.load();
                TeamcardController articleController = fxmlLoader1.getController();
                //System.out.println(item);
                articleController.setTeam(item);

                if (colum == 1) {
                    colum = 0;
                    row++;
                }
                bookContainer.add(box1, colum++, row);
                GridPane.setMargin(box1, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // TODO
    }    
public void switchToDash(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
      public void Home(MouseEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
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
    public void logout(ActionEvent event) throws IOException{
        serviceUser.logout();
        root = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();    
    }

    
}
