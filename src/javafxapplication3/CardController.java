/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Modal.Article;
import Modal.Category;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private HBox box;
    private ImageView ArticleImage;

    @FXML
    private Label articleName;

    @FXML
    private Label author;

    private Label date;


    private   String[] colors = {"B9E5FF'", "BDB2FE", "FB9AA8", "FF5056"};
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    

        // TODO
    }

 public void setArticle(Article article) {
        //Image image = new Image(getClass().getResourceAsStream(article.getImage()));
       // ArticleImage.setImage(image);
        articleName.setText(article.getTitle());
        author.setText(article.getContent());
        // box.setStyle("-fx-background-color:#" + colors[(int)(Math.random()*colors.length)]);
  }

  

}
