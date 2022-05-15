/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.Connection;
import java.sql.ResultSet;

import com.sun.org.apache.bcel.internal.generic.LoadInstruction;
import interfaces.Ireponse;
import interfaces.Ireclamation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import Modal.Reclamation;
import Modal.Reponse;
import Services.ServiceRep;
import Services.ServiceReclam;
import interfaces.*;
import java.io.IOException;
import java.util.ServiceLoader;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;





import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connectivity.ConnectionClass;












import java.sql.Statement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.stage.Window;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ReclamationgridBACKController implements Initializable {
  @FXML
    private GridPane grid1;
    List<Reclamation> reponses = new ArrayList();
    @FXML
    private ScrollPane scrollpane;
    private javafx.stage.Stage stage,stage1;
    private Scene scene,scene1;
    private Parent root,root1;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> trinom;
    private Button idpdf;
    @FXML
    private Button user;
    @FXML
    private Button team;
    @FXML
    private Button Articles;
    @FXML
    private Button btnCat11;
    @FXML
    private Button btnCat111;
    @FXML
    private Button btnCat1111;
    
  
    
//         private List<Comment> getData() {
//        List<Comment> offres = new ArrayList();
//        Comment comment;
//
//        for (int i = 0; i < 10; i++) {
//            comment = new Comment();
//            comment.setContenu("fffff");
//            comment.setLabel("fffff");
//            comment.setResp(44);
//            
//        }
//        return offres;
//    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ServiceReclam sc = new ServiceReclam();
        Ireclamation cmnt;
      cmnt = new ServiceReclam();
         reponses= cmnt.afficherReclamation();
          
      
        try {
               
        int col = 0;
        int row = 0;
            for (int i = 0; i < reponses.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reclamationBACK.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               ReclamationBACKController itemController = fxmlLoader.getController();
                itemController.setData(reponses.get(i));

                if (col == 1) {
                    col = 0;
                    row++;
                }

                grid1.add(anchorpane, col++, row);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        
        
        
        
        
        
               
 
tfrech.textProperty().addListener((observable, oldValue, newValue) -> {
        ServiceReclam sp1 = new ServiceReclam();
        Reclamation u1 =new Reclamation();
        String nom = tfrech.getText();
        u1.setDescription(nom);
        u1.setSujet(nom);
        u1.setDate(nom);
         try{
              int cin1 = Integer.parseInt(nom);
             u1.setId(cin1);
         }
   catch(Exception e){}
     // LBshow.setText(nom);
          ObservableList<Reclamation> list1 = FXCollections.observableArrayList(sp1.rechstream(u1));
reponses.clear();
grid1.getChildren().clear();
reponses.addAll(list1);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < reponses.size(); i++) {
               FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reclamationBACK.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               ReclamationBACKController itemController = fxmlLoader.getController();
                itemController.setData(reponses.get(i));

                if (col == 1) {
                    col = 0;
                    row++;
                }

                grid1.add(anchorpane, col++, row);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        
            
        }
   // tableCategorie.setItems(list1);
    //if(tfrech.getText().trim().isEmpty()){    tableCategorie.setItems(list);}
   ;
});
        
        
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
trinom.getItems().setAll("description", "sujet", "date");
    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override
      public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
          
     if(newFruit=="description"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sc.tristreamdescription());
      reponses.clear();
grid1.getChildren().clear();
reponses.addAll(list2);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < reponses.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reclamationBACK.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

              
             ReclamationBACKController itemController = fxmlLoader.getController();
                itemController.setData(reponses.get(i));

                if (col == 1) {
                    col = 0;
                    row++;
                }

                grid1.add(anchorpane, col++, row);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        
            
        }}
     if(newFruit=="sujet"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sc.tristreamsujet());
       reponses.clear();
grid1.getChildren().clear();
reponses.addAll(list2);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < reponses.size(); i++) {
               FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reclamationBACK.fxml"));
                AnchorPane anchorpane = fxmlLoader.load();

              
            
              ReclamationBACKController itemController = fxmlLoader.getController();
                itemController.setData(reponses.get(i));

                if (col == 1) {
                    col = 0;
                    row++;
                }

                grid1.add(anchorpane, col++, row);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        
            
        }}
    if(newFruit=="date"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sc.tristreamdate());
       reponses.clear();
grid1.getChildren().clear();
reponses.addAll(list2);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < reponses.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("reclamationBACK.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

            ReclamationBACKController itemController = fxmlLoader.getController();
                itemController.setData(reponses.get(i));

                if (col == 1) {
                    col = 0;
                    row++;
                }

                grid1.add(anchorpane, col++, row);
                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid1.setMaxWidth(Region.USE_PREF_SIZE);

                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid1.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            
        
            
        }}
    
    }  });  
     
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//        // TODO
//               // Timenow();
//
//        Ireclamation pst = new ServiceReclam();
//        reclamations = pst.afficherReclamation();
//        int col = 0;
//        int row = 0;
//        try {
//            for (int i = 0; i < reclamations.size(); i++) {
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                fxmlLoader.setLocation(getClass().getResource("reclamationgrid.fxml"));
//
//                AnchorPane anchorpane = fxmlLoader.load();
//
//                FXMLRECController itemController = fxmlLoader.getController();
//                itemController.setData(reclamations.get(i));
////                System.out.println(post);
//
//                if (col == 2) {
//                    col = 0;
//                    row++;
//                }
//
//                grid1.add(anchorpane, col++, row);
//                grid1.setMinWidth(Region.USE_COMPUTED_SIZE);
//                grid1.setPrefWidth(Region.USE_COMPUTED_SIZE);
//                grid1.setMaxWidth(Region.USE_PREF_SIZE);
//
//                grid1.setMinHeight(Region.USE_COMPUTED_SIZE);
//                grid1.setPrefHeight(Region.USE_COMPUTED_SIZE);
//                grid1.setMaxHeight(Region.USE_PREF_SIZE);
//
//                GridPane.setMargin(anchorpane, new Insets(10));
//            }
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

    
    
    
    
    
    
    
    
    
//    @FXML
//    private void top(KeyEvent event) {
//          Servicecomment scomment= new Servicecomment();
//                  if (event.getCode().equals(KeyCode.SPACE)){
//                      topp.setText(scomment.bestpost(21).toString());}  
//    }

//    @FXML
//    private void stat(ActionEvent event) {
//         try {
//            root = FXMLLoader.load(getClass().getResource("Piechart.fxml"));
//            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException ex) {
//        }
//    }
//
//    @FXML
//    private void chatbot(ActionEvent event) {
////       // ServiceLoader.loadInstalled("chatbot.java");
////            try {
////              //  root=load
////            root = FXMLLoader.load(getClass().getResource("chatbot.fxml"));
////            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
////            scene = new Scene(root);
////            stage.setScene(scene);
////            stage.show();
////        } catch (IOException ex) {
////        }
//        }
//
//    @FXML
//    private void Retour(ActionEvent event) throws IOException {
//            root = FXMLLoader.load(getClass().getResource("./GUI/Main.fxml"));
//            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//    }

    @FXML
    private void imprimer(ActionEvent event) throws SQLException {
         ServiceReclam sf = new ServiceReclam();
        ObservableList<Reclamation> list = sf.getCoursList();

        try{
            OutputStream file = new FileOutputStream(new File("C:\\Users\\aboud\\Desktop\\gestion_annonce\\fact.pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();

          Font font = new Font(Font.FontFamily.HELVETICA, 50, Font.BOLD);
            Paragraph pdfTitle = new Paragraph("Liste des Reclamations");
            pdfTitle.setAlignment(Element.ALIGN_CENTER);

            document.add(pdfTitle);
            
            Image img=Image.getInstance("C:\\Users\\aboud\\Desktop\\gestion_annonce\\src\\Images\\icons8-pdf-64.png");
            document.add(img);
//         
     
            document.add(new Chunk("\n"));
            PdfPTable table = new PdfPTable(3);
            table.setHeaderRows(1);

            table.addCell("sujet");
            table.addCell("description");
            table.addCell("date");

            list.forEach((_item) -> {
                table.addCell(String.valueOf(_item.getDate()));
                table.addCell(String.valueOf(_item.getSujet()));
                table.addCell(String.valueOf(_item.getDescription()));
            });

            document.add(table);         
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setTitle("Success");
            alert.setContentText("Success!");
            document.close();

            file.close();

        } catch (Exception ex) {
           Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Cannot export data!");
            alert.show();
        }
    }

   
        
      
    @FXML    
    public void switchToFront(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("GEEK");
        stage.setScene(scene);
        stage.show();
    }   
    
    @FXML
       public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Eventaffichage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToEventCategorie(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("categoriegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToListReponse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToClaims(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reclamationgridBack.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }  
        
        
        
 

   
}
    
    
    
    

