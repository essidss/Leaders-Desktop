/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import Modal.Team;
import Modal.User;
import Services.ServiceTeam;
import Services.ServiceUser;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author leith
 */
public class TeamDashboardController implements Initializable {

    @FXML
    private Button user;
    @FXML
    private Button team;
    @FXML
    private ImageView addgroup;
    @FXML
    private TextField searchteam;
    @FXML
    private ImageView pdf;
    @FXML
    private ImageView deleteteam;
    @FXML
    private ImageView ref;
    @FXML
    private ChoiceBox<String> choiceBoxteam;
    @FXML
    private TableView<Team> teamtable;
//    @FXML
//    private ListView<String> listv;

    @FXML
    private TableColumn<Team, String> teamnametable;

    @FXML
    private TableColumn<Team, String> descriptiontable;

    @FXML
    private TableColumn<Team, String> isactiveteam;
    @FXML
    private Label timeteam;
    @FXML
    private Button frontteam;
    @FXML
    private Button editteam;
    @FXML
    private Button editteam2;
    ObservableList<Team> listM;
    private volatile boolean stop=false;
    ServiceTeam serviceTeam =new ServiceTeam();
    private Stage stage; 
    private Scene scene;
    private Parent root;
    public List<String> list1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        time();
        
        listM=serviceTeam.afficher();
        teamnametable.setCellValueFactory(new PropertyValueFactory<Team,String>("TeamName"));
        descriptiontable.setCellValueFactory(new PropertyValueFactory<Team,String>("Description"));
        isactiveteam.setCellValueFactory(new PropertyValueFactory<Team,String>("isactive"));
        teamtable.setItems(listM);
            

        choiceBoxteam.getItems().add("Teamname");
        choiceBoxteam.getItems().add("Description");
        choiceBoxteam.getItems().add("isActive");
    }    

    @FXML
    private void search() {
        Team team= new Team();
        listM.removeAll(listM);
        listM=serviceTeam.rechercherTeam(searchteam.getText());
        teamnametable.setCellValueFactory(new PropertyValueFactory<Team,String>("TeamName"));
        descriptiontable.setCellValueFactory(new PropertyValueFactory<Team,String>("Description"));
        isactiveteam.setCellValueFactory(new PropertyValueFactory<Team,String>("isactive"));
        teamtable.setItems(listM);
    }

    @FXML
    private void supp() {
        deleteteam.setOnMouseClicked(e->{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete ?");
            Optional <ButtonType> action =alert.showAndWait();
            if(action.get()==ButtonType.OK){
                    Team team= new Team();
                    team=teamtable.getSelectionModel().getSelectedItem();
                    serviceTeam.supprimer(team);
                    listM.removeAll(listM);
                    listM=serviceTeam.afficher();
                    teamnametable.setCellValueFactory(new PropertyValueFactory<Team,String>("TeamName"));
        descriptiontable.setCellValueFactory(new PropertyValueFactory<Team,String>("Description"));
        isactiveteam.setCellValueFactory(new PropertyValueFactory<Team,String>("isactive"));
                    teamtable.setItems(listM);
            }
            
        });   
    }
    
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
                    timeteam.setText(timenow);
                });
            }
        });
        thread.start();
    }
    
    public void switchToUser(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Dashboard User");
        stage.setScene(scene);
        stage.show();       
    }  
    
    
    public void switchTeamPopup() throws IOException{
        
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("AddTeam.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Add Team");
        stage.setScene(new Scene(root1));
        stage.show();
    }  
//    public void refresh(){
//        listM=serviceTeam.afficher();
//        culumnTeam.setCellValueFactory(new PropertyValueFactory<Team,String>("TeamName"));
//        Description.setCellValueFactory(new PropertyValueFactory<Team,String>("Description"));
//        culumnIsActiveteam.setCellValueFactory(new PropertyValueFactory<Team,String>("isactive"));
//        teamsTable.setItems(listM);
//    }
    
    public void switchToFront2(ActionEvent event) throws IOException{
        
        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Team");
        stage.setScene(scene);
        stage.show();
               
    } 
    
    public void switchEditTeamPopup() throws IOException{
        
        FXMLLoader fxmlloader = new FXMLLoader (getClass().getResource("PopupEditTeam.fxml"));
        Parent root1= (Parent) fxmlloader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Add Team");
        stage.setScene(new Scene(root1));
        stage.show();
    } 
//        public void affiche(){
//        
//        System.out.println(serviceTeam.afficher());
//        list1=serviceTeam.afficher().stream().
//                map(e->e.toString().substring(e.toString().indexOf("{"),e.toString().indexOf("}"))
//                    ).collect(Collectors.toList());            
//        //listv.getItems().addAll(list1);
//        teamtable.setItems(list1);
//    }
    
//    public void removeItem(){
//        serviceUser.supprimer();
//        String selectedemail =list.getSelectionModel().toString().substring(0,indexOf(","));
//        int selecteId =list.getSelectionModel().getSelectedIndex();
//        list.getItems().remove(selecteId);
//    }
}
