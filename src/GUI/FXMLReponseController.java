/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Model.Reponse;
import Model.Reclamation;
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
import Services.ServiceReponse;
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
/**
 * FXML Controller class
 *
 * @author HP
 */

public class FXMLReponseController implements Initializable {
     @FXML
    private Button Ajouter;


    
    @FXML
    private TableColumn<Reponse,String> datecol;

    @FXML
    private TableColumn<Reponse,Integer> reclamationcol;

    @FXML
    private TableColumn<Reponse,String> reponsecol;

    @FXML
    private TableView<Reponse> tableReponse;

    @FXML
    private TextField tfdate;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfreclamation;

    @FXML
    private TextField tfreponse;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> trinom;

      @FXML
   void Ajouter(ActionEvent event) {
        ServiceReponse ps = new ServiceReponse();
          if(tfreponse.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         
         else
        {
        Reponse p =new Reponse ();
       
         int id = Integer.parseInt(tfreclamation.getText());
            p.setReclamation(id);
        ps.ajouter(new Reponse(tfreponse.getText(),tfdate.getText(), id));
        ObservableList<Reponse> list = FXCollections.observableArrayList(ps.afficher());

    tableReponse.setItems(list);
         if(Ajouter.getText().equals("Ajouter"))
            {
            ps.ajouter(p);
             
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
         tfreponse.clear();
      
            }
    }
    
         
    }
  


  
    @FXML
    void modifier(ActionEvent event) {
         if(tfreponse.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         else{
        
    
    ServiceReponse sp = new ServiceReponse();
               
  Reponse p = tableReponse.getSelectionModel().getSelectedItem();
   

      
  int idd = Integer.parseInt(tfid.getText());
 p.setId(idd);  
  p.setReponse(tfreponse.getText());
  
 
  p.setDate(tfdate.getText());
 
  p.setReclamation(Integer.parseInt(tfreclamation.getText()) );
       
     sp.modifier(p);  
   
        ObservableList<Reponse> list = FXCollections.observableArrayList(sp.afficher());

    tableReponse.setItems(list);
  //LBshow.setText("aa");
    
     if(Ajouter.getText().equals("Ajouter"))
            {
            sp.ajouter(p);
             
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("modification avec succées");
        fail.setContentText("modification terminée");
        fail.showAndWait();
         tfreponse.clear();
      
            }
    }
    
    
    
    }
    
    
    
 @FXML
    private void afficherReponse(ActionEvent event) {

     ServiceReponse sp = new ServiceReponse();
     Reponse p = tableReponse.getSelectionModel().getSelectedItem();
//     Image image = new Image(url1+person.getImage());
//    // String decodedString = new String(base64.decode(person.getImage().getBytes()));
//   try{  byte[] bytes = person.getImage().getBytes("UTF-8");
//     String s2 = new String(bytes, "UTF-8");
//   System.out.println(s2);}
//   catch(Exception e){}
//  Image.setImage(image);
 String ci2= String.valueOf(p.getId()); 
 tfid.setText(ci2);
  tfreponse.setText(p.getReponse());
 tfdate.setText(p.getDate());
  String ci= String.valueOf(p.getReclamation());
  tfreclamation.setText(ci);
  
 
   
//  LocalDate localDate = LocalDate.parse(p.getDate());
//  tfdate.setValue(localDate);
// 
 

  
  
  ObservableList<Reponse> list = FXCollections.observableArrayList(sp.afficher());

         
   
    
  //LBshow.setText("aa");
 
    }
    
    
     
    
    
    
    
    
    
    
    
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceReponse sp = new ServiceReponse();
  
   
 reponsecol.setCellValueFactory(new PropertyValueFactory<>("reponse"));
 //nom.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
  

datecol.setCellValueFactory(new PropertyValueFactory<Reponse,String>("date"));
//date.setCellFactory(TextFieldTableCell.<Event> forTableColumn());



reclamationcol.setCellValueFactory(new PropertyValueFactory<Reponse,Integer>("Reclamation"));

  tableReponse.setEditable(true);
  ObservableList<Reponse> list = FXCollections.observableArrayList(sp.afficher());
//ImageView imagecol=new ImageView(new image(this.getClass().getResourceAsStream(url1)));
    tableReponse.setItems(list);

    
   
    
    
    
tfrech.textProperty().addListener((observable, oldValue, newValue) -> {
        ServiceReponse sp1 = new ServiceReponse();
        Reponse u1 =new Reponse();
        String nom = tfrech.getText();
        u1.setReponse(nom);
       
        u1.setDate(nom);
         try{
              int cin1 = Integer.parseInt(nom);
             u1.setId(cin1);
         }
   catch(Exception e){}
     // LBshow.setText(nom);
   ObservableList<Reponse> list1 = FXCollections.observableArrayList(sp1.rechstream(u1));

    tableReponse.setItems(list1);
    if(tfrech.getText().trim().isEmpty()){    tableReponse.setItems(list);}
   ;
});
      trinom.getItems().setAll("reponse", "date");

    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
     if(newFruit=="reponse"){  ObservableList<Reponse> list2 = FXCollections.observableArrayList(sp.tristreamdescription());
       tableReponse.setItems(list2);}
    
     if(newFruit=="date"){  ObservableList<Reponse> list2 = FXCollections.observableArrayList(sp.tristreamdate());
       tableReponse.setItems(list2);}
    }  });  }

   
//@FXML
//    void remove(ActionEvent event) {
//        int selectedID = tableEvent.getSelectionModel().getSelectedIndex();
//        tableEvent.getItems().remove(selectedID);
//    }
//    
    
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void archReponse(ActionEvent event) {
     ServiceReponse sp = new ServiceReponse();
               
  Reponse reponse = tableReponse.getSelectionModel().getSelectedItem();
  // int idd = Integer.parseInt(idddd.getText());
//person.setId(idd);
      
       // System.out.println(person.getDfin());
       sp.arch(reponse);
        ObservableList<Reponse> list = FXCollections.observableArrayList(sp.afficher());

    tableReponse.setItems(list);
  //LBshow.setText("aa");
    }

    
    
    
      
    }





     