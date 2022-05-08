/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Modal.User;
import Services.ServiceArticle;
import Services.ServiceUser;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ArticlesDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Connection cnx = ConnectionClass.getInstance().getCnx();

 @FXML
    private TableView<Article> ArticleTable;

    @FXML
    private Button Articles;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableColumn<Article,Integer> culumnCategory;

    @FXML
    private TableColumn<Article,String> culumnContent;

    @FXML
    private TableColumn<Article,Integer> culumnDate;

    @FXML
    private TableColumn<Article,String> culumnTitle;

    @FXML
    private TableColumn<Article,Integer> culumnUsername;

    @FXML
    private ImageView delete;
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
    private TableColumn<Article, Integer> likdecolumn;
    @FXML
    private ComboBox<String> tfcategory;

    @FXML
    private TableColumn<Article, Integer> categorycolumn;
    @FXML
    private TableView<Article> table;    

    @FXML
    private Button frontteam;

    @FXML
    private ImageView pdf;

    @FXML
    private ImageView refresh;

    @FXML
    private TextField search;

    @FXML
    private Button team;

    @FXML
    private Label time;

    @FXML
    private Button user;
    ObservableList<Article> listM;
ServiceArticle servicearticle =new ServiceArticle();
    private volatile boolean stop=false;

    
    
    private Stage stage; 
    private Scene scene;
    private Parent root;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
               ObservableList<Article> list = getArticleList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("content"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("date"));
        likdecolumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("liked"));
        categorycolumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("idcat"));

        TableView.setItems(list);
        
        choiceBox.getItems().add("title");
        choiceBox.getItems().add("author");
        choiceBox.getItems().add("date");   

showArticles();
 }   
 public void showArticles() {
        ObservableList<Article> list = getArticleList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Article, String>("content"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("date"));
        likdecolumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("liked"));
        categorycolumn.setCellValueFactory(new PropertyValueFactory<Article, Integer>("idcat"));

        TableView.setItems(list);
    } 


@FXML
    void search(KeyEvent event) {

    }

   @FXML
    public void supp(){
        delete.setOnMouseClicked(e->{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete ?");
            Optional <ButtonType> action =alert.showAndWait();
            if(action.get()==ButtonType.OK){
                    Article article= new Article();
                    article=ArticleTable.getSelectionModel().getSelectedItem();
                    servicearticle.supprimer(article);
                    listM.removeAll(listM);
                    listM=(ObservableList<Article>) servicearticle.afficher();
                    culumnTitle.setCellValueFactory(new PropertyValueFactory<Article,String>("title"));
                    culumnUsername.setCellValueFactory(new PropertyValueFactory<Article,Integer>("author"));
                    culumnContent.setCellValueFactory(new PropertyValueFactory<Article,String>("content"));
                    culumnCategory.setCellValueFactory(new PropertyValueFactory<Article,Integer>("idcat"));
                    culumnDate.setCellValueFactory(new PropertyValueFactory<Article,Integer>("date"));

                   ArticleTable.setItems(listM);
            }
            
        });   
    }

private void time(){
        Thread thread =new Thread(()->{
            SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
            while(!stop){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.err.print(e);
                }
                final String timenow =d.format(new Date());
                Platform.runLater(()->{
                    time.setText(timenow);
                });
            }
        });
        thread.start();
    }
    
    @FXML
    void switchToFront(ActionEvent event) throws IOException {
   root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToTeam(ActionEvent event) throws IOException {
     root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToUser(ActionEvent event) throws IOException {
 root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void tree(MouseEvent event) {

    }
  public ObservableList<Article> getArticleList() {
        ObservableList<Article> articleList = FXCollections.observableArrayList();
         String query = "SELECT article.id,article.title,article.content ,article.date,article.liked,article.idcat FROM article WHERE archived='" + 0 + "'  ";
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
    
}
