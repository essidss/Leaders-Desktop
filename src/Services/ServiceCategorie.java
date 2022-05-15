/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Modal.Annonce_Categorie;
import Services.IServiceCategorie;
import Connectivity.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdallah
 */
public class ServiceCategorie implements IServiceCategorie{


    Connection cn = ConnectionClass.getInstance().getCnx();
    PreparedStatement pt;
    ResultSet rs;
    ArrayList<Annonce_Categorie> cat = new ArrayList<>();



    @Override
    public void add(Annonce_Categorie cat) {
        String req = "INSERT INTO `annonce_cat` (`nom`) "
                + "VALUES (?)";
        try {
            pt = cn.prepareStatement(req);
            pt.setString(1, cat.getNom());
            pt.executeUpdate();
            System.out.println("Ajout  établie.");
        } catch (SQLException ex) {
            //Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void delete(Annonce_Categorie categorie) {
        try {
            String req = "DELETE FROM annonce_cat WHERE id=?";
            pt = cn.prepareStatement(req);
            pt.setInt(1, categorie.getId());
            pt.executeUpdate();
            System.out.println("Catégorie  supprimée.");
        } catch (SQLException ex) {
           // Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public boolean update(Annonce_Categorie c) {
        
            String req = "UPDATE annonce_cat SET nom=? WHERE id=" + c.getId();
            try {
            pt = cn.prepareStatement(req);
            pt.setInt(1, c.getId());
            
            pt.executeUpdate();
            System.out.println("update avec sucées.");

        } catch (SQLException ex) {
            //Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
   

    @Override
    public List<Annonce_Categorie> getall() {
        String req = "SELECT * FROM annonce_cat";
        try {
            pt = cn.prepareStatement(req);
            rs = pt.executeQuery();
            while (rs.next()) {
                Annonce_Categorie c = new Annonce_Categorie();
                c.setNom(rs.getString(2));
                c.setId(rs.getInt(1));
                cat.add(c);
            }
            System.out.println("Affichage  établie.");
            return cat;
        } catch (SQLException ex) {
            //Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    public ObservableList<Annonce_Categorie> recherche(String nom1) throws SQLException {

        Connection cnx ;
        cnx = ConnectionClass.getInstance().getCnx();
        String req = "select * from  annonce_cat  where nom LIKE '" + nom1 + "%'";
        PreparedStatement pt = cnx.prepareStatement(req);

        ObservableList<Annonce_Categorie> le = FXCollections.observableArrayList();
        ResultSet rs = pt.executeQuery(req);


         while (rs.next()) {
                int i = rs.getInt("id");
                String nom = rs.getString("nom");
                
                Annonce_Categorie c = new Annonce_Categorie(i, nom);
                le.add(c);


            
        }

        return le;

    }

}
