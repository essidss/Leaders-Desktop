package GUI;

import Model.Annonce;
import Model.Annonce_Categorie;
import Services.MyListener;
import Services.ServiceAnnonce;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import utils.DataBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AnnonceDetailsController{
    private Connection cnx = DataBase.getInstance().getConnection();

    @FXML
    ImageView annonceimage;
    @FXML
    Label tfTitle;
    @FXML
    Label tfDescription;
    @FXML
    Label tfLocalisation;
    @FXML
    Label tfPrix;

    //private Image image;
    //private boolean update;
    private int annonceId;
    Annonce annonce;

    private List<Annonce> annonces = new ArrayList<>();
    
    ServiceAnnonce serviceAnnonce = new ServiceAnnonce();
    
    void setTextField(int id, String title, String description, String localisation, String prix, String image) {
        //System.out.println(id);
        annonceId=id;
            //System.out.println("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce" + annonce.getImage());
            try {
                Image image1 = new Image(new FileInputStream("C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce\\" + image));
                annonceimage.setImage(image1);
        }catch (FileNotFoundException ex){
        }
        
        tfTitle.setText(title);
        tfDescription.setText(description);
        tfLocalisation.setText(localisation);
        tfPrix.setText(prix);
    }
    
   /* public void deletebutton(ActionEvent event) throws SQLException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Annonce a = annonce;
        alert.setTitle("suppression");
        alert.setHeaderText("Etes-vous sur de vouloir supprimer cette catégorie : '"
                + a.getTitle() + "'  ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (a==null) {
            JOptionPane.showMessageDialog(null,"There is nothing selected !");
        } else if (result.get() == ButtonType.OK) {
            serviceAnnonce.delete(a);
        }

    }
   */
    
    
    /*public void switchToModifier(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ModifierAnnonce.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }*/
    
}
