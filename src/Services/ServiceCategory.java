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

/**
 *
 * @author hp
 */
public class ServiceCategory implements IServiceCategory<Category> {


private Connection cnx = ConnectionClass.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Category t) {
    try {
        String querry= "INSERT INTO category( `nom`) VALUES ('"+t.getNom()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

 @Override
    public List<Category> afficher() {
     List<Category> categorys = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `category`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Category p = new Category();
            
            p.setIdcat(rs.getInt(1));
            p.setNom(rs.getString("nom"));
             categorys.add(p);
        }
        
        
        
        return categorys;
    } catch (SQLException ex) {
        }
    return categorys;
    }

 @Override
    public void supprimer(Category t) {
    
try {
  String req="DELETE FROM `category` WHERE idcat = ?" ;
           
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setString(1,t.getNom());

    
    stm.executeUpdate();
                System.out.println(" deleted !!!");

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }

        
 
         }
    
    
}
