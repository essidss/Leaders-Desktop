/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Model.Annonce_Categorie;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import utils.DataBase;

/**
 *
 * @author aboud
 */
public class ModifierCategorieController implements Initializable{
    @FXML
    private TextField tfNom;
    
    @FXML
    private Button save;
    
    String query = null;
    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Annonce_Categorie categorie = null;
    private boolean update;
    int categorieId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @FXML
    private void save(MouseEvent event) {

        connection = DataBase.getInstance().getConnection();
        String name = tfNom.getText();

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            clean();
            System.out.println("Saved");
        }

    }
    @FXML
    private void clean() {
        tfNom.setText(null);
    }
    
    void setTextField(int id, String nom) {

        categorieId = id;
        tfNom.setText(nom);

    }
    
    void setUpdate(boolean b) {
        this.update = b;

    }
}
