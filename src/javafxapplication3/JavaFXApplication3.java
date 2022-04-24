/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package javafxapplication3;

import Modal.Article;
import Services.ServiceArticle;
import Services.ServiceComment;
import java.util.ArrayList;
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
        Parent root = FXMLLoader.load(getClass().getResource("post.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      launch(args);
ServiceArticle ps = new ServiceArticle();
      Article t = new Article(32);
 
  System.out.print(ps.getArticle(t).toString());
List<Article> list = (ArrayList)ps.afficher();
ServiceComment sc = new ServiceComment();
   t.setId(32);
  System.out.print(sc.afficher(t).toString());
     //ps.supprimer(t);
    // System.out.print(ps.afficher().toString());
                       //list.stream().filter(e -> e.getTitle().equals("mahdi")).forEach(e -> System.out.println(e));

    }
    
}
