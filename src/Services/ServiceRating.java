/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Connectivity.ConnectionClass;
import Modal.Rating;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class ServiceRating implements IServRating<Rating>{
    private Connection cnx = ConnectionClass.getInstance().getCnx() ;

 @Override
    public List<Rating> afficher()   {
     List<Rating> rates = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `rating` ";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Rating p = new Rating();
            
            p.setId(rs.getInt(1));
            p.setNb_etoiles(rs.getInt("nb_etoiles"));
            p.setPost_id(rs.getInt("post_id"));
            p.setUser_id(rs.getInt("user_id"));
             rates.add(p);
        } return rates;
    } catch (SQLException ex) {
        }
    return rates;
}
}
