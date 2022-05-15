/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class ReclamationgridController implements Initializable {
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
    @FXML
    private Button team;
    @FXML
    private Button btnAnnonces;
    @FXML
    private Button dash;
    @FXML
    private Button signout;
    @FXML
    private ImageView profil;
    
  
    
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
                fxmlLoader.setLocation(getClass().getResource("FXMLREC.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLRECController itemController = fxmlLoader.getController();
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
                fxmlLoader.setLocation(getClass().getResource("FXMLREC.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

              
               FXMLRECController itemController = fxmlLoader.getController();
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
                fxmlLoader.setLocation(getClass().getResource("FXMLREC.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

              
            
               FXMLRECController itemController = fxmlLoader.getController();
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
                fxmlLoader.setLocation(getClass().getResource("FXMLREC.fxml"));
                AnchorPane anchorpane = fxmlLoader.load();

              
            
               FXMLRECController itemController = fxmlLoader.getController();
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
                fxmlLoader.setLocation(getClass().getResource("FXMLREC.fxml"));

                AnchorPane anchorpane = fxmlLoader.load();

               FXMLRECController itemController = fxmlLoader.getController();
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
    private void Add(ActionEvent event) {
        
        try {
            root = FXMLLoader.load(getClass().getResource("Add_Reclamation.fxml"));
            stage = (javafx.stage.Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
        }
        
}











    

    
    
    

  
    @FXML
    public void switchToDash(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("DashBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
      public void showblog(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("FXMLArticles.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
 public void showTeam(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Team.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dash");
        stage.setScene(scene);
        stage.show();  
        
    }  
    public void switchProfilePopup() throws IOException{
        
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("Profile.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Profile");
        stage.setScene(new Scene(root1));
        stage.show();
    }  
   
    
    @FXML
    public void switchToAnnonces(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("EventAffichageFront.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void switchToReclamation(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Add_Reclamation.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }



@FXML
    public void switchToRep(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reponsegridFront.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }





}
    
    
    
    
    

