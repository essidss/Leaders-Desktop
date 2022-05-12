///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Services;
//
//import com.mysql.jdbc.PreparedStatement;
//import interfaces.Ireclamation;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.SortedMap;
//import java.util.TreeMap;
//import java.util.stream.Collectors;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import Model.Reponse;
//import Model.Reclamation;
//import utils.MyDb;
//
//
//
//public class ServiceReclam implements Ireclamation {
//
//    //var
//    Connection cnx = MyDb.getInstance().getCnx();
//
//    @Override
//     public boolean ajouterReclamation(Reclamation p) {
//        String request = "INSERT INTO `reclamation`(`sujet`, `description`, `date`) VALUES ('" + p.getSujet() + "','" + p.getDescription() + "','" + p.getDate() + "')";
//        try {
//            Statement st = cnx.createStatement();
//            if (st.executeUpdate(request) == 1) {
//                return true;
//            }
//            return false;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }
//    }
// public List<Reclamation> sh() {
//        List<Reclamation> reclamations = new ArrayList<Reclamation>();
//
//        String req = "SELECT * FROM reclamation  ";
//
//        Statement st = null;
//        try {
//            st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//
//            //SOB HEDHA FI HEDHA
//            while (rs.next()) {
//                reclamations.add(new Reclamation(rs.getString(2), rs.getString(3), rs.getString(4)
//                        
//                      
//                ) );
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return reclamations;
//    }
//
//    @Override
//    public List<Reclamation> afficherReclamation() {
//        List<Reclamation> reclamations = new ArrayList<Reclamation>();
//
//        String req = "SELECT * FROM reclamation  ";
//
//        Statement st = null;
//        try {
//            st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//
//            //SOB HEDHA FI HEDHA
//            while (rs.next()) {
//                reclamations.add(new Reclamation(rs.getInt("id"),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4)
//                        
//                ));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return reclamations;
//    }
//
//    @Override
//    public boolean modifierReclamation(Reclamation p) {
//        Date d = Date.valueOf(LocalDate.now());
//        String req =  "UPDATE `reclamation` SET `description`=?,`date`=?,`sujet`=? WHERE id =?";
//        try {
//            Statement st = cnx.createStatement();
//            if (st.executeUpdate(req) == 1) {
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    @Override
//    public boolean supprimerReclamation(Reclamation p) {
//        String req = "DELETE FROM `reclamation` WHERE `id` = " + p.getId() + " ";
//
//        try {
//            Statement st = cnx.createStatement();
//            if (st.executeUpdate(req) == 1) {
//                return true;
//            }
//            return false;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
////    public List<Post> afficherTrie() {
////        List<Post> posts = new ArrayList<>();
////        String sqll = "select * from `post` order by datep desc";
////
////        try {
////            Statement st = cnx.prepareStatement(sqll);
////
////            ResultSet rs = st.executeQuery(sqll);
////            while (rs.next()) {
////                Post a = new Post();
////                a.setId(rs.getInt("id"));
////                a.setTitle(rs.getString("title"));
////                a.setContent(rs.getString("content"));
////                a.setDatep(rs.getDate("datep"));
////                a.setId_user(new User(rs.getInt("id_user")));
////                posts.add(a);
////                System.out.println("ID : " + a.getId() + "\n content : " + a.getContent() + "\n Title : " + a.getTitle() + "\n Date : " + a.getDatep() + "\n id_user: " + a.getId_user() + "\n Id ");
////                //System.out.println("Afficher avec succés !");
////            }
////        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////        }
////        return posts;
////
////    }
//
////    @Override
////    public ArrayList<Post> AfficherTrie() {
////        List<Post> posts = new ArrayList<>();
////        String sqll = "select * from `post` order by content asc";
////
////        try {
////            Statement st = cnx.prepareStatement(sqll);
////
////            ResultSet rs = st.executeQuery(sqll);
////            while (rs.next()) {
////                Post a = new Post();
////                a.setId(rs.getInt("id"));
////                a.setTitle(rs.getString("title"));
////                a.setContent(rs.getString("content"));
////                a.setDatep(rs.getDate("datep"));
////                a.setId_user(new User(rs.getInt("id_user")));
////                posts.add(a);
////                System.out.println("ID : " + a.getId() + "\n content : " + a.getContent() + "\n Title : " + a.getTitle() + "\n Date : " + a.getDatep() + "\n id_user: " + a.getId_user() + "\n Id ");
////                //System.out.println("Afficher avec succés !");
////            }
////        } catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////        }
////        return (ArrayList<Post>) posts;
////    }
//
/////*******************recherche with stream**********************//
////    public ArrayList<Post> findBytitle(String title) {
////
////        List<Post> resultat = afficherPost().stream().filter(post -> title.equals(post.getTitle())).collect(Collectors.toList());
////        return (ArrayList<Post>) resultat;
////    }
////
////    //************************trie  par date with stream***********************//
////    @Override
////    public ArrayList<Post> sortByDate() {
////        List<Post> posts = afficherPost();
////        List<Post> resultat = posts.stream().sorted(Comparator.comparing(Post::getDatep)).collect(Collectors.toList());
////        return (ArrayList<Post>) resultat;
////    }
//
//    @Override
//    public List<Reclamation> show() {
//
//        List<Reclamation> reclamations = new ArrayList<Reclamation>();
//
//        String req = "SELECT * FROM reclamation ";
//
//        Statement st = null;
//        try {
//            st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//
//            while (rs.next()) {
//                reclamations.add(new Reclamation(rs.getInt("id"), rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4)
//                       
//                //rs.getInt(req)
//                ));
//                //rs.getString("email"))
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return reclamations;
//    }
//
//    public String getContentbyID(int id) {
//        String req = "select * from reclamation where id='" + id + "' ";
//
//        try {
//            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//
//                return rs.getString("sujet");
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return "";
//
//    }
//
////   //----------------------------------- Display Cat_age by ID -----------------------------------------------------------------// 
////  
//    public String gettitlebyID(int id) {
//        String req = "select * from reclamation where id='" + id + "' ";
//
//        try {
//            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//
//                return rs.getString("description");
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return "";
//
//    }
////    
////    //----------------------------------------  Display  by ID --------------------------------------------------------------//
////     
//
//    public Date getdatebyID(int id) {
//        String req = "select * from reclamation where id='" + id + "' ";
//
//        try {
//            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
//            st.setInt(1, id);
//            ResultSet rs = st.executeQuery(req);
//            while (rs.next()) {
//
//                return rs.getDate("date");
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return new Date(0);
//
//    }
////     //----------------------------------------  Display by ID --------------------------------------------------------------//
////    
//
////    public User getuserbyID(int id) {
////        String req = "select * from post where id='" + id + "' ";
////
////        try {
////            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
////            st.setInt(1, id);
////            ResultSet rs = st.executeQuery(req);
////            while (rs.next()) {
////
////                return new User(rs.getInt("user_id"));
////            }
////        } catch (SQLException ex) {
////            System.err.println(ex.getMessage());
////        }
////        return new User();
////
////    }
////
////    public void modifier(Reclamation p, int id) {
////
////        String req = "update user set content = ? , titre = ? , datep = ? , id_user = ? where id = ?";
////
////        try {
////            PreparedStatement st = (PreparedStatement) cnx.prepareStatement(req);
////
////            st.setString(1, p.getContent());
////            st.setString(2, p.getTitle());
////            st.setDate(3, p.getDatep());
////            st.setString(4, p.getId_user().toString());
////            st.setInt(5, id);
////
////            st.executeUpdate();
////
////        } catch (SQLException ex) {
////            System.out.println(ex);
////        }
////
////    }
//
//////------------------------------------ Calculer nbAct -------------------------------------------//
//    public String calculer_nbp(String sujet) {
//        String l = null;
//        String requete = "SELECT COUNT(*) FROM reclamation where sujet='" + sujet + "'";
//        try {
//
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            if (rs.next()) {
//                String chaine = String.valueOf(rs.getString(1));
//                l = chaine;
//                return l;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        return l;
//    }
//// 
//    //-----------------------
//////------------------------------- Liste 2 --------------------------------------------------------------------//
////    public List <Post> liste2()
////    {
////        String sql = "select content,title,datep,id_user from post";
////        
////       List <Post> list = new ArrayList<>(); 
////       try {
////               PreparedStatement st = (PreparedStatement) cnx.prepareStatement(sql);
////
////         ResultSet rs=st.executeQuery();
////       
////       while (rs.next())
////       {
////           list.add(new Post(rs.getString("title"),rs.getString("content"),rs.getDate("date")));
////       }
////       
////       }
////       catch (SQLException ex) {
////            System.out.println(ex.getMessage());
////        }   
////    return list; 
////    }
//    //--------------------------------- getpostttssList() ------------------------------------------------------//
////    public ObservableList<Post> getCoursList() throws SQLException {
////        ObservableList<Post> Courslist = FXCollections.observableArrayList();
////
////        List<Post> listb = new ArrayList<>();
////        Statement st = cnx.createStatement();
////        String query = "SELECT * FROM post p inner JOIN user u  where p.id_user=u.id_user";
////
////        ResultSet rs;
////        rs = st.executeQuery(query);
////        Post postss;
////        while (rs.next()) {
////            postss = (new Post(rs.getInt("id"), rs.getString(2),
////                    rs.getString(3),
////                    rs.getDate(4),
////                    // new User(rs.getString("email"))
////                    new User(rs.getInt("id_user"))
////            //rs.getInt(req)
////            ));
////            //System.out.println(events);
////            Courslist.add(postss);
////
////        }
////        return Courslist;
////    }
//
//    //******************listtt
////    public ObservableList<User> getusersList() throws SQLException {
////        ObservableList<User> userslist = FXCollections.observableArrayList();
////
////        List<User> listb = new ArrayList<>();
////        Statement st = cnx.createStatement();
////        String query = "SELECT id_user FROM user";
////
////        ResultSet rs;
////        rs = st.executeQuery(query);
////        User postss;
////        while (rs.next()) {
////            postss = new User(rs.getInt("id_user"));
////            //rs.getInt(req)
////
////            //System.out.println(events);
////            userslist.add(postss);
////
////        }
////        return userslist;
////    }
////
////    public String calculer_nbseance(String title) {
////        String l = null;
////        String requete = "SELECT COUNT(*) FROM post where title='" + title + "'";
////        try {
////
////            Statement st = cnx.createStatement();
////            ResultSet rs = st.executeQuery(requete);
////            if (rs.next()) {
////                String chaine = String.valueOf(rs.getString(l));
////                l = chaine;
////                return l;
////            }
////        } catch (SQLException ex) {
////        }
////
////        return l;
////    }
////public List<Post> chercherPost(List<Post> initialList, String input) {
////        
////         List<Post> prodList;
////          prodList = initialList.stream()
////                  .map( Post::concat )
////                  .filter(pt -> pt.toLowerCase().contains(input.toLowerCase()))
////                  .map(pt -> new Post(pt.split(".@.")[0],pt.split(".@.")[1]))
////                  .collect( Collectors.toList());
////        
////        return prodList;
////    }
//
//}











/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Model.Categorie;
import interfaces.Ireponse;
import interfaces.Ireclamation;
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

public class ServiceReclam implements Ireclamation {

    //var
    Connection cnx = MyDb.getInstance().getCnx();
@Override
    public boolean ajouterReclamation(Reclamation c) {
                                            
        String request = "INSERT INTO reclamation(`sujet`, `date`,`description`) VALUES ('"+c.getSujet()+"','"+c.getDate()+"','"+c.getDescription()+"')";
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
    public boolean modifierReclamation(Reclamation c) {
        
        String req = "UPDATE `reclamation` SET `sujet`='" + c.getSujet()+ "',`date`='" + c.getDate() + "',`description`='" + c.getDescription() +  "'";
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
    public boolean supprimerReclamation(Reclamation c) {
        String req = "DELETE FROM `reclamation` WHERE `id` = " + c.getId() + " ";

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
    public List<Reclamation> afficherReclamation() {
        List<Reclamation> reclamations = new ArrayList<Reclamation>();
        String query = "SELECT * FROM reclamation where archiver=0 ";
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                reclamations.add(new Reclamation(rs.getInt(1),
                      
                      rs.getString(3) ,
                      rs.getString(4),

                     rs.getString(2)
//                     
                        //new Reclamation( rs.getString("description")))
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamations;
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
    public ObservableList<Reclamation> getCmList() throws SQLException {
        ObservableList<Reclamation> Cmlist = FXCollections.observableArrayList();

        List<Reclamation> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT * FROM reclamation";

        ResultSet rs;
        rs = st.executeQuery(query);
        Reclamation reclamations;
        while (rs.next()) {
            reclamations = (new Reclamation(rs.getInt(1),
                         
                      rs.getString(3) ,
                      rs.getString(4),
                      rs.getString(2)
              
            ));
                    
            //System.out.println(events);
            Cmlist.add(reclamations);

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
    public void arch(Reclamation t) {
         try {
            String req = "update reclamation set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("reclamation archivée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }




public List<Reclamation> tristreamdescription() {
   
   return afficherReclamation().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
 public List<Reclamation> tristreamsujet() {
   
  return afficherReclamation().stream().sorted((p1,p2)->p1.getSujet().compareTo(p2.getSujet())).collect(Collectors.toList());

    }
 public List<Reclamation> tristreamdate() {
   
  return afficherReclamation().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }










@Override
    public List<Reclamation> rechstream(Reclamation x) {
     
     
     return afficherReclamation().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }



 

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     public ObservableList<Reclamation> getCoursList() throws SQLException {
        ObservableList<Reclamation> Courslist = FXCollections.observableArrayList();

        List<Reclamation> listb = new ArrayList<>();
        Statement st = cnx.createStatement();
        String query = "SELECT * FROM reclamation ";

        ResultSet rs;
        rs = st.executeQuery(query);
        Reclamation fact;
        while (rs.next()) {
            fact = (new Reclamation( rs.getString(1),
                    rs.getString(2),rs.getString(3)
                 
                  
    
            ));
         
            Courslist.add(fact);

        }
        return Courslist;
    }
    
    
    
}
