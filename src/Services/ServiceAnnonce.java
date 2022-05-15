/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Modal.Annonce;
import Modal.Annonce_Categorie;
import Services.IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import Connectivity.ConnectionClass;

/**
 *
 * @author abdallah
 */
public class ServiceAnnonce implements IService_1<Annonce>{
    private Connection cnx;
    private PreparedStatement st;
    private ResultSet rs;

    public ServiceAnnonce() {
        cnx = ConnectionClass.getInstance().getCnx();

    }

    @Override
    public void add(Annonce p) throws SQLException {


            String req = "INSERT INTO `annonce`(`title`, `description`, `image` , `prix` , `tel` , `email`, `localisation` , `categorie_id`)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
        try {
            st = cnx.prepareStatement(req);
            st.setString(1,p.getTitle());
            st.setString(2,p.getDescription());
            st.setString(3,p.getImage());
            st.setString(4,p.getPrix());
            st.setInt(5,p.getTel());
            st.setString(6,p.getEmail());
            st.setString(7,p.getLocalisation());
            st.setInt(8,p.getId_categorie());
            st.executeUpdate();
            System.out.println("Successful");
        }catch (SQLException ex) {
            // Logger.getLogger(forumServ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
    

    @Override
    public boolean update(Annonce p) throws SQLException {

        try {
        String req = "UPDATE annonce SET title=? ,description=?, image=? ,prix=? ,tel=? ,email=? ,localisation=?,categorie_id=? WHERE id="+ p.getId();
            st = cnx.prepareStatement(req);
            st.setString(1,p.getTitle());
            st.setString(2,p.getDescription());
            st.setString(3,p.getImage());
            st.setString(4,p.getPrix());
            st.setInt(5,p.getTel());
            st.setString(6,p.getEmail());
            st.setString(7,p.getLocalisation());
            st.setInt(8,p.getId_categorie());
            if (st.executeUpdate() > 0) {
                System.out.println("update avec sucées.");
                return true;
            }
            System.out.println("Annonce  modifié.");
        } catch (SQLException ex) {
            // Logger.getLogger(forumServ.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void delete(Annonce annonce){
        try {
        String req = "DELETE FROM annonce WHERE id = ?";
            st = cnx.prepareStatement(req);
            st.setInt(1, annonce.getId());
            st.executeUpdate();
            System.out.println("Annonce Supprimer");
            } catch (SQLException ex) {
           // Logger.getLogger(ServiceProduit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addtocategory(Annonce a,String category)
    {
    try {
    String req ="UPDATE annonce A SET A.categorie_id= (SELECT categorie_id FROM annonce_cat C WHERE C.nom='"+category+"') WHERE A.title=?";

            PreparedStatement ste = cnx.prepareStatement(req);
            
 
            ste.setString(1,a.getTitle());
 
            ste.executeUpdate();
            System.out.println(" Annonce affecte' to category !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 

}

    public ObservableList<Annonce> recherche(String nom1) throws SQLException {

        Connection cnx ;
        cnx = ConnectionClass.getInstance().getCnx();
        String req = "select * from  annonce  where title LIKE '" + nom1 + "%'";
        PreparedStatement pt = cnx.prepareStatement(req);

        ObservableList<Annonce> le = FXCollections.observableArrayList();
        ResultSet rs = pt.executeQuery(req);


         while (rs.next()) {
                int i = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String prix = rs.getString("prix");
                int tel = rs.getInt("tel");
                String email = rs.getString("email");
                String localisation = rs.getString("localisation");
                String categorie = rs.getString("categorie_id");
                
                
                Annonce a = new Annonce(i, title,description,image,prix,tel,email,localisation,categorie);
                le.add(a);


            
        }

        return le;

    }


    @Override
    public List<Annonce> read(){
        ObservableList<Annonce> ls = FXCollections.observableArrayList();
        String req = "SELECT * FROM annonce";
        try {
            st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Annonce a = new Annonce();
                a.setId(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setDescription(rs.getString(3));
                a.setImage(rs.getString(4));
                a.setPrix(rs.getString(5));
                a.setTel(rs.getInt(6));
                a.setEmail(rs.getString(7));
                a.setLocalisation(rs.getString(8));
                a.setCategorie(rs.getString(9));
                ls.add(a);
            }
            System.out.println("Affichage établie");
            return(ls);
            }catch(SQLException ex){
                return null;
            }
    }
  

}
