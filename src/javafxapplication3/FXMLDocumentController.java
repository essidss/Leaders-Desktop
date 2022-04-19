/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package javafxapplication3;

import Connectivity.ConnectionClass;
import Modal.Personne;
  import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author hp
 */
public class FXMLDocumentController implements Initializable {
       public Connection cnx = ConnectionClass.getInstance().getCnx();

    @FXML
    private Label label;
    public TextField textField;
    public Label textLabel;
    public TextField usename;
    public TextField lastname;
    public TextField email;
    public TextField password;
    public TextField age;
    public TextField description;
    public TextField country;
    public TextField image;
@FXML
    private TableView<Personne> table;
@FXML
    private TableColumn<Personne, Integer> colid;
    @FXML
    private TableColumn<Personne, String> colnom;
    @FXML
    private TableColumn<Personne, String> colprenom;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {

        System.out.println("You clicked me!");
      //  label.setText("Hello World!");
        List<Personne> list = afficher();
        colid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
        table.setItems((ObservableList<Personne>) list);
 

 }
 public  void button(ActionEvent event) throws SQLException {
       /* ConnectionClass connectionClass = new ConnectionClass();
           Connection connection = connectionClass.getcnx();*/
/* String querry= "INSERT INTO user VALUES ('"+usename.getText()+"''"+lastname.getText()+"''"+email.getText()+"''"+password.getText()+"''"+age.getText()+"''"+description.getText()+"''"+country.getText()+"''"+image.getText()+"')";
        Statement stm = connection.createStatement();
    
    stm.executeUpdate(querry);*/
      //  textLabel.setText(textField.getText());
 try {
        String querry= "INSERT INTO personne(`nom`, `prenom`) VALUES ('"+usename.getText()+"','"+lastname.getText()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
    }

 /*public ObservableList<Personne> getEtudiant() {
        ObservableList<Personne> list = FXCollections.observableArrayList();
 
        String select = "SELECT * from etudiant";
        con = Connexion.getCnx();
        try {
            st = con.prepareStatement(select);
            rs = st.executeQuery();
            while (rs.next()) {
                Personne et = new Etudiant();
                et.setId(rs.getInt("id"));
                et.setNom(rs.getString("nom"));
                et.setPrenom(rs.getString("prenom"));
                et.setSexe(rs.getString("sexe"));
                list.add(et);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return list;
 
    }*/
   public List<Personne> afficher() {
    // List<Personne> personnes = new ArrayList();
        ObservableList<Personne> personnes = FXCollections.observableArrayList();

        try {
       
        String querry ="SELECT * FROM `personne`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Personne p = new Personne();
            
            p.setId(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString(3));
            personnes.add(p);
        }
        
        
        
        return personnes;
    } catch (SQLException ex) {
        }
    return personnes;
    }
 
    public void affiche() {
        List<Personne> list = afficher();
        colid.setCellValueFactory(new PropertyValueFactory<Personne, Integer>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<Personne, String>("nom"));
        colprenom.setCellValueFactory(new PropertyValueFactory<Personne, String>("prenom"));
        table.setItems((ObservableList<Personne>) list);
 
    }
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
