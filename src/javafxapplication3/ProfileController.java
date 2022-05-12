/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import Modal.User;
import Services.LoginSession;
import Services.ServiceUser;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class ProfileController implements Initializable {

    @FXML
    private Button btnedit;

    @FXML
    private ImageView imgprof;

    @FXML
    private TextField labemail;

    @FXML
    private TextField labpassword;

    @FXML
    private TextField labusername;
public String urll;
    /**
     * Initializes the controller class.
     */
ServiceUser serviceUser =new ServiceUser();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    File file = new File("C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\images\\"+LoginSession.avatar);
           try {
               String localUrl = file.toURI().toURL().toString();
               imgprof.setFitHeight(150);
               imgprof.setFitWidth(150);
               Image image = new Image(localUrl);
               imgprof.setImage(image);
               System.err.println(",hjbkjh kjgk"+LoginSession.avatar);
               
           } catch (MalformedURLException ex) {
               System.out.println(ex);;
           }
            labemail.setText(LoginSession.Email);
            labusername.setText(LoginSession.Username);
            labpassword.setText(LoginSession.Password);
    }    
    
    public void editprofile(){
        User user=new User(labemail.getText(),labusername.getText(),"Role_USER",labpassword.getText());
        serviceUser.modifier(LoginSession.Email,user);
        LoginSession.Username=labusername.getText();
        LoginSession.Password=labpassword.getText();
        LoginSession.Email=labemail.getText();
        
        
    }
    
    
}
