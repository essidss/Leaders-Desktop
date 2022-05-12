

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import interfaces.Icategorie;
import interfaces.Ievent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Categorie;
import Model.Event;
import java.sql.PreparedStatement;
import utils.DataBase;
/**
 *
 * @author HP
 */

public class ServiceC implements Icategorie {

    //var
    Connection cnx = DataBase.getInstance().getConnection();
@Override
    public boolean ajouterCategorie(Categorie c) {
                                            
        String request = "INSERT INTO categorie(`name`, `description`) VALUES ('"+c.getName()+"','"+c.getDescription()+"')";
        System.out.println(request);
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(request) == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    

    @Override
    public boolean modifierCategorie(Categorie c) {
        
        String req = "UPDATE `categorie` SET `name`='" + c.getName()+ "',`description`='" + c.getDescription() +  "'";
        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   @Override
    public boolean supprimerCategorie(Categorie c) {
        String req = "DELETE FROM `categorie` WHERE `id` = " + c.getId() + " ";

        try {
            Statement st = cnx.createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    @Override
//    public int Commentsum() {
//        String req3 = "SELECT COUNT(*) AS commentCount FROM comment ";
//        try {
//            Statement st = cnx.prepareStatement(req3);
//            ResultSet rs = st.executeQuery(req3);
//            while (rs.next()) {
//                int count = rs.getInt("commentCount");
//                //  int count = rs.getInt(1);
//                return count;
//                //System.out.println(" LE NOMBRE DES COMMENTAIRES  = "+count+"COMMENTAIRES");
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return Commentsum();
//    }

    @Override
    public List<Categorie> afficherCategorie() {
        List<Categorie> categories = new ArrayList<Categorie>();
        String query = "SELECT * FROM categorie where archiver=0 ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                categories.add(new Categorie(rs.getInt(1),
                      
                      rs.getString(2) ,
                      rs.getString(3)

                 
//                     
                        //new Reclamation( rs.getString("description")))
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

////************************trie nblike with stream***********************//
//
//    public ArrayList<Comment> sortBynblike() {
//            List<Comment> comments=afficherComment();
//         List<Comment> resultat=comments.stream().sorted(Comparator.comparing(Comment::getNblike).reversed()).collect(Collectors.toList());
//         resultat.forEach(System.out::println);
//        return (ArrayList<Comment>) resultat;
//    }
//
//********************best post***************
//    public Map<Integer, List<String>> bestpost(int resp) {
//        List<Comment> comments = afficherComment();
//        Map<Integer, List<String>> Postss = comments.stream()
//                .filter(Comment -> Comment.getResp() >= Integer.max(resp, resp))
//                // 
//                .sorted((a, b) -> a.getResp() - b.getResp())
//                .collect(Collectors.groupingBy(Comment::getResp,
//                        Collectors.mapping(
//                                Comment -> Comment.getContenu(), Collectors.toList()))) // .max(Comparator.comparing(Comment::getResp))
//                ;
//
//        return Postss;
//    }

    // Function takes two parameter
    public String censor(String text, String word) {

        // Break down sentence by ' ' spaces
        // and store each individual word in
        // a different list
        

        // A new string to store the result
        String result = "";

        // Creating the censor which is an asterisks
        // "*" text of the length of censor word
        String stars = "";
        for (int i = 0; i < word.length(); i++) {
            stars += '*';
        }

        // Iterating through our list
        // of extracted words
        int index = 0;
        String[] word_list = text.split("\\s+");
        for (String i : word_list) {
            if (i.compareTo(word) == 0) // changing the censored word to
            // created asterisks censor
            {
                word_list[index] = stars;
            }
            index++;
        }

        // join the words
        for (String i : word_list) {
            result += i + ' ';
        }

        return result;
    }

    //  ***********
//--------------------------------- getcommttssList() ------------------------------------------------------//
    public ObservableList<Categorie> getCmList() throws SQLException {
        ObservableList<Categorie> Cmlist = FXCollections.observableArrayList();

        List<Categorie> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT * FROM categorie";

        ResultSet rs;
        rs = st.executeQuery(query);
        Categorie categories;
        while (rs.next()) {
            categories = (new Categorie(rs.getInt(1),
                         
                       rs.getString(2) ,
                      rs.getString(3)
              
            ));
                    
            //System.out.println(events);
            Cmlist.add(categories);

        }
        return Cmlist;
    }

    //******************listtt
//    public ObservableList<Reclamation> getpostsList() throws SQLException {
//        ObservableList<Reclamation> postslist = FXCollections.observableArrayList();
//
//        List<Reclamation> listb = new ArrayList<>();
//        Statement st = cnx.createStatement();
//        String query = "SELECT id FROM reclamation";
//
//        ResultSet rs;
//        rs = st.executeQuery(query);
//        Reclamation reclamations;
//        while (rs.next()) {
//            reclamations = new Reclamation(rs.getInt("id"));
//            //rs.getInt(req)
//
//            //System.out.println(events);
//            postslist.add(reclamations);
//
//        }
//        return postslist;
//    }
    
    
    
    
     @Override
    public void arch(Categorie t) {
         try {
            String req = "update categorie set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("categorie modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }



       
public List<Categorie> tristreamnom() {
   
   return afficherCategorie().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

    }
  public List<Categorie> tristreamdescription() {
   
  return afficherCategorie().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
    

  

    public List<Categorie> rechstream(Categorie x) {
     
     
     return afficherCategorie().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }


}
