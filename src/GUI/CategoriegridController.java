


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.sun.org.apache.bcel.internal.generic.LoadInstruction;
import interfaces.Ievent;
import interfaces.Icategorie;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import Model.Event;
import Model.Categorie;
import Services.ServiceE;
import Services.ServiceC;
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
import javafx.stage.Stage;


public class CategoriegridController implements Initializable {
  @FXML
    private GridPane grid1;
    List<Categorie> categories = new ArrayList();
    @FXML
    private ScrollPane scrollpane;
    private javafx.stage.Stage stage,stage1;
    private Scene scene,scene1;
    private Parent root,root1;
    @FXML
    private ComboBox<String> trinom;
    @FXML
    private TextField tfrech;
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
        ServiceC sp7 = new ServiceC();
        Icategorie cmnt;
      cmnt = new ServiceC();
         categories= cmnt.afficherCategorie();
          
         
       
        try {
             int col = 0;
        int row = 0;
            for (int i = 0; i < categories.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLCat.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLCatController itemController = fxmlLoader.getController();
                itemController.setData(categories.get(i));

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
        ServiceC sp1 = new ServiceC();
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
categories.clear();
grid1.getChildren().clear();
categories.addAll(list1);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < categories.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLCat.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLCatController itemController = fxmlLoader.getController();
                itemController.setData(categories.get(i));

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
        
        
        
        
   trinom.getItems().setAll("name", "description");

    // bind the selected fruit label to the selected fruit in the combo box.
  //  LBshow.textProperty().bind(trinom.getSelectionModel().selectedItemProperty());

    // listen for changes to the fruit combo box selection and update the displayed fruit image accordingly.
      trinom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        
      @Override
      public void changed(ObservableValue<? extends String> selected, String oldFruit, String newFruit) {
     if(newFruit=="description"){  ObservableList<Categorie> list2 = FXCollections.observableArrayList(sp7.tristreamdescription());
      categories.clear();
grid1.getChildren().clear();
categories.addAll(list2);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < categories.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLCat.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLCatController itemController = fxmlLoader.getController();
                itemController.setData(categories.get(i));

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
     if(newFruit=="name"){  ObservableList<Categorie> list2 = FXCollections.observableArrayList(sp7.tristreamnom());
       categories.clear();
grid1.getChildren().clear();
categories.addAll(list2);
 
        try {
         int col = 0;
        int row = 0;
            for (int i = 0; i < categories.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLCat.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLCatController itemController = fxmlLoader.getController();
                itemController.setData(categories.get(i));

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

   
    
    
     @FXML
    private void Add(ActionEvent event) {
        
        try {
            root = FXMLLoader.load(getClass().getResource("ADD_Categorie.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
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
    
    
    
    
    


