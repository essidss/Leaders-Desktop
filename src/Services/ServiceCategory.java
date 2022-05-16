/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Modal.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connectivity.ConnectionClass;
import Modal.Posts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author hp
 */
public class ServiceCategory implements IServiceCategory<Category> {


private Connection cnx = ConnectionClass.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Category t) {
    try {
        String querry= "INSERT INTO category( `nom`,`user_id`) VALUES ('"+t.getNom()+"','"+LoginSession.UID+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

 @Override
    public ObservableList afficher() {
        ObservableList<Category> obList = FXCollections.observableArrayList();
        try {
       
        String querry ="SELECT * FROM `category`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Category p = new Category();
            
            p.setIdcat(rs.getInt(1));
            p.setNom(rs.getString("nom"));
            p.setUser_id(rs.getInt("user_id"));
            p.setArchived(rs.getBoolean("archived"));
             obList.add(p);
        }
        
        
        
        return obList;
    } catch (SQLException ex) {
        }
    return obList;
    }

  

 @Override
    public void supprimer(Category t) {
    
  String req="UPDATE `category` SET `archived`='"+1+"' WHERE idcat=?";
         try {
             PreparedStatement ste = cnx.prepareStatement(req);
              ste.setInt(1,t.getIdcat());
             ste.executeUpdate();
             System.out.println("category bien Archivé");
            
         }catch (SQLException ex) {
            System.out.println("Probléme d'archivage ");
            System.out.println(ex.getMessage());
        
         }
        
 
         }

    
    
}
