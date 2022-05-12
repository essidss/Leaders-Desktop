/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Category;
import Services.ServiceTeam;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CategorieListController implements Initializable {

    private Connection cnx = ConnectionClass.getInstance().getCnx();

    /**
     * Initializes the controller class.
     */
    private List<Category> recentlyadded;
    private List<Category> categories;

    @FXML
    private GridPane bookContainer;
    @FXML
    private Label categorie;
    private Stage stage;
    private Scene scene;
    private Parent root;

    ServiceTeam serviceTeam = new ServiceTeam();
    ServiceUser serviceUser = new ServiceUser();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        categories = new ArrayList<>(getCategorieList());

        int colum = 0;
        int row = 1;
        try {

            for (Iterator<Category> i = categories.iterator(); i.hasNext();) {
                Category item = i.next();
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("categorie.fxml"));
                HBox cardBox = fxmlLoader1.load();
                CategorieController cardController = fxmlLoader1.getController();
                cardController.setArticle(item);
                // VBox bookBox = fxmlLoader1.load();
                //ArticleController articleController = fxmlLoader1.getController();
                //System.out.println(item);
                //articleController.setCategorie(item);

                if (colum == 2) {
                    colum = 0;
                    row++;
                }
                bookContainer.add(cardBox, colum++, row);
                GridPane.setMargin(cardBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
    }

    public ObservableList<Category> getCategorieList() {
        ObservableList<Category> categorilist = FXCollections.observableArrayList();
        String query = "SELECT * FROM category  Where archived=0 ";
        Statement st;
        ResultSet rs;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            Category categories;
            while (rs.next()) {
                categories = new Category(rs.getInt("idcat"), rs.getString("nom"));
                categorilist.add(categories);
            }
            System.out.println(categorilist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorilist;
    }

    @FXML
    void Acceuil(MouseEvent event) throws IOException {

        Parent window3; //we need to load the layout that we want to swap
        window3 = FXMLLoader.load(getClass().getResource("FXMLArticles.fxml"));

        Scene newScene; //then we create a new scene with our new layout
        newScene = new Scene(window3);

        Stage mainWindow; //Here is the magic. We get the reference to main Stage.
        mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        mainWindow.setScene(newScene); //here we simply set the new scene

    }

    @FXML
    void Addcategorie(ActionEvent event) throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Addcategorie.fxml"));
        Parent root1 = (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Add categorie");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    
    public void switchToDash(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();

    }

    public void Home(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();

    }

    public void switchProfilePopup() throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Profile.fxml"));
        Parent root1 = (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Profile");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    public void logout(ActionEvent event) throws IOException {
        serviceUser.logout();
        root = FXMLLoader.load(getClass().getResource("LoginInterface.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();
    }

}
