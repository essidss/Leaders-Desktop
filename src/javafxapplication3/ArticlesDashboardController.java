/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Posts;
import Modal.User;
import Services.ServicePosts;
import Services.ServiceUser;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
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
    private TableView<Posts> ArticleTable;

    @FXML
    private Button Articles;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TableColumn<Posts,Integer> culumnCategory;

    @FXML
    private TableColumn<Posts,String> culumnContent;

    @FXML
    private TableColumn<Posts,Integer> culumnDate;

    @FXML
    private TableColumn<Posts,String> culumnTitle;

    @FXML
    private TableColumn<Posts,Integer> culumnUsername;

    @FXML
    private ImageView delete;
@FXML
    private TableView<Posts> TableView;

    @FXML
    private TableColumn<Posts, Integer> idColumn;

    @FXML
    private TableColumn<Posts, String> titleColumn;

    @FXML
    private TableColumn<Posts, String> authorColumn;

    @FXML
    private TableColumn<Posts, Integer> yearColumn;

    @FXML
    private TableColumn<Posts, Integer> likdecolumn;
    @FXML
    private ComboBox<String> tfcategory;

    @FXML
    private TableColumn<Posts, Integer> categorycolumn;
    @FXML
    private TableView<Posts> table;    

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
    ObservableList<Posts> listM;
ServicePosts servicearticle =new ServicePosts();
    private volatile boolean stop=false;

    
    
    private Stage stage; 
    private Scene scene;
    private Parent root;


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
               ObservableList<Posts> list = getArticleList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Posts, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Posts, String>("content"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("date"));
        likdecolumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("liked"));
        categorycolumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("idcat"));

        TableView.setItems(list);
        
        choiceBox.getItems().add("title");
        choiceBox.getItems().add("author");
        choiceBox.getItems().add("date");   

showArticles();
 }   
 public void showArticles() {
        ObservableList<Posts> list = getArticleList();

        idColumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<Posts, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Posts, String>("content"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("date"));
        likdecolumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("liked"));
        categorycolumn.setCellValueFactory(new PropertyValueFactory<Posts, Integer>("idcat"));

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
                    Posts article= new Posts();
                    article=ArticleTable.getSelectionModel().getSelectedItem();
                    servicearticle.supprimer(article);
                    listM.removeAll(listM);
                    listM=(ObservableList<Posts>) servicearticle.afficher();
                    culumnTitle.setCellValueFactory(new PropertyValueFactory<Posts,String>("title"));
                    culumnUsername.setCellValueFactory(new PropertyValueFactory<Posts,Integer>("author"));
                    culumnContent.setCellValueFactory(new PropertyValueFactory<Posts,String>("content"));
                    culumnCategory.setCellValueFactory(new PropertyValueFactory<Posts,Integer>("idcat"));
                    culumnDate.setCellValueFactory(new PropertyValueFactory<Posts,Integer>("date"));

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
   public ObservableList<Posts> getArticleList() {
        ObservableList<Posts> articleList = FXCollections.observableArrayList();
        String query = "SELECT * FROM post WHERE archived='" + 0 + "' ";
        Statement st;
        ResultSet rs;

        try {
            st = cnx.createStatement();
            rs = st.executeQuery(query);
            Posts articles;
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
        return articleList;
    }
    
}
