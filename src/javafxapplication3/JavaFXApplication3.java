/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication3;

import Modal.Posts;
import Modal.User;
import Services.ServicePosts;
import Services.ServiceComment;
import Services.ServiceUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class JavaFXApplication3 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      launch(args);
      /* ServiceUser serviceUser =new ServiceUser();
       User  user = serviceUser.findByUserId(5);
  System.out.print(serviceUser.findByUserId(5).toString());*/

//ServicePosts ps = new ServicePosts();
//   ServiceUser ss = new ServiceUser();
//  System.out.print(ps.getArticle().toString());
 // System.out.print(ss.afficher().toString());

 
  

    }
    
}
