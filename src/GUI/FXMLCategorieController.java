/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Services.ServiceCategorie;
import Model.Categorie;




import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Services.ServiceCategorie;
import java.awt.Desktop.Action;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.TableColumn;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author HP
 */
public class FXMLCategorieController implements Initializable {
    @FXML
    private Button Ajouter;


    @FXML
    private TableColumn<Categorie, String> descriptioncol;

    @FXML
    private TableColumn<Categorie, String> nomcol;

    @FXML
    private TableView<Categorie> tableCategorie;

    @FXML
    private TextField tfdescription;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfnom;
    @FXML
    
    private TextField tfrech;
    @FXML
    private ComboBox<String> trinom;


    void afficher(ActionEvent event) {

    }

    @FXML
    void ajouter(ActionEvent event) {
//  ServiceCategorie ps = new ServiceCategorie();
   if(tfnom.getText().trim().isEmpty()||tfdescription.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         else
        {
        ServiceCategorie ps = new ServiceCategorie();
        Categorie p =new Categorie ();
       
         
        ps.ajouter(new Categorie( tfnom.getText(), tfdescription.getText()));
           ObservableList<Categorie> list = FXCollections.observableArrayList(ps.afficher());

    tableCategorie.setItems(list);
            {
            ps.ajouter(p);
             
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
         tfnom.clear();
        tfdescription.clear();
       
        
     
            }
    }
    
         }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

    @FXML
    void modifer(ActionEvent event) {
          if(tfnom.getText().trim().isEmpty()||tfdescription.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         else
        {
ServiceCategorie sp = new ServiceCategorie();
               
  Categorie p = tableCategorie.getSelectionModel().getSelectedItem();
   

      
  
  p.setName(tfnom.getText());
  p.setDescription(tfdescription.getText());
  sp.modifier(p); 
    
   
        ObservableList<Categorie> list = FXCollections.observableArrayList(sp.afficher());

    tableCategorie.setItems(list);
    {
            sp.ajouter(p);
             
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("modification avec succées");
        fail.setContentText("modification terminée");
        fail.showAndWait();
         tfnom.clear();
        tfdescription.clear();
       
        
     
            }
    }
    
         }

    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceCategorie sp = new ServiceCategorie();
  
  ObservableList<Categorie> list = FXCollections.observableArrayList(sp.afficher());
  tableCategorie.setItems(list);  
  tableCategorie.setEditable(true);
nomcol.setCellValueFactory(new PropertyValueFactory<Categorie,String>("name"));
 descriptioncol.setCellValueFactory(new PropertyValueFactory<Categorie,String>("description"));
 //nom.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
  
 
 
 
 tfrech.textProperty().addListener((observable, oldValue, newValue) -> {
        ServiceCategorie sp1 = new ServiceCategorie();
        Categorie u1 =new Categorie();
        String nom = tfrech.getText();
        u1.setDescription(nom);
        u1.setName(nom);
       
         try{
              int cin1 = Integer.parseInt(nom);
             u1.setId(cin1);
         }
   catch(Exception e){}
     // LBshow.setText(nom);
          ObservableList<Categorie> list1 = FXCollections.observableArrayList(sp1.rechstream(u1));

    tableCategorie.setItems(list1);
    if(tfrech.getText().trim().isEmpty()){    tableCategorie.setItems(list);}
   ;
});
      trinom.getItems().setAll("name", "description");

    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override
      public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
     if(newFruit=="description"){  ObservableList<Categorie> list2 = FXCollections.observableArrayList(sp.tristreamdescription());
       tableCategorie.setItems(list2);}
     if(newFruit=="name"){  ObservableList<Categorie> list2 = FXCollections.observableArrayList(sp.tristreamnom());
       tableCategorie.setItems(list2);}
    
    }  });  

   


    }  
    
    @FXML
    private void afficherCategorie(ActionEvent event) {

     ServiceCategorie sp = new ServiceCategorie();
     Categorie p = tableCategorie.getSelectionModel().getSelectedItem();
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


  ObservableList<Categorie> list = FXCollections.observableArrayList(sp.afficher());
         
   
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    














    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 @FXML
    private void archCategorie(ActionEvent event) {
     ServiceCategorie sp = new ServiceCategorie();
               
  Categorie c = tableCategorie.getSelectionModel().getSelectedItem();
  // int idd = Integer.parseInt(idddd.getText());
//person.setId(idd);
      
       // System.out.println(person.getDfin());
       sp.arch(c);
        ObservableList<Categorie> list = FXCollections.observableArrayList(sp.afficher());

    tableCategorie.setItems(list);
  //LBshow.setText("aa");
    }   
}
