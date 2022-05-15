
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import Modal.Event;
import Modal.Categorie;
import Services.ServiceE;
import Services.ServiceC;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import interfaces.Ievent;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Region;

public class EVFrontController implements Initializable {

  
    
    private Event ev;
    private Button upd;
   

    //private Parent root;
    //private Label idpost;
    /**
     *
     * Initializes the controller class.
     */
    private javafx.stage.Stage stage, stage1;
    private Scene scene, scene1;
    private Parent root, root1;
    @FXML
    private Label name;
    @FXML
    private Label date;
    @FXML
    private Label lieu;
    @FXML
    private Label id;
    @FXML
    private Label description;
    @FXML
    private Label picture;
    @FXML
    private Label categorie;
    @FXML
    private ImageView QRCode;
   //  String url1 = "http:/127.0.0.1/C:/xampp/htdocs/GEEKS/GEEKS/public/";
      String url1 = "file:///C:/Users/aboud/Desktop/gestion_annonce/src/Images/";
     
     
    private Image image;
   
    @FXML
    private Button QRCoe;
      List<Event> events = new ArrayList();
    @FXML
    private ImageView fruitImg1;
  
 
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    // TODO

    void setData(Event ev) {

        this.ev = ev;
        id.setText(String.valueOf(ev.getId()));
        categorie.setText(String.valueOf(ev.getCategorie()));
        name.setText(ev.getName());
        date.setText(ev.getDate());
        lieu.setText(ev.getLieu());
                description.setText(ev.getDescription());
                        picture.setText(ev.getPicture());
                        //Image image = new Image(url1+ev.getImage());
                        Image image = new Image(url1+ev.getPicture());
                        fruitImg1.setImage(image);
       
        //System.out.println(url1+ev.getPicture());
//        upd.setOnAction(
//                event -> {
////                    try { 
//
//try {
////            root = FXMLLoader.load(getClass().getResource("commentgrid.fxml"));
////            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
////            scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (IOException ex) {
////        }
//                        switchToEditPage(event, ev);
//                    } catch (IOException ex) {
//
//                    }
//                }
//        );
        //  idpost.setText(String.valueOf(comment.getId_post()));

    }


//    @FXML
//    public void pass() {
//        upd.setOnAction(kk -> {
//            ServiceRep scomment = new ServiceRep();
//            try {
//                root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
//            } catch (IOException ex) {
//
//            }
//            showAlert(Alert.AlertType.INFORMATION, ((Node) kk.getSource()).getScene().getWindow(),
//                    "go update!", "modifier votre commentaire");
//
//        });
//    }

   

    public void switchPage(ActionEvent event, String path, Event comment) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setUserData(comment);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void QR(ActionEvent event) {
     
         
       ev.getId();
               if (ev == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(ev);
    }
    }

      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    


public void start(Event u) {
        
        QRCodeWriter QRCodeWriter;
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = u.getName();
        String my=u.getLieu();
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
           
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }


System.out.println("Success...");
            
        } catch (WriterException ex) {
            //Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                
        QRCode.setImage(qrView.getImage());
        
        //StackPane root = new StackPane();
        /*root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }


 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

   


}
