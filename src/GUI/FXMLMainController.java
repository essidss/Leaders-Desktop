/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import utils.Session;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLMainController implements Initializable {

    

@FXML
    private Circle myCircle1;
    
@FXML
    private ScrollPane scrollPane;
    
@FXML
    private GridPane grid;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Button RECLAMATION;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
        

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLEvent.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();
            grid.add(anchorPane, 0, 1); //(child,column,row)
//                //set grid width
//                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
//                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                grid.setMaxWidth(Region.USE_PREF_SIZE);
//
//                //set grid height
//                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
//                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                grid.setMaxHeight(Region.USE_PREF_SIZE);

            GridPane.setMargin(anchorPane, new Insets(10));
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO
    }

  
@FXML
    private void switchToReclamation(ActionEvent event) {
        try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLReclamation.fxml"));
            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();
            grid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void switchToEvent(ActionEvent event) {
        try {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLEvent.fxml"));

            AnchorPane anchorPane;
            anchorPane = fxmlLoader.load();
            grid.setBackground(Background.EMPTY);
            grid.add(anchorPane, 0, 1);
        } catch (IOException ex) {
            Logger.getLogger(FXMLMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}