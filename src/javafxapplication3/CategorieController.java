/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Article;
import Modal.Category;
import Services.ServiceArticle;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CategorieController implements Initializable {

    private Connection cnx = ConnectionClass.getInstance().getCnx();

    @FXML
    private ImageView ArticleImage;

    @FXML
    private Label articleName;

    @FXML
    private HBox box;

    @FXML
    private Label date;
    @FXML
    private Label idcat;
    private String[] colors = {"B9E5FF'", "BDB2FE", "FB9AA8", "FF5056"};
    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setArticle(Category article) {
         
        articleName.setText(article.getNom());
        idcat.setText((String.valueOf(article.getIdcat())));
        idcat.setVisible(false);
         Date d = new Date();
        date.setText(d.toString());
        box.setStyle("-fx-background-color:#" + colors[(int) (Math.random() * colors.length)] + ";"
                + " -fx-backgound-radius:30;"
                + "-fx-effect:dropShadow(three-pass-box,rgba(0,0,0,0)10,0 , 0 ,10);");
    }

    public void deletebutton() {

        String query = "UPDATE `category` SET `archived`='" + 1 + "' WHERE idcat=" + idcat.getText() + "";
        Alert a1 = new Alert(Alert.AlertType.NONE,
                "Voulez vous Vraiment supprimer", ButtonType.APPLY);

         a1.show();

         a1.show();
        executeQuery(query);

    }

  /*  @FXML
    public void updatebutton(MouseEvent event) {
        try {
         idcat.setText((String.valueOf(article.getIdcat())));
            ServiceArticle sp = new ServiceArticle();

            Article article = sp.findByArticleId(id);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifierblog.fxml"));
            root = loader.load();
            ModifierblogController modif = loader.getController();
            modif.setData(article);
//      PostController postcontroller = loader.getController();
            //postcontroller.setArticle(title);
            // postcontroller.setData(article);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }*/
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
