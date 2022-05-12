/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication3;

import Modal.Article;
import Modal.User;
import Services.ServiceArticle;
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

/*ServiceArticle ps = new ServiceArticle();
Date d = new Date();
      Article t = new Article( "mahdi","zaltni",d,"274585352-1134065580779382-2619872694102213168-n-624eac1879528.jpeg");
ps.ajouter(t);
 
  System.out.print(ps.getArticle().toString());
List<Article> list = (ArrayList)ps.afficher();
ServiceComment sc = new ServiceComment();
   t.setId(32);*/
  

    }
    
}
