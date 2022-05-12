package javafxapplication3;

import Services.LoginSession;
import Services.ServiceUser;
import java.awt.image.BufferedImage;
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
import javafx.scene.image.Image;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import nl.captcha.Captcha;


public class LoginInterfaceController implements Initializable  {

 Captcha captcha = new Captcha.Builder(200, 50)
           .addText()
           .addBackground()
           .addNoise()
           .addBorder()
           .build();

    
    private Stage stage; 
    private Scene scene;
    private Parent root;
    @FXML
    private Hyperlink signuplink;
    @FXML
    private TextField logemail;
    @FXML
    private TextField logpassword;
    @FXML
    private TextField tcaptcha;

    @FXML
    private ImageView icaptcha;

@Override
    public void initialize(URL url, ResourceBundle rb) {
        BufferedImage i = captcha.getImage();
        Image ii = SwingFXUtils.toFXImage(i, null);
        ImageView ll = new ImageView(ii);
        icaptcha.setImage(ii);
    }
    public void switchToSignUp(ActionEvent event) throws IOException{
      
        root = FXMLLoader.load(getClass().getResource("SignupInterface.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
                
    }  
    @FXML
    public void Login(ActionEvent event) throws IOException{
        
        String email=logemail.getText();
        String password=logpassword.getText();
        ServiceUser sp = new ServiceUser();
        if((sp.login(email, password)==true)&&(email!="")&&(password!="")&&(captcha.isCorrect(tcaptcha.getText()))){
            root = FXMLLoader.load(getClass().getResource("Front.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Front");
            stage.setScene(scene);
            stage.show();
        }else{
            try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/LoginInterface.fxml"));
                 Parent root = loader.load();
                 LoginInterfaceController mdc = loader.getController();
                 mdc.test(logemail.getText(),logpassword.getText());
                 Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                 Scene scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
        }catch(IOException ex){
            System.out.println(ex);
        
        }
        }   
    } 

    @FXML
    private void refCaptcha(MouseEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/LoginInterface.fxml"));
                 Parent root = loader.load();
                 LoginInterfaceController mdc = loader.getController();
                 mdc.test(logemail.getText(),logpassword.getText());
                Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                 Scene scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    public void test(String mail,String pass){
        logemail.setText(mail);
        logpassword.setText(pass);
    }
}
