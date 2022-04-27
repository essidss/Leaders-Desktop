package GUI;

import Model.Annonce;
import Services.ServiceAnnonce;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import utils.DataBase;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.awt.event.ActionEvent;
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


public class AnnonceCardController {

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
    private Button showDetail;


    public void setData(Annonce annonce){
        Image image = null;
        try {
            System.out.println("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce" + annonce.getImage());
            image = new Image(new FileInputStream("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce\\" + annonce.getImage()));
        }catch (FileNotFoundException ex){
        }
        annonceimage.setImage(image);
        tfTitle.setText(annonce.getTitle());
        tfLocalisation.setText(annonce.getLocalisation());
        tfPrix.setText(annonce.getPrix());
    }


}
