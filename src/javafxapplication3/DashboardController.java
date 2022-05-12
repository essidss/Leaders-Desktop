/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import Modal.User;
import Services.ServiceUser;
import java.awt.print.Book;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class DashboardController implements Initializable {

    @FXML
    private Button user;
    @FXML
    private Button team;
    @FXML
    private TextField search;
    @FXML
    private ImageView pdf;
    @FXML
    private ImageView delete;
    @FXML
    private ImageView refresh;
    @FXML
    private Button ff;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private Label time;
    @FXML
    private TableColumn<User, String> culumnEmail;
    @FXML
    private TableColumn<User, String> culumnIsActive;
    @FXML
    private TableColumn<User, String> culumnRole;
    @FXML
    private TableColumn<User, String> culumnUsername;
    @FXML
    private TableView<User> usersTable;
    
    ObservableList<User> listM;
//    @FXML
//    private ListView<String> list;
//    public List<String> list1;
//    public List<String> list2;
//    public List<String> list3;
//    private List<String> l;
    
    private volatile boolean stop=false;
    ServiceUser serviceUser =new ServiceUser();
    
    
    private Stage stage; 
    private Scene scene;
    private Parent root;
@FXML
    private TableColumn<?, ?> culumnTeam;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
        listM=serviceUser.afficher();
        culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
        usersTable.setItems(listM);
        
        choiceBox.getItems().add("Username");
        choiceBox.getItems().add("Email");
        choiceBox.getItems().add("Isactive");

        choiceBox.valueProperty().addListener((obs, oldItem, newItem) -> {
            if (newItem == "Username") {
                listM=serviceUser.triWithUsername();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            } else if(newItem == "Email"){
                listM=serviceUser.triWithEmail();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            }else if(newItem == ""){
                listM=serviceUser.triWithEmail();
                culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                usersTable.setItems(listM);
            }
        });
    }    
 
    @FXML
    public void supp(){
        delete.setOnMouseClicked(e->{
            Alert alert= new Alert(AlertType.CONFIRMATION);
            alert.setTitle("confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete ?");
            Optional <ButtonType> action =alert.showAndWait();
            if(action.get()==ButtonType.OK){
                    User user= new User();
                    user=usersTable.getSelectionModel().getSelectedItem();
                    serviceUser.supprimer(user);
                    listM.removeAll(listM);
                    listM=serviceUser.afficher();
                    culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
                    culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
                    culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
                    culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
                    usersTable.setItems(listM);
            }
            
        });   
    }
//    public void affiche(){
//        
//        int first;
//        int second;
//        int third;
//        int four;
//        System.out.println(serviceUser.afficher());
//        list1=serviceUser.afficher().stream().
//                map(e->e.toString().substring(e.toString().indexOf("email")+6,e.toString().indexOf("username")-2)+
//                        "                                                                 "+
//                        e.toString().substring(e.toString().indexOf("username")+9,e.toString().indexOf("role")-1)+
//                        "                                                                  "+
//                        e.toString().substring(e.toString().indexOf("role")+5,e.toString().indexOf("password")-1)
//                    ).collect(Collectors.toList());            
//        list.getItems().addAll(list1);
//    }
    
//    public void removeItem(){
//        serviceUser.supprimer();
//        String selectedemail =list.getSelectionModel().toString().substring(0,indexOf(","));
//        int selecteId =list.getSelectionModel().getSelectedIndex();
//        list.getItems().remove(selecteId);
//    }
    
    
    private void time(){
        Thread thread =new Thread(()->{
            SimpleDateFormat d= new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
            while(!stop){
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.err.print(e);
                }
                final String timenow =d.format(new Date());
                Platform.runLater(()->{
                    time.setText(timenow);
                });
            }
        });
        thread.start();
    }
    
    @FXML
    public void search(){
        User user= new User();
        //serviceUser.supprimer(user);
        listM.removeAll(listM);
        listM=serviceUser.rechercherUser(search.getText());
        culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
        usersTable.setItems(listM);
    }
    @FXML
    public void switchToTeam(ActionEvent event) throws IOException{
        
        /*root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();*/
        root = FXMLLoader.load(getClass().getResource("TeamDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
                
    }  
   @FXML 
    public void tree(){
//        if(choiceBox.getSelectionModel().getSelectedItem().equals("username")){
//            listM=(ObservableList<User>) serviceUser.triWithUsername();
//            culumnEmail.setCellValueFactory(new PropertyValueFactory<User,String>("email"));
//        culumnUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
//        culumnRole.setCellValueFactory(new PropertyValueFactory<User,String>("role"));
//        culumnIsActive.setCellValueFactory(new PropertyValueFactory<User,String>("isactive"));
//        usersTable.setItems(listM);
//        } 
    }
    @FXML
    public void switchToFront(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
                
    }

@FXML
    public void switchToArticle(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("ArticlesDashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
                
    } 
@FXML
    public void switchToCategory(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("categoriedashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
                
    } 

    
}
