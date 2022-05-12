/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Model.Reclamation;
import Services.ServiceEvent;
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
import Services.ServiceReclamation;
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
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
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
public class FXMLReclamationController implements Initializable {


    @FXML
    private TableColumn<Reclamation, String> datecol;

    @FXML
    private TableColumn<Reclamation, String> descriptioncol;

    @FXML
    private TableColumn<Reclamation, String> sujetcol;

    @FXML
    private TableView<Reclamation> tableReclamation;

    @FXML
    private TextField tfdate;

    @FXML
    private TextArea tfdescription;

    @FXML
    private TextField tfid;

    @FXML
    private TextField tfsujet;
    
    @FXML
    private Button Ajouter;
    @FXML
    private TextField tfrech;
    @FXML
    private ComboBox<String> trinom;
 
   


    

    @FXML
    void ajouter(ActionEvent event) {
         if(tfdescription.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty()||tfsujet.getText().trim().isEmpty())
        {
         Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
         
         else
        {
         ServiceReclamation ps = new ServiceReclamation();
        Reclamation p =new Reclamation ();
       
         
        ps.ajouter(new Reclamation( tfdescription.getText(),tfdate.getText(),tfsujet.getText()));
        ObservableList<Reclamation> list = FXCollections.observableArrayList(ps.afficher());

    tableReclamation.setItems(list);
        if(Ajouter.getText().equals("Ajouter"))
            {
            ps.ajouter(p);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("ajout avec succées");
        fail.setContentText("ajout terminé");
        fail.showAndWait();
        tfdescription.clear();
     
         tfsujet.clear();
            }
    }
    }

    

   
    
    
    
    
  
  
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           ServiceReclamation sp = new ServiceReclamation();
  
  ObservableList<Reclamation> list = FXCollections.observableArrayList(sp.afficher());
  tableReclamation.setItems(list);  
  tableReclamation.setEditable(true);
 
 descriptioncol.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("description"));
 //nom.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
  

//description.setCellFactory(TextFieldTableCell.<Event> forTableColumn())
  
datecol.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("date"));
//lieu.setCellFactory(TextFieldTableCell.<Event> forTableColumn());
  

//date.setCellFactory(TextFieldTableCell.<Event> forTableColumn());

sujetcol.setCellValueFactory(new PropertyValueFactory<Reclamation,String>("sujet"));










tfrech.textProperty().addListener((observable, oldValue, newValue) -> {
        ServiceReclamation sp1 = new ServiceReclamation();
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

    tableReclamation.setItems(list1);
    if(tfrech.getText().trim().isEmpty()){    tableReclamation.setItems(list);}
   ;
});
      trinom.getItems().setAll("description", "sujet", "date");

    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
     if(newFruit=="description"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sp.tristreamdescription());
       tableReclamation.setItems(list2);}
     if(newFruit=="sujet"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sp.tristreamsujet());
       tableReclamation.setItems(list2);}
     if(newFruit=="date"){  ObservableList<Reclamation> list2 = FXCollections.observableArrayList(sp.tristreamdate());
       tableReclamation.setItems(list2);}
    }  });  }

   











   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 @FXML
    private void afficherReclamation(ActionEvent event) {

     ServiceReclamation sp = new ServiceReclamation();
     Reclamation p = tableReclamation.getSelectionModel().getSelectedItem();
//     Image image = new Image(url1+person.getImage());
//    // String decodedString = new String(base64.decode(person.getImage().getBytes()));
//   try{  byte[] bytes = person.getImage().getBytes("UTF-8");
//     String s2 = new String(bytes, "UTF-8");
//   System.out.println(s2);}
//   catch(Exception e){}
//  Image.setImage(image);
 String ci2= String.valueOf(p.getId()); 
 tfid.setText(ci2);
 tfdescription.setText(p.getDescription());
 
//  LocalDate localDate = LocalDate.parse(p.getDate());
//  tfdate.setValue(localDate);
// 
 tfsujet.setText(p.getSujet());
 tfdate.setText(p.getDate());


 
  ObservableList<Reclamation> list = FXCollections.observableArrayList(sp.afficher());

         
   
    
    
    
    
    
    
    
    }
    
    
    @FXML
    private void archReclamation(ActionEvent event) {
     ServiceReclamation sp = new ServiceReclamation();
               
  Reclamation r = tableReclamation.getSelectionModel().getSelectedItem();
  // int idd = Integer.parseInt(idddd.getText());
//person.setId(idd);
      
       // System.out.println(person.getDfin());
       sp.arch(r);
        ObservableList<Reclamation> list = FXCollections.observableArrayList(sp.afficher());

    tableReclamation.setItems(list);
  //LBshow.setText("aa");
    }
    
    
    
    
    
    
//    
//    @FXML
//    void imprimer(ActionEvent event) {
//        
//        PrinterJob job = PrinterJob.createPrinterJob();
//
//        Node root = this.tableReclamation;
//
//        if (job != null) {
//            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
//            Printer printer = job.getPrinter();
//            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
//            boolean success = job.printPage(pageLayout, root);
//            if (success) {
//                job.endJob();
//            }
//        }
//
//    }

    @FXML
    private void modifier(ActionEvent event) {
          if(tfdescription.getText().trim().isEmpty()||tfdate.getText().trim().isEmpty()||tfsujet.getText().trim().isEmpty())
        {
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("failure");
        fail.setContentText("you havent typed something");
        fail.showAndWait();
            
        }
          else
          {
    ServiceReclamation sp = new ServiceReclamation();
               
  Reclamation p = tableReclamation.getSelectionModel().getSelectedItem();
   
  p.setDescription(tfdescription.getText());
  p.setSujet(tfsujet.getText());
 
  p.setDate(tfdate.getText());
  sp.modifier(p);  
   
        ObservableList<Reclamation> list = FXCollections.observableArrayList(sp.afficher());

    tableReclamation.setItems(list);
     if(Ajouter.getText().equals("Ajouter"))
            {
            sp.ajouter(p);
              Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("modification avec succées");
        fail.setContentText("modification terminée");
        fail.showAndWait();
        tfdescription.clear();
     
         tfsujet.clear();
            }}
  //LBshow.setText("aa");
    
    
    
    
    
    }

    @FXML
    private void imprimer(ActionEvent event) {
         PrinterJob job = PrinterJob.createPrinterJob();
//
        Node root = this.tableReclamation;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
            }
        }
    }
}
    
     