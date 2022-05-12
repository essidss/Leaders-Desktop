/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Event;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import Services.ServiceEvent;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javafx.scene.control.TextArea;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.awt.Color;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
/**
 * FXML Controller class
 *
 * @author HP
 */









public class FXMLEventController implements Initializable {
 @FXML
    private TextField tfnom;

     @FXML
    private TextField tfcategorie;
     @FXML
    private TextArea tfdescription;
  

    @FXML
    private TextField tfdate;


    @FXML
    private TextField tflieu;

   
    @FXML
    private TextField tfpicture;
    
   

    
  
    @FXML
    private TextField tfid;
     
@FXML
    private Button Ajouter;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> trinom;
    @FXML
    private Button QRCoe;
    @FXML
    private ImageView QRCode;
    @FXML
    private ListView<Event> listEvent;
    @FXML
    private TableView<?> tableEvent;
    @FXML
    private TableColumn<?, ?> nomcol;
    @FXML
    private TableColumn<?, ?> descriptioncol;
    @FXML
    private TableColumn<?, ?> lieucol;
    @FXML
    private TableColumn<?, ?> datecol;
    @FXML
    private TableColumn<?, ?> picturecol;
    @FXML
    private TableColumn<?, ?> categoriecol;
    
    
        
    
    @FXML
   void Ajouter(ActionEvent event) {
        if(tfnom.getText().trim().isEmpty()||tfdescription.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty()||tflieu.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         else
        {
        ServiceEvent ps = new ServiceEvent();
       
        Event p =new Event ();
       
         int id = Integer.parseInt(tfcategorie.getText());
         p.setCategorie(id);
        ps.ajouter(new Event(tfnom.getText(), tfdescription.getText(), tflieu.getText(), tfdate.getText(), tfpicture.getText(), id));
         ObservableList<Event> list = FXCollections.observableArrayList(ps.afficher());

    listEvent.setItems(list);
        if(Ajouter.getText().equals("Ajouter"))
            {
            ps.ajouter(p);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
        tfnom.clear();
        tfdescription.clear();
         tfdate.clear();
          tflieu.clear();
            }
    }
    }
  
   
   
   
   
   
   
   
   
   
   


  
    @FXML
    void modifier(ActionEvent event) {
   if(tfnom.getText().trim().isEmpty()||tfdescription.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty()||tflieu.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         else
        {
    
    ServiceEvent sp = new ServiceEvent();
               
  Event p = listEvent.getSelectionModel().getSelectedItem();
   

      
  int idd = Integer.parseInt(tfid.getText());
 p.setId(idd);  
  p.setName(tfnom.getText());
  p.setDescription(tfdescription.getText());
  p.setLieu(tflieu.getText());
 
 
  p.setDate(tfdate.getText());
  p.setPicture(tfpicture.getText());
  p.setCategorie(Integer.parseInt(tfcategorie.getText()) );
       
     sp.modifier(p);  
   
        ObservableList<Event> list = FXCollections.observableArrayList(sp.afficher());

    listEvent.setItems(list);
  //LBshow.setText("aa");
    
    
    
    if(Ajouter.getText().equals("Ajouter"))
            {
            sp.ajouter(p);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("modification avec succées");
        fail.setContentText("modification terminé");
        fail.showAndWait();
        tfnom.clear();
        tfdescription.clear();
         tfdate.clear();
          tflieu.clear();
            }
    }
    }
    
    
    
 @FXML
    private void afficherEvent(ActionEvent event) {

     ServiceEvent sp = new ServiceEvent();
     Event p = listEvent.getSelectionModel().getSelectedItem();
//     Image image = new Image(url1+person.getImage());
//    // String decodedString = new String(base64.decode(person.getImage().getBytes()));
//   try{  byte[] bytes = person.getImage().getBytes("UTF-8");
//     String s2 = new String(bytes, "UTF-8");
//   System.out.println(s2);}
//   catch(Exception e){}
//  Image.setImage(image);
 String ci2= String.valueOf(p.getId()); 
tfid.setText(ci2);
 tfnom.setText(p.getName());
 
 tfdescription.setText(p.getDescription());
 
 tflieu.setText(p.getLieu());
 
    
  tfdate.setText(p.getDate());
 
 tfpicture.setText(p.getPicture());

 String ci= String.valueOf(p.getCategorie());
  tfcategorie.setText(ci);
  
  
  ObservableList<Event> list = FXCollections.observableArrayList(sp.afficher());

         
   
    
  //LBshow.setText("aa");
 
    }
    
    
     
    
    
    
    
    
    
    
    
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvent sp = new ServiceEvent();
  
//   
// nomcol.setCellValueFactory(new PropertyValueFactory<>("name"));
// //nom.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
//  
//descriptioncol.setCellValueFactory(new PropertyValueFactory<Event,String>("description"));
////description.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
//  
//lieucol.setCellValueFactory(new PropertyValueFactory<Event,String>("lieu"));
////lieu.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
//  
//datecol.setCellValueFactory(new PropertyValueFactory<Event,String>("date"));
////date.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
//
//picturecol.setCellValueFactory(new PropertyValueFactory<Event,String>("picture"));
////picture.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
//
//categoriecol.setCellValueFactory(new PropertyValueFactory<Event,Integer>("categorie"));
//
//  listEvent.setEditable(true);
  ObservableList<Event> list = FXCollections.observableArrayList(sp.afficher());
//ImageView imagecol=new ImageView(new image(this.getClass().getResourceAsStream(url1)));
    listEvent.setItems(list);

    
   
    
    
    
    
    
    
    
    
    
    
    
    
tfrech.textProperty().addListener((observable, oldValue, newValue) -> {
        ServiceEvent sp1 = new ServiceEvent();
        Event u1 =new Event();
        String nom = tfrech.getText();
        u1.setDescription(nom);
        u1.setName(nom);
        u1.setDate(nom);
         try{
              int cin1 = Integer.parseInt(nom);
             u1.setId(cin1);
         }
   catch(Exception e){}
     // LBshow.setText(nom);
          ObservableList<Event> list1 = FXCollections.observableArrayList(sp1.rechstream(u1));

    listEvent.setItems(list1);
    if(tfrech.getText().trim().isEmpty()){    listEvent.setItems(list);}
   ;
});
      trinom.getItems().setAll("description", "Name", "date");

    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
     if(newFruit=="description"){  ObservableList<Event> list2 = FXCollections.observableArrayList(sp.tristreamdescription());
       listEvent.setItems(list2);}
     if(newFruit=="Name"){  ObservableList<Event> list2 = FXCollections.observableArrayList(sp.tristreamnom());
       listEvent.setItems(list2);}
     if(newFruit=="date"){  ObservableList<Event> list2 = FXCollections.observableArrayList(sp.tristreamdate());
       listEvent.setItems(list2);}
    }  });  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

      

    
       @FXML
    private void archEvent(ActionEvent event) {
     ServiceEvent sp = new ServiceEvent();
               
  Event p = listEvent.getSelectionModel().getSelectedItem();
  // int idd = Integer.parseInt(idddd.getText());
//person.setId(idd);
      
       // System.out.println(person.getDfin());
       sp.arch(p);
        ObservableList<Event> list = FXCollections.observableArrayList(sp.afficher());

    listEvent.setItems(list);
  //LBshow.setText("aa");
    }

    @FXML
    private void QR(ActionEvent event) {
        Event l1 = listEvent.getSelectionModel().getSelectedItem();
        if (l1 == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(l1);
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
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
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