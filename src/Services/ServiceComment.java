/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Modal.Comments;
 import Modal.Article;
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
public class ServiceComment implements IServcieComment<Comments>{
private Connection cnx = ConnectionClass.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Comments t) {
    try {
        String querry= "INSERT INTO comments( `content`) VALUES ('"+t.getContent()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Comments> afficher(Article a) {
     List<Comments> commentss = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `comments` WHERE id_post="+a.getId()+"";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Comments p = new Comments();
            
            p.setId(rs.getInt(1));
            p.setContent(rs.getString("content"));
             commentss.add(p);
        }
        
        
        
        return commentss;
    } catch (SQLException ex) {
        }
    return commentss;
    }

    @Override
    public void modifier(Comments t) {
 
        try {
  String req ="UPDATE `comments` SET `content`=? WHERE id=?";

            PreparedStatement ste = cnx.prepareStatement(req);
            
            ste.setString(1,t.getContent());
            ste.setInt(2,t.getId());

            ste.executeUpdate();
            System.out.println(" Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
}

    @Override
    public void supprimer(Comments t) {
    
try {
  String req="DELETE FROM `comments` WHERE id = ?" ;
           
            PreparedStatement stm = cnx.prepareStatement(req);
            stm.setString(1,t.getContent());

    
    stm.executeUpdate();
                System.out.println(" deleted !!!");

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }

        
 
         }
    
}
