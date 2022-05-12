/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
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
import Model.Event;
import Model.Categorie;
import java.sql.PreparedStatement;
import utils.DataBase;
/**
 *
 * @author HP
 */

public class ServiceE implements Ievent {

    //var
    Connection cnx = DataBase.getInstance().getConnection();
@Override
    public boolean ajouterEvent(Event c) {
                                            
        String request = "INSERT INTO event(`Name`, `date`,`lieu`,`description`,`picture`,`categorie_id`) VALUES ('"+c.getName()+"','"+c.getDate()+"','"+c.getLieu()+"','"+c.getDescription()+"','"+c.getPicture()+"',"+c.getCategorie()+")";
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
    
//
    @Override
    public boolean modifierEvent(Event c) {
        
        String req = "UPDATE `event` SET `Name`='" + c.getName()+ "',`date`='" + c.getDate() + "',`lieu`='" + c.getLieu() + "',`description`='" + c.getDescription() + "',`picture`='" + c.getPicture() + "',`categorie_id`=" + c.getCategorie() +  " WHERE `id` = " + c.getId() + " ";
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
    public boolean supprimerEvent(Event c) {
        String req = "DELETE FROM `event` WHERE `id` = " + c.getId() + " ";

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
    public List<Event> afficherEvent() {
        List<Event> events = new ArrayList<Event>();
        String query = "SELECT * FROM event c inner join  categorie p on p.id  = c.categorie_id  where c.archiver=0";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                events.add(new Event(rs.getInt(1),
                         rs.getInt(2),
                        rs.getString(3),
                           rs.getString(4),
                          rs.getString(5),
                          
                           
                             rs.getString(6),
                     rs.getString(7)
                     
                        //new Reclamation( rs.getString("description")))
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return events;
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
    public ObservableList<Event> getCmList() throws SQLException {
        ObservableList<Event> Cmlist = FXCollections.observableArrayList();

        List<Event> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT * FROM event c inner JOIN categorie p  where c.categorie_id=p.id";

        ResultSet rs;
        rs = st.executeQuery(query);
        Event events;
        while (rs.next()) {
            events = (new Event(rs.getInt(1),
                         rs.getInt(2),
                      rs.getString(3),
                     rs.getString(4),
                     rs.getString(5),
                      rs.getString(6),
                     rs.getString(7)
            ));
                    
            //System.out.println(events);
            Cmlist.add(events);

        }
        return Cmlist;
    }

    //******************listtt
    public ObservableList<Categorie> getpostsList() throws SQLException {
        ObservableList<Categorie> postslist = FXCollections.observableArrayList();

        List<Categorie> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT id FROM categorie";

        ResultSet rs;
        rs = st.executeQuery(query);
        Categorie categories;
        while (rs.next()) {
            categories = new Categorie(rs.getInt("id"));
            //rs.getInt(req)

            //System.out.println(events);
            postslist.add(categories);

        }
        return postslist;
    }

    
    
    
    
     @Override
    public void arch(Event t) {
         try {
            String req = "update event set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("event archivée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    
    
    
public List<Event> tristreamnom() {
   
   return afficherEvent().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

    }   
    
    
public List<Event> tristreamdescription() {
   
   return afficherEvent().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
 public List<Event> tristreamlieu() {
   
  return afficherEvent().stream().sorted((p1,p2)->p1.getLieu().compareTo(p2.getLieu())).collect(Collectors.toList());

    }
 public List<Event> tristreamdate() {
   
  return afficherEvent().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }


    
    
    
    
    
    
    
    
    
    
    
@Override
    public List<Event> rechstream(Event x) {
     
     
     return afficherEvent().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }

}
