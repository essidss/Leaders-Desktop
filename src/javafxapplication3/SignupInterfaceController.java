/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import static javafxapplication3.ImagePopupController.imgurl;
import Modal.User;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Random;
import Services.JavaMail;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author leith
 */
public class SignupInterfaceController implements Initializable{
    
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField confirmpassword;
    private Stage stage; 
    private Scene scene;
    private Parent root;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void switchImagePopup(ActionEvent event) throws IOException{
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("ImagePopup.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("choose avatar");
        stage.setScene(new Scene(root1));
        stage.show();
    }  
    
    @FXML
    private void ajouterUser(ActionEvent event) throws Exception{
        ServiceUser sp = new ServiceUser();
        Random rand = new Random();
        User s = new User(email.getText(),username.getText(),"[\"ROLE_USER\"]",password.getText(),imgurl,"Active");
        if((sp.ajouter(s)==true) && (email.getText()!="")&&(username.getText()!="")&&(password.getText()!="")){
        int n = rand.nextInt(50);
            JavaMail.send(
            "leithhamza.ghandri@esprit.tn",
            "211JMT2082",
            email.getText(),
            "Bienvenu sur GEEK",
            "bienvenue sur notre plateform");
         //   JavaMail.sendMail("leith.ghandri@gmail.com");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Test");
            alert.setHeaderText("You are succefully sing up.");
            alert.setResizable(false);
            alert.setContentText("Select okay or cancel this alert.");
            alert.showAndWait();
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("LoginInterface.fxml"));
                Parent root1= (Parent) fxmlloader.load();
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Login");
                stage.setScene(new Scene(root1));
                stage.show();
            }   
        }else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Account Doesn't Created");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("make sur for information");
            alert.show();
        }
    }
    
    @FXML
    private void Login(ActionEvent event) {
        String email2=email.getText();
        ServiceUser sp = new ServiceUser();
        User s = new User(email2,username.getText(),"Role_USER",password.getText(),imgurl,"Role_USE");
        sp.ajouter(s);
        System.out.print("dfgsdfg"+email.getText());
        
    }
    
    public void switchToLogin(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
                
    }  
      
    
}
