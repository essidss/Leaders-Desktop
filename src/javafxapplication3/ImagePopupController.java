/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class ImagePopupController implements Initializable {
    
    DropShadow dropShadow = new DropShadow();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       dropShadow.setRadius(9.0);
       dropShadow.setOffsetX(9.0);
       dropShadow.setOffsetY(9.0);
    }   
    public static String imgurl;
    
    @FXML
    private ImageView logo1;
    @FXML
    private ImageView logo2;
    @FXML
    private ImageView logo3;
    @FXML
    private ImageView logo4;
    @FXML
    private ImageView logo5;
    @FXML
    private ImageView logo6;
    @FXML
    private ImageView logo7;
    @FXML
    private ImageView logo8;
    
    
    public void selectImage1(){
        imgurl="logo-1-1.png";
    }
    public void selectImage2(){
        imgurl="logo-1-2.png";
    }
    public void selectImage3(){
        imgurl="logo-1-3.png";
    }
    public void selectImage4(){
        imgurl="logo-1-4.png";
    }
    public void selectImage5(){
        imgurl="logo-1-5.png";
    }
    public void selectImage6(){
        imgurl="logo-1-6.png";
    }
    public void selectImage7(){
        imgurl="logo-1-7.png";
    }
    public void selectImage8(){
        imgurl="logo-1-8.png";
    }
    
    public void Enterimage1(){
        logo1.setEffect(dropShadow);
    }
    public void Exitimage1(){
        logo1.setEffect(null);
    }
    public void Enterimage2(){
        logo2.setEffect(dropShadow);
    }
    public void Exitimage2(){
        logo2.setEffect(null);
    }
    public void Enterimage3(){
        logo3.setEffect(dropShadow);
    }
    public void Exitimage3(){
        logo3.setEffect(null);
    }
    public void Enterimage4(){
        logo4.setEffect(dropShadow);
    }
    public void Exitimage4(){
        logo4.setEffect(null);
    }
    public void Enterimage5(){
        logo5.setEffect(dropShadow);
    }
    public void Exitimage5(){
        logo5.setEffect(null);
    }
    public void Enterimage6(){
        logo6.setEffect(dropShadow);
    }
    public void Exitimage6(){
        logo6.setEffect(null);
    }
    public void Enterimage7(){
        logo7.setEffect(dropShadow);
    }
    public void Exitimage7(){
        logo7.setEffect(null);
    }
    public void Enterimage8(){
        logo8.setEffect(dropShadow);
    }
    public void Exitimage8(){
        logo8.setEffect(null);
    }
     
    
}
