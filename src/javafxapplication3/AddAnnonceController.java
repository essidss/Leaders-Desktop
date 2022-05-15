package javafxapplication3;

import Modal.Annonce;
import Modal.Annonce_Categorie;

import Services.ServiceAnnonce;
import Services.ServiceCategorie;
import Services.IServiceCategorie;
import Services.IService;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.*;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import java.util.stream.Collectors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import Connectivity.copyImage;
import Services.IService_1;

/**
 * FXML Controller class
 * 
 * @author abdallah
 */

public class AddAnnonceController implements Initializable {

    @FXML
    private TextField tfTitle;
    @FXML
    private TextArea tfDescription;
    @FXML
    private TextField tfImage;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfLocalisation;
    @FXML
    private ComboBox<String> tfCategorie;

    @FXML
    private Button btnImporter;
    @FXML
    private Text label_photo;
    @FXML
    private Button btnAjouter;

    private IService_1 serviceannonce= new ServiceAnnonce();
    private IServiceCategorie servicecategorie = new ServiceCategorie();

    private String absolutePathPhotoAnnonce;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> combolist = new ArrayList<>();
        combolist= servicecategorie.getall().stream().map(Annonce_Categorie::getNom).collect(Collectors.toList());
        tfCategorie.getItems().addAll(combolist);

    }

    @FXML
    private void AddAnnonce(ActionEvent event) throws SQLException, IOException {
        Annonce annonce = new Annonce();

        if (!tfTitle.getText().equals("") && !tfDescription.getText().equals("")&& !label_photo.getText().equals("")&& !tfPrix.getText().equals("") && !tfTel.getText().equals("")&& !tfEmail.getText().equals("")&& !tfLocalisation.getText().equals("") && !tfCategorie.getSelectionModel().equals("")){


            annonce.setTitle(tfTitle.getText());
            annonce.setDescription(tfDescription.getText());
            annonce.setImage(label_photo.getText());
            annonce.setPrix(tfPrix.getText());
            annonce.setTel(Integer.parseInt(tfTel.getText()));
            annonce.setEmail(tfEmail.getText());
            annonce.setLocalisation(tfLocalisation.getText());
            String nom = tfCategorie.getSelectionModel().getSelectedItem();
            annonce.setCategorie(nom);

            annonce.setId_categorie(servicecategorie.getall().stream().filter(e->e.getNom().equals(nom)).map(Annonce_Categorie::getId).collect(Collectors.toList()).get(0));
            copyImage.deplacerVers(label_photo, absolutePathPhotoAnnonce, "C:\\Users\\aboud\\Desktop\\GESTION_ANNONCE\\src\\imgAnnonce");
            System.out.println(annonce.toString());
            serviceannonce.add(annonce);
            Stage s = (Stage) tfTitle.getScene().getWindow();
            successNotification();
            Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Annonce");
            stage.setScene(scene);
            stage.show();
        }else {
            errorNotification();
        }
    }

    public void switchToListe(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void successNotification(){
        Image img = new Image("/img/icons8-tick-64.png");

        Notifications notificationBuilder = Notifications.create()
                .title("Annonce Notification")
                .text("Votre Annonce a été ajouter !")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(5))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void errorNotification(){
        Image img = new Image("/img/icons8-cross-mark-64.png");

        Notifications notificationBuilder = Notifications.create()
                .title("Annonce Notification")
                .text("Remplir tous les Champs!")
                .graphic(new ImageView(img))
                .hideAfter(Duration.seconds(3))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    void photoAnnonceChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        btnImporter.setOnAction(e -> {
            File choix = fileChooser.showOpenDialog(null);
            if (choix != null) {
                System.out.println(choix.getAbsolutePath());
                absolutePathPhotoAnnonce = choix.getAbsolutePath();
                //System.out.println("TEST" + absolutePathPhotoAnnonce);
                label_photo.setText(choix.getName());

            } else {
                System.out.println("Image introuvable");
            }
        });

    }
    
    public void switchToFront(MouseEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
}
