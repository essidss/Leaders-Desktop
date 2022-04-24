/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Modal.Post;
import Modal.Reactions;
import Services.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ArticleController implements Initializable {

    private Connection cnx = ConnectionClass.getInstance().getCnx();
    private List<Article> articles;
    ServiceArticle servicearticle = new ServiceArticle();

    /**
     * Initializes the controller class.
     */
    @FXML
    private VBox vboxcontainer;
    @FXML
    private ImageView imgReaction;
    @FXML
    private VBox box;
    @FXML
    private ImageView bookimage;

    @FXML
    private Label booktitle;
    @FXML
    private Label reactionName;
    @FXML
    private Label bookauthor;
    private String[] colors = {"B9E5FF'", "BDB2FE", "FB9AA8", "FF5056"};
    private Reactions currentReaction;

    @FXML
    private Button show;
    private Post post;
    private long startTime = 0;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
    }

    public void onLikeContainerPressed(MouseEvent me) {
        startTime = System.currentTimeMillis();
    }

    @FXML
    public void onLikeContainerMouseReleased(MouseEvent me) {

        if (currentReaction == Reactions.NON) {
            setReaction(Reactions.LIKE);
        } else {
            setReaction(Reactions.NON);
        }

    }

    public void setReaction(Reactions reaction) {
        Image image = new Image(getClass().getResourceAsStream(reaction.getImgSrc()));
        imgReaction.setImage(image);
        reactionName.setText(reaction.getName());
        reactionName.setTextFill(Color.web(reaction.getColor()));

        
        currentReaction = reaction;

       

        //nbReactions.setText(String.valueOf(post.getTotalReactions()));
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

    public void setData(Article article) {

      
        ObservableList<Article> list = getArticleList();
        ServiceArticle sp = new ServiceArticle();
        Date date = new Date();
        Article p1 = new Article(19, "aa", "bb", date, 0, 0);
        // Article p = new Article(getArticleList());
        booktitle.setText(article.getTitle());
        bookauthor.setText(article.getContent());
         
 
        /*        for (Iterator<Article> i = articles.iterator(); i.hasNext();) {
            Article item = i.next();
          booktitle.setText(item.getTitle());
            bookauthor.setText(item.getContent());
           
       }*/
        booktitle.setLabelFor(bookimage);
DropShadow drop_shadow = new DropShadow(10, Color.RED);
box.setEffect(drop_shadow);

//        Image image = new Image(getClass().getResourceAsStream(article.getImage()));
        //       bookimage.setImage(image);
        // booktitle.setText(p1.getTitle());
        // bookauthor.setText(p1.getContent());

        // date.setText(article.getDate().toString());
    }

    public static Article getArticlers(ResultSet rs) throws SQLException {
        Article emp = null;
        if (rs.next()) {
            emp = new Article();
            emp.setId(rs.getInt("id"));
            emp.setTitle(rs.getString("title"));
            emp.setContent(rs.getString("content"));

        }
        return emp;
    }

@FXML
    private void show(ActionEvent event) throws IOException {
      Parent home_page_parent = FXMLLoader.load(getClass().getResource("post.fxml"));
     Scene home_page_scene = new Scene(home_page_parent);
     Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

     app_stage.hide(); //optional
     app_stage.setScene(home_page_scene);
     app_stage.show();
    //  String source2 = event.getPickResult().getIntersectedNode().getId(); //returns JUST the id of the object that was clicked

       /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Addblog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();*/

    }

}
