/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Posts;
import Services.ServicePosts;
import Services.ServiceTeam;
import Services.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLArticlesController implements Initializable {

    private Connection cnx = ConnectionClass.getInstance().getCnx();

    /**
     * Initializes the controller class.
     */
    private List<Posts> recentlyadded;
    private List<Posts> articles;
    @FXML
    private TextField idField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField pagesField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private ImageView ArticleImage;
    @FXML
    private GridPane bookContainer;

    @FXML
    private Label articleName;

    @FXML
    private Label author;

    @FXML
    private Label date;
    @FXML
    private Button addblog;

    @FXML
    private ImageView nbrelikes;

    private String[] colors = {"B9E5FF'", "BDB2FE", "FB9AA8", "FF5056"};
    @FXML
    private HBox cardlayout;
    Popup popup = new Popup();
    private Stage stage;
    private Scene scene;
    private Parent root;

    ServiceTeam serviceTeam = new ServiceTeam();
    ServiceUser serviceUser = new ServiceUser();
    MediaPlayer mediaplayer;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            music();
        } catch (Exception e) {
            e.printStackTrace();

        }
        ServicePosts sp = new ServicePosts();
        recentlyadded = new ArrayList<>(recentlyadded());
        articles = new ArrayList<>(sp.getArticle());

        int colum = 0;
        int row = 1;
        try {

            for (Posts value : recentlyadded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));

                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setArticle(value);
                cardlayout.getChildren().add(cardBox);
            }
            for (Iterator<Posts> i = articles.iterator(); i.hasNext();) {
                Posts item = i.next();
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("article.fxml"));
                VBox bookBox = fxmlLoader1.load();
                ArticleController articleController = fxmlLoader1.getController();
                //System.out.println(item);
                articleController.setData(item);

                if (colum == 4) {
                    colum = 0;
                    row++;
                }
                bookContainer.add(bookBox, colum++, row);
                GridPane.setMargin(bookBox, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO  
        //showArticles();
    }

    public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("./src/Connectivity/music.wav");
        AudioInputStream audiostream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audiostream);
        clip.start();

    }

    @FXML
    private void showcategorie(MouseEvent event) throws IOException {


        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CategorieList.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();*/
        Parent window3; //we need to load the layout that we want to swap
        window3 = FXMLLoader.load(getClass().getResource("CategorieList.fxml"));
        Scene newScene; //then we create a new scene with our new layout
        newScene = new Scene(window3);
        Stage mainWindow; //Here is the magic. We get the reference to main Stage.
        mainWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();

        mainWindow.setScene(newScene); //here we simply set the new scene

    }

    @FXML

    public void addblog(ActionEvent event) throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Addblog.fxml"));
        Parent root1 = (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Add Article");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    private List<Posts> recentlyadded() {
        List<Posts> ls = new ArrayList<>();
        Posts article = new Posts();
        article.setTitle("Rich dad poor dad");
        article.setPicture("/img/glad.jpg");
        article.setContent("MAHDI \nZALTNI");
        Date d = new Date();
        article.setCreated_at(d);

        ls.add(article);

        article = new Posts();
        article.setTitle("The Hound Of The Baskervilles ");
        article.setPicture("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);

        article = new Posts();
        article.setTitle("les Miserables ");
        article.setPicture("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);
        return ls;

    }

    public ObservableList<Posts> getArticleList() {
        ObservableList<Posts> articleList = FXCollections.observableArrayList();
        String query = "SELECT * FROM posts WHERE archived='" + 0 + "' ";
        Statement st;
        ResultSet rs;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Posts p = new Posts();

                p.setId(rs.getInt(1));
                p.setTitle(rs.getString("title"));
                p.setContent(rs.getString("content"));
                p.setObjet(rs.getString("objet"));
                p.setArchived(rs.getString("archived"));
                p.setPicture(rs.getString("picture"));
                p.setCreated_at(rs.getDate("created_at"));
                p.setIdcat(rs.getInt("idcat"));
                p.setUser_id(rs.getInt("user_id"));
                p.setNblikes(rs.getInt("nblikes"));
                articleList.add(p);
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        System.out.println("javafxapplication3.FXMLArticlesController.getArticleList()" + articleList);
        return articleList;
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
