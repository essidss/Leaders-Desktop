/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Modal.Category;
import Modal.Post;
import Modal.Reactions;
import Services.LoginSession;
import Services.ServiceArticle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.controlsfx.control.Rating;
import org.json.JSONObject;

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
    private ImageView delete;

    @FXML
    private ImageView update;
    @FXML
    private Label view;
    @FXML
    private Label booktitle;
    @FXML
    private Label username;
    @FXML
    private Label likecount;
    @FXML
    private Label reactionName;
    @FXML
    private Label idArticle;
    @FXML
    private Label iduser;
    @FXML
    private Label msg;
    @FXML
    private TextField textrate;

    @FXML
    private Rating rate;
    @FXML
    private Label bookauthor;
    private String[] colors = {"B9E5FF'", "BDB2FE", "FB9AA8", "FF5056"};
    private Reactions currentReaction;

    @FXML
    private Button show;
    @FXML
    private Button deletebutton;
    private Post post;
    private long startTime = 0;
    private Parent root;
    private Stage stage;
    private Scene scene;

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        rating();
        msg.setVisible(false);
        textrate.setVisible(false);
 
     }

    @FXML
    public void rating() {

        rate.ratingProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            msg.setText("Rating : " + newValue);
            textrate.setText(String.valueOf(newValue));

        });

    }

public Boolean ISRATE(int id,int iduser)
{
try
{
    Statement stm = cnx.createStatement();
    String querry  = "SELECT * FROM `rating` WHERE user_id='"+iduser+"' and post_id="+ idArticle.getText() +"";
                 ResultSet rs= stm.executeQuery(querry);
if (rs.isBeforeFirst()){
    System.out.println("rate already exists");
return true;
}

}catch (SQLException ex) {
        System.out.print(ex);
        }
return false;

}
    @FXML
    void rate(MouseEvent event) {
 
int id = Integer.parseInt(String.valueOf(idArticle.getText()));
        if (ISRATE(id,LoginSession.UID)==true)
{
    System.out.println("vous avez deja rater cet article");
      String query1 = "update rating  set nbr_etoiles='" + textrate.getText() + "' WHERE post_id=" + idArticle.getText() + " and user_id='"+LoginSession.UID+"'";
        executeQuery(query1);
}  

if (ISRATE(157,LoginSession.UID)==false) {
         String query = "INSERT INTO rating ( nbr_etoiles, post_id,user_id ) VALUES ('" + textrate.getText() + "' ,(SELECT id FROM article WHERE id=" + idArticle.getText() + " ),'"+LoginSession.UID+"')";
        executeQuery(query);
}

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
            // e.printStackTrace();
        }
        return articleList;
    }

    public void setData(Article article) {
        Image image = null;
        try {
            System.out.println("C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\img\\" + article.getImage());
            image = new Image(new FileInputStream("C:\\Users\\hp\\Documents\\NetBeansProjects\\JavaFXApplication3\\src\\img\\" + article.getImage()));
        } catch (FileNotFoundException ex) {
        }
        // ServiceUser serviceUser =new ServiceUser();
        // User  user = serviceUser.findByUserId(article.getUser_id());
        bookimage.setImage(image);

         booktitle.setText(article.getTitle());
//        username.setText(user.getUsername());
        //  System.out.println(""+user.getUsername());
//        bookauthor.setText(article.getContent());
        //booktitle.setVisible(false);
        idArticle.setText((String.valueOf(article.getId())));
        idArticle.setVisible(false);
        iduser.setText((String.valueOf(article.getUser_id())));
        iduser.setVisible(false);
        view.setText((String.valueOf(article.getNbShares())));

        if (LoginSession.UID == article.getUser_id()) {
            delete.setVisible(true);
            update.setVisible(true);
        } else {
            delete.setVisible(false);
            update.setVisible(false);
        }

        //idArticle.setText(Integer.toString(article.getId()));
        //booktitle.setLabelFor(bookimage);
        //DropShadow drop_shadow = new DropShadow(10, Color.RED);
        //box.setEffect(drop_shadow);
        //bookimage.setImage(article.getImage());
        // Image image = new Image(getClass().getResourceAsStream(article.getImage()));
        //  bookimage.setImage(image);
        // booktitle.setText(p1.getTitle());
        // bookauthor.setText(p1.getContent());
        // date.setText(article.getDate().toString());
    }

//    public String cencor(String str) {
//        String filtr = "";
//        try {
//            OkHttpClient client = new OkHttpClient().newBuilder().build();
//
//            MediaType mediaType = MediaType.parse("text/plain");
//            RequestBody body = RequestBody.create(mediaType, str);
//
//            Request request = new Request.Builder()
//                    .url("https://api.apilayer.com/bad_words?censor_character=*")
//                    .addHeader("apikey", "bK0CAJq4AYqZCOPxebV2DinhTaCiD0LR")
//                    .method("POST", body)
//                    .build();
//            Response response = client.newCall(request).execute();
//            JSONObject jArray = new JSONObject(response.body().string());
//            //               System.out.println(response.body().string());
//            String deviceId = (String) jArray.toString();
//            System.out.println(deviceId);
//            return jArray.get("censored_content").toString();
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return filtr;
//    }

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

    public void setCategorie(Category c) {
        booktitle.setText(c.getNom());
        //bookauthor.setText(c.getContent());
        //booktitle.setVisible(false);
        idArticle.setText((String.valueOf(c.getIdcat())));
        //idArticle.setVisible(false);

    }

    @FXML
    private void show(MouseEvent event) throws IOException {

        // Parent
        //home_page_parent = FXMLLoader.load(getClass().getResource("post.fxml"));
        String title = booktitle.getText();
        int id = Integer.parseInt(idArticle.getText());
        ServiceArticle sp = new ServiceArticle();
        Article article = sp.findByArticleId(id);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("post.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        sp.setView(id);
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("post.fxml"));
        //root = loader.load();
        PostController postcontroller = fxmlLoader.getController();
        postcontroller.setData(article);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();
        //scene = new Scene(root);
        //stage.setScene(scene);
        // stage.show();
        //  Scene home_page_scene = new Scene(home_page_parent);
        //  Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // app_stage.hide(); //optional
        // app_stage.setScene(home_page_scene);
        // app_stage.show();
        //  String source2 = event.getPickResult().getIntersectedNode().getId(); //returns JUST the id of the object that was clicked

        /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Addblog.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));  
        stage.show();*/
    }

    public void deletebutton() {

        String query = "UPDATE `article` SET `archived`='" + 1 + "' WHERE id=" + idArticle.getText() + "";
        executeQuery(query);
box.getChildren().clear();


    }

    @FXML
    public void updatebutton(MouseEvent event) {
        try {
            String title = booktitle.getText();
            int id = Integer.parseInt(idArticle.getText());
            ServiceArticle sp = new ServiceArticle();

            Article article = sp.findByArticleId(id);

//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifierblog.fxml"));
//            root = loader.load();
//            ModifierblogController modif = loader.getController();
//            modif.setData(article);
////           PostController postcontroller = loader.getController();
//            //postcontroller.setArticle(title);
//            // postcontroller.setData(article);
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifierblog.fxml"));
            Parent root = (Parent) loader.load();

            ModifierblogController modif = loader.getController();
            modif.setData(article);
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED);
            stage.setTitle("Add Article");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = cnx.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutorial", "root", "");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
