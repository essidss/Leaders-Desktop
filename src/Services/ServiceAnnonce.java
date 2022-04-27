/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Annonce;
import Model.Categorie;
import Services.IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import utils.DataBase;

/**
 *
 * @author abdallah
 */
public class ServiceAnnonce implements IService<Annonce>{
    private Connection cnx;
    private PreparedStatement st;
    private ResultSet rs;

    public ServiceAnnonce() {
        cnx = DataBase.getInstance().getConnection();

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
    public ObservableList<Annonce> read() throws SQLException {
        ObservableList<Annonce> ls = FXCollections.observableArrayList();
        String req = "SELECT * FROM annonce a INNER JOIN annonce_cat c ON a.categorie_id = c.id";
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
            }catch(SQLException ex){
                //
            }
        return ls;
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
    public void delete(Annonce p) throws SQLException {
        String req = "DELETE FROM `annonce` WHERE id = ?";
            st = cnx.prepareStatement(req);
            st.setInt(1, p.getId());
            st.executeUpdate();
            System.out.println("Successful");
    }

    @Override
    public Annonce read(String d) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
