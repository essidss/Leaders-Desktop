/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Modal.Category;
import Services.ServiceCategory;
import java.io.IOException;
import java.net.URL;
import static java.nio.file.Files.delete;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CategoriedashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
 @FXML
    private Button user;

    @FXML
    private Button team;

    @FXML
    private Button Articles;

    @FXML
    private Button Articles1;

    @FXML
    private TextField search;

    @FXML
    private ImageView pdf;

    @FXML
    private ImageView delete;

    @FXML
    private ImageView refresh;


    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private TableView<Category> usersTable;

    @FXML
    private TableColumn<Category, Integer> id;

    @FXML
    private TableColumn<Category, String> nom;

    @FXML
    private TableColumn<Category, Integer> idcat;

    @FXML
    private TableColumn<Category, Integer> archived;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ObservableList<Category> listM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ServiceCategory servicecategory = new ServiceCategory();
        ObservableList<Category> list = servicecategory.afficher();
        listM = servicecategory.afficher();

        id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<Category, String>("nom"));
        idcat.setCellValueFactory(new PropertyValueFactory<Category, Integer>("idcat"));
        archived.setCellValueFactory(new PropertyValueFactory<Category, Integer>("archived"));

        usersTable.setItems(list);

    }

    @FXML
    public void switchToTeam(ActionEvent event) throws IOException {

        /*root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();*/
        root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void tree() {
//        if(choiceBox.getSelectionModel().getSelectedItem().equals("username")){
//            listM=(ObservableList<User>) serviceUser.triWithUsername();
//            culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
//        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
//        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
//        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
//        usersTable.setItems(listM);
//        } 
    }

    @FXML
    public void switchToFront(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void switchToArticle(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("ArticlesDashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void supp() {
        delete.setOnMouseClicked(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete ?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                ServiceCategory servicecategory = new ServiceCategory();
                Category categorie = new Category();
                categorie = usersTable.getSelectionModel().getSelectedItem();
                servicecategory.supprimer(categorie);
                listM.removeAll(listM);
                listM = servicecategory.afficher();
                id.setCellValueFactory(new PropertyValueFactory<Category, Integer>("id"));
                nom.setCellValueFactory(new PropertyValueFactory<Category, String>("nom"));
                idcat.setCellValueFactory(new PropertyValueFactory<Category, Integer>("idcat"));
                archived.setCellValueFactory(new PropertyValueFactory<Category, Integer>("archived"));
                usersTable.setItems(listM);
            }

        });
    }

}
