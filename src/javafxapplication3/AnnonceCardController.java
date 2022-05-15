package javafxapplication3;

import Modal.Annonce;
import Services.MyListener;
import Services.ServiceAnnonce;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Connectivity.ConnectionClass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import Modal.Annonce_Categorie;

public class AnnonceCardController{

    @FXML
    private VBox vboxcontainer;
    @FXML
    private VBox box;
    @FXML
    private ImageView annonceimage;

    @FXML
    private Label tfTitle;
    @FXML
    private Label tfLocalisation;
    @FXML
    private Label tfPrix;
    @FXML
    private Label tfCategorie;

    @FXML
    private Button showDetail;

    private Annonce annonce;
    private Annonce_Categorie cat;
    
    private int id;
    
    private List<Annonce> annonces = new ArrayList<>();
    private MyListener myListener;
   
    

    
    
    @FXML
    private void click (MouseEvent mouseEvent){
        myListener.onClickListener(this.annonce);
    }

    public void setData(Annonce annonce,MyListener myListener){
        
        this.myListener = myListener;
        this.annonce = annonce;
        
        Image image = null;
             
        try {
            System.out.println("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce" + annonce.getImage());
            image = new Image(new FileInputStream("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce\\" + annonce.getImage()));
        }catch (Exception ex){
        }
        annonceimage.setImage(image);
        tfTitle.setText(annonce.getTitle());
        tfLocalisation.setText(annonce.getLocalisation());
        tfPrix.setText(annonce.getPrix());
        //tfCategorie.setText(annonce.getCategorie());
    }
   
}
