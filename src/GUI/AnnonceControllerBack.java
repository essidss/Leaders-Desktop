/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Model.Annonce;
import Model.Annonce_Categorie;

import Services.IService;
import Services.ServiceAnnonce;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author aboud
 */
public class AnnonceControllerBack  implements Initializable{
    @FXML
    private TableView<Annonce> tvAnnonce;
    
    @FXML
    private TableColumn<Annonce, String> colTitle;
    @FXML
    private TableColumn<Annonce, String> colDescription;
    @FXML
    private TableColumn<Annonce, String> colImage;
    @FXML
    private TableColumn<Annonce, String> colPrix;
    @FXML
    private TableColumn<Annonce, String> colTel;
    @FXML
    private TableColumn<Annonce, String> colEmail;
    @FXML
    private TableColumn<Annonce, String> colLocalisation;
    @FXML
    private TableColumn<Annonce, String> colCategorie;
    
    @FXML
    private TextField search;
    
    @FXML
    private ImageView btnRafraichir;
    
    @FXML
    private ImageView btnSupprimer;
    
    private IService serviceannonce = new ServiceAnnonce();
    private  ArrayList<Annonce>  arrayList ;
    public static ObservableList<Annonce> obsl;
    private ObservableList <Annonce>  observableList;
    ObservableList<Annonce>  AnnonceList = FXCollections.observableArrayList();
    Annonce annonce = null;
    //private volatile boolean stop=false;
    String query= null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ObservableList<Annonce> observableArrayList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                    AfficherAll();
        
    }
    
    private void AfficherAll(){
        observableArrayList = FXCollections.observableArrayList(serviceannonce.read());
        
        tvAnnonce.setItems(observableArrayList);
        
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));     
        colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
        colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colLocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
        
    }
    
    @FXML
    private void refreshTable() {
        try {
            AnnonceList.clear();
            
            query = "SELECT * FROM `annonce`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                AnnonceList.add(new  Annonce(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("image"),
                    resultSet.getString("prix"),
                    resultSet.getInt("tel"),
                    resultSet.getString("email"),
                    resultSet.getString("localisation"),
                    resultSet.getString("categorie")));
                tvAnnonce.setItems(AnnonceList);
                
            }
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    @FXML
    private void supprimerAnnonce(MouseEvent event)throws SQLException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Annonce a = tvAnnonce.getSelectionModel().getSelectedItem();
        alert.setTitle("suppression");
        alert.setHeaderText("Etes-vous sur de vouloir supprimer cette catégorie : '"
                + a.getTitle() + "'  ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (a==null) {
            JOptionPane.showMessageDialog(null,"There is nothing selected !");
        } else if (result.get() == ButtonType.OK) {  
            serviceannonce.delete(a);
            observableArrayList.clear();
            AfficherAll();
            }
    }
    
    @FXML
    public void Rafraichir() {
//         //observableList.remove(0,observableList.size());
        observableArrayList.clear();
        AfficherAll();
    }
    
   @FXML
    private void chercher(ActionEvent event) throws SQLException {
            ServiceAnnonce s = new ServiceAnnonce();
           String h = search.getText();
           ObservableList<Annonce> ls = s.recherche(h);
           
            colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));     
            colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
            colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
            colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
            colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
            colLocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
            colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
            tvAnnonce.setItems(ls);
        
    }
    
    public void switchToFront(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("GEEK");
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToCategorie(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Categorie.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToEvent(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Eventaffichage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToEventCategorie(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("categoriegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToListReponse(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reponsegrid.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    public void switchToClaims(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("reclamationgridBack.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("CategorieAnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    

}
