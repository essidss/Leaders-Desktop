/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Modal.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connectivity.ConnectionClass;

/**
 *
 * @author Mohamed
 */
public class ServicePersonne implements IService<Personne>{
private Connection cnx = ConnectionClass.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Personne t) {
    try {
        String querry= "INSERT INTO personne(`nom`, `prenom`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Personne> afficher() {
     List<Personne> personnes = new ArrayList();
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

    @Override
    public void modifier(Personne t) {
 
        try {
  String req ="UPDATE `personne` SET `nom`=?,`prenom`=? WHERE id=?";

            PreparedStatement ste = cnx.prepareStatement(req);
            
            ste.setString(1,t.getNom());
            ste.setString(2,t.getPrenom());
            ste.setInt(3,t.getId());

            ste.executeUpdate();
            System.out.println(" Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
}

    @Override
    public void supprimer(Personne t) {
    
try {
         String querry ="DELETE FROM personne where prenom = '"+t.getPrenom()+"'";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
 
         }
    
}
