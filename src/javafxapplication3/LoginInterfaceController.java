package javafxapplication3;

import Services.LoginSession;
import Services.ServiceUser;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginInterfaceController  {

    
    private Stage stage; 
    private Scene scene;
    private Parent root;
    @FXML
    private Hyperlink signuplink;
    @FXML
    private TextField logemail;
    @FXML
    private TextField logpassword;
    
    public void switchToSignUp(ActionEvent event) throws IOException{
      
        root = FXMLLoader.load(getClass().getResource("SignupInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
                
    }  
    
    public void Login(ActionEvent event) throws IOException{
        
        String email=logemail.getText();
        String password=logpassword.getText();
        ServiceUser sp = new ServiceUser();
        if((sp.login(email, password)==true)&&(email!="")&&(password!="")){
            root = FXMLLoader.load(getClass().getResource("Front.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Front");
            stage.setScene(scene);
            stage.show();
        }else{
            System.out.print("nnnnnnnn"+LoginSession.UID);
        }
                
    }  
}
