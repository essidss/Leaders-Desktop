/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Categorie;
import Services.IServiceCategorie;
import Services.ServiceCategorie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class CategorieController implements Initializable {

    @FXML
    private TableView<Categorie> tvCategorie;

    @FXML
    private TableColumn<Categorie, String> colCategorie;

    @FXML
    private TextField tfNom;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnRafraichir;


    private IServiceCategorie servicecategorie = new ServiceCategorie();
    private  ArrayList<Categorie>  arrayList ;
    public static ObservableList<Categorie> obsl;
    private ObservableList <Categorie>  observableList;
    private Categorie categorie;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AfficherAll();
    }


    private void AfficherAll() {
        arrayList = (ArrayList) servicecategorie.getall();
        observableList = FXCollections.observableArrayList(arrayList);
        tvCategorie.setItems(observableList);
        colCategorie.setCellValueFactory(new PropertyValueFactory<Categorie, String>("Nom"));
    }



    @FXML
    private void ajouterCategorie(ActionEvent event) throws IOException
    {
        if (!tfNom.getText().equals("")){
        Categorie categorie = new Categorie();

        categorie.setNom(tfNom.getText());
        System.out.println(categorie.toString());
        servicecategorie.add(categorie);
        //arrayList.clear();
        }else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Erreur: champ vide");
            alert.setHeaderText("Champ(s) manquant(s) ! Veuillez remplir tous les champs. ");
            Optional<ButtonType> result = alert.showAndWait();

        }

    }

    @FXML
    private void SupprimerCategorie(ActionEvent event) throws SQLException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        Categorie c = tvCategorie.getSelectionModel().getSelectedItem();
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

    public void switchToAnnonce(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("AnnonceController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Annonce");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Rafraichir()  {
//         //observableList.remove(0,observableList.size());
        arrayList.clear();
        AfficherAll();
    }


//     @FXML
//   private void ModifierCategorie(ActionEvent event) throws IOException
//   {
//
//        Categorie c = tvCategorie.getSelectionModel().getSelectedItem();
//        if (c==null) {
//        JOptionPane.showMessageDialog(null,"There is nothing selected !");
//        }
//        else{
//            servicecategorie.update(c)
//        ;}
//   }



}

