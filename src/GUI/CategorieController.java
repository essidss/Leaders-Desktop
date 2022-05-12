/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Annonce_Categorie;
import Services.IServiceCategorie;
import Services.ServiceCategorie;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javax.swing.JOptionPane;
import utils.DataBase;



public class CategorieController implements Initializable {

    @FXML
    private TableView<Annonce_Categorie> tvCategorie;

    @FXML
    private TableColumn<Annonce_Categorie, String> colCategorie;
    
    @FXML
    private TableColumn<Annonce_Categorie, String> action;

    @FXML
    private TextField tfNom;
    
    @FXML
    private TextField search;

    @FXML
    private Button btnAjouter;

    @FXML
    private ImageView btnRafraichir;
    
    @FXML
    private ImageView btnSupprimer;
    
    @FXML
    private Button btnModifier;
    
    @FXML
    private TextField ntfNom;
    @FXML
    private TextField otfNom;
    
    @FXML
    private Label time;
    


    private IServiceCategorie servicecategorie = new ServiceCategorie();
    private  ArrayList<Annonce_Categorie>  arrayList ;
    public static ObservableList<Annonce_Categorie> obsl;
    private ObservableList <Annonce_Categorie>  observableList;
    ObservableList<Annonce_Categorie>  CategorieList = FXCollections.observableArrayList();
    Annonce_Categorie categorie = null;
    //private volatile boolean stop=false;
    String query= null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherAll();
        //loadDate();
    }


    private void AfficherAll() {
        arrayList = (ArrayList) servicecategorie.getall();
        observableList = FXCollections.observableArrayList(arrayList);
        tvCategorie.setItems(observableList);
        colCategorie.setCellValueFactory(new PropertyValueFactory<Annonce_Categorie, String>("Nom"));
    }



    @FXML
    private void ajouterCategorie(ActionEvent event) throws IOException
    {
        if (!tfNom.getText().equals("")){
        Annonce_Categorie categorie = new Annonce_Categorie();

        categorie.setNom(tfNom.getText());
        System.out.println(categorie.toString());
        servicecategorie.add(categorie);
        arrayList.clear();
        AfficherAll();
        tfNom.setText("");
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur: champ vide");
            alert.setHeaderText("Champ(s) manquant(s) ! Veuillez remplir tous les champs. ");
            Optional<ButtonType> result = alert.showAndWait();

        }

    }
    @FXML
    private void refreshTable() {
        try {
            CategorieList.clear();
            
            query = "SELECT * FROM `annonce_cat`";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                CategorieList.add(new  Annonce_Categorie(
                        resultSet.getString("nom")));
                tvCategorie.setItems(CategorieList);
                
            }
            
            
        } catch (SQLException ex) {
            //Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    /*private void loadDate(){
        connection = DataBase.getInstance().getConnection();
        refreshTable();
        
        colCategorie.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        Callback<TableColumn<Categorie, String>,TableCell<Categorie, String>> cellFoctory = (TableColumn<Categorie, String> param)->{
            final TableCell<Categorie, String> cell = new TableCell<Categorie, String>(){
                @Override
                public void updateItem(String nom, boolean empty){
                    super.updateItem(nom,empty);
                    if (empty){
                        setGraphic(null);
                        setText(null);
                    }else{
                        Label editicon = new Label("azdazdazdazdazdazdazdazdzad");
                        editicon.setStyle(
                                " -fx-cursor: hand ;"
                                        + "-glyph-size:28px;"
                                        + "-fx-fill:#00E676;"
                        );
                        editicon.setOnMouseClicked((MouseEvent event)->{
                        categorie = tvCategorie.getSelectionModel().getSelectedItem();
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ModifierCategorie.fxml"));
                        try{
                            loader.load();
                        }catch(IOException ex){
                            //
                        }
                        ModifierCategorieController modifCategorie = loader.getController();
                        modifCategorie.setUpdate(true);
                        modifCategorie.setTextField(categorie.getId(), categorie.getNom());
                        Parent parent = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(parent));
                        stage.show();
                    });
                        HBox managebtn = new HBox(editicon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(editicon, new Insets(2,3,0,2));
                        
                        setText(null);
                    }
                }
            };
            return cell;
        };
             action.setCellFactory(cellFoctory);
             tvCategorie.setItems(CategorieList);
    }*/

    @FXML
    private void SupprimerCategorie(MouseEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Annonce_Categorie c = tvCategorie.getSelectionModel().getSelectedItem();
        alert.setTitle("suppression");
        alert.setHeaderText("Etes-vous sur de vouloir supprimer cette catégorie : '"
                + c.getNom() + "'  ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (c==null) {
            JOptionPane.showMessageDialog(null,"There is nothing selected !");
        } else if (result.get() == ButtonType.OK) {
            servicecategorie.delete(c);
            arrayList.clear();
            AfficherAll();
        }

    }
    
    @FXML
    public void Rafraichir()  {
//         //observableList.remove(0,observableList.size());
        arrayList.clear();
        AfficherAll();
    }
    
   @FXML
    private void chercher(ActionEvent event) throws SQLException {
           ServiceCategorie s = new ServiceCategorie();
           String h = search.getText();
           ObservableList<Annonce_Categorie> ls = s.recherche(h);
           
           colCategorie.setCellValueFactory(new PropertyValueFactory<>("nom"));
           tvCategorie.setItems(ls);
        
    }
    
    public void switchToAnnonce(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceBack.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("AnnonceBack");
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToFront(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("GEEK");
        stage.setScene(scene);
        stage.show();
    }

}

