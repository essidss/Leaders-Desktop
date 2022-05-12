/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import interfaces.Ireponse;
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
import Model.Reclamation;
import Model.Reponse;
import java.sql.PreparedStatement;
import utils.MyDb;
/**
 *
 * @author HP
 */

public class ServiceRep implements Ireponse {

    //var
    Connection cnx = MyDb.getInstance().getCnx();
@Override
    public boolean ajouterReponse(Reponse c) {
                                            
        String request = "INSERT INTO Reponse(`reponse`, `date`,`reclamation_id`) VALUES ('"+c.getReponse()+"','"+c.getDate()+"',"+c.getReclamation()+")";
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
    public boolean modifierReponse(Reponse c) {
        
        String req = "UPDATE `reponse` SET `reponse`='" + c.getReponse()+ "',`date`='" + c.getDate() + "',`reclamation_id`=" + c.getReclamation() +  " WHERE `id` = " + c.getId() + " ";
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
    public boolean supprimerReponse(Reponse c) {
        String req = "DELETE FROM `reponse` WHERE `id` = " + c.getId() + " ";

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
    public List<Reponse> afficherReponse() {
        List<Reponse> reponses = new ArrayList<Reponse>();
        String query = "SELECT * FROM reponse c inner join  reclamation p on p.id  = c.reclamation_id where c.archiver=0 ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                reponses.add(new Reponse(rs.getInt("id"),
                         rs.getInt(2),
                        rs.getString(3),
                     rs.getString(4)
                     
                        //new Reclamation( rs.getString("description")))
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reponses;
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
    public ObservableList<Reponse> getCmList() throws SQLException {
        ObservableList<Reponse> Cmlist = FXCollections.observableArrayList();

        List<Reponse> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT * FROM reponse c inner JOIN reclamation p  where c.reclamation_id=p.id";

        ResultSet rs;
        rs = st.executeQuery(query);
        Reponse reponses;
        while (rs.next()) {
            reponses = (new Reponse(rs.getInt("id"),
                         rs.getInt(2),
                        rs.getString(3),
                     rs.getString(4)
            ));
                    
            //System.out.println(events);
            Cmlist.add(reponses);

        }
        return Cmlist;
    }

    //******************listtt
    public ObservableList<Reclamation> getpostsList() throws SQLException {
        ObservableList<Reclamation> postslist = FXCollections.observableArrayList();

        List<Reclamation> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT id FROM reclamation";

        ResultSet rs;
        rs = st.executeQuery(query);
        Reclamation reclamations;
        while (rs.next()) {
            reclamations = new Reclamation(rs.getInt("id"));
            //rs.getInt(req)

            //System.out.println(events);
            postslist.add(reclamations);

        }
        return postslist;
    }

      
public List<Reponse> tristreamdescription() {
   
   return afficherReponse().stream().sorted((p1,p2)->p1.getReponse().compareTo(p2.getReponse())).collect(Collectors.toList());

    }
  public List<Reponse> tristreamdate() {
   
  return afficherReponse().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }
    
    
    
    
    
@Override
    public List<Reponse> rechstream(Reponse x) {
     
      return afficherReponse().stream().filter(p->p.getReponse().contains(x.getReponse())).collect(Collectors.toList());
  

       
    }
    
    
    
     @Override
    public void arch(Reponse t) {
         try {
            String req = "update reponse set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("reclamation archivée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
}
