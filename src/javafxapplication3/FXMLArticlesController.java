/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Services.ServiceArticle;
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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

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
    private List<Article> recentlyadded;
    private List<Article> articles;
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
    private TableView<Article> TableView;

    @FXML
    private TableColumn<Article, Integer> idColumn;

    @FXML
    private TableColumn<Article, String> titleColumn;

    @FXML
    private TableColumn<Article, String> authorColumn;

    @FXML
    private TableColumn<Article, Integer> yearColumn;

    @FXML
    private TableColumn<Article, Integer> pagesColumn;

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
  
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recentlyadded = new ArrayList<>(recentlyadded());
        articles = new ArrayList<>(getArticleList());
 
        int colum = 0;
        int row = 1;
        try {
            
  for (Article value : recentlyadded) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("card.fxml"));

                HBox cardBox = fxmlLoader.load();
                CardController cardController = fxmlLoader.getController();
                cardController.setArticle(value);
                cardlayout.getChildren().add(cardBox);
                                  }
        for (Iterator<Article> i = articles.iterator(); i.hasNext();) {
                  Article item = i.next();
                FXMLLoader fxmlLoader1 = new FXMLLoader();
                fxmlLoader1.setLocation(getClass().getResource("article.fxml"));
                VBox bookBox = fxmlLoader1.load();
                ArticleController articleController = fxmlLoader1.getController();
                 //System.out.println(item);
                articleController.setData(item );
                
                if (colum == 5) {
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



 @FXML
    private void addblog(ActionEvent event) throws IOException {
     System.out.println("javafxapplication3.FXMLArticlesController.addblog()");
     Parent home_page_parent = FXMLLoader.load(getClass().getResource("Addblog.fxml"));
     Scene home_page_scene = new Scene(home_page_parent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

     app_stage.hide(); //optional
     app_stage.setScene(home_page_scene);
     app_stage.show();

       /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Addblog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();*/

    }

    private List<Article> recentlyadded() {
        List<Article> ls = new ArrayList<>();
        Article article = new Article();
        article.setTitle("Rich dad poor dad");
        article.setImage("/img/glad.jpg");
        article.setContent("MAHDI \nZALTNI");
Date d =new Date();
        article.setDate(d);

        ls.add(article);

        article = new Article();
        article.setTitle("The Hound Of The Baskervilles ");
        article.setImage("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);

        article = new Article();
        article.setTitle("les Miserables ");
        article.setImage("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);
        return ls;

    }

    private List<Article> articles() {

        List<Article> ls = new ArrayList<>();
        ObservableList<Article> list = getArticleList();

        /*Article article = new Article();
           Date date = new Date();
        Article p1 = new Article("mahdi", "zaltni", date, 0, 0);

        p1.setTitle(p1.getTitle());
        article.setImage("/img/glad.jpg");
        article.setContent("MAHDI \nZALTNI");
        ls.add(article);


        article = new Article();
        article.setTitle("The Hound Of The Baskervilles ");
        article.setImage("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);

        article = new Article();
        article.setTitle("les Miserables ");
        article.setImage("/img/mahdi.jpg");
        article.setContent("ARTHUR \nCONAN DWAYNE");
        ls.add(article);*/
        return list;

    }

    public ObservableList<Article> getArticleList() {
        ObservableList<Article> articleList = FXCollections.observableArrayList();
        String query = "SELECT * FROM article WHERE archived='" + 0 + "' ";
        Statement st;
        ResultSet rs;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            Article articles;
            while (rs.next()) {
                articles = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("content"), rs.getDate("date"), rs.getInt("liked"), rs.getInt("idcat"));
                articleList.add(articles);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articleList;
    }

    public void showArticles() {
        ObservableList<Article> list = getArticleList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("content"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("date"));
        pagesColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("liked"));

        TableView.setItems(list);
    }



}
