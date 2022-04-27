package GUI;


import Model.Annonce;
import Model.Categorie;

import Services.ServiceAnnonce;
import Services.ServiceCategorie;
import Services.IServiceCategorie;
import Services.IService;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import Services.ServiceAnnonce;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import sun.font.FontRunIterator;
import utils.DataBase;

import javax.swing.plaf.nimbus.State;
import javax.xml.crypto.Data;

/**
 * FXML Controller class
 *
 * @author abdallah
 */
public class AnnonceController implements Initializable {

    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    private List<Annonce> annonces;


    private Connection cnx = DataBase.getInstance().getConnection();


    private List<Annonce> annonces(){
        ObservableList<Annonce> ls = FXCollections.observableArrayList();
        String query = "SELECT * FROM annonce";
        Statement st;
        ResultSet rs;

        try{
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            Annonce annonce;
            while(rs.next()){
                annonce = new Annonce (rs.getInt("id"),rs.getString("title"),rs.getString("description"),rs.getString("image"),rs.getString("prix"),rs.getInt("tel"),rs.getString("email"),rs.getString("localisation"),rs.getString("categorie_id"));
                ls.add(annonce);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return ls;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        annonces = new ArrayList<>(annonces());

        int columns = 0;
        int row = 1;
        try{
            for (int i=0 ; i< annonces.size(); i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("AnnonceCard.fxml"));
                VBox box = fxmlLoader.load();
                AnnonceCardController cardController = fxmlLoader.getController();
                cardController.setData(annonces.get(i));

                if (columns == 4){
                    columns = 0;
                    ++row;
                }
                grid.add(box,columns++,row);

                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(box,new Insets(10));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void switchToAdd(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AddAnnonce.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }


}
