/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Modal.Posts;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mohamed
 */
public class ServicePosts implements IService<Posts> {

    private Connection cnx = ConnectionClass.getInstance().getCnx();
    ObservableList<Posts> obList = FXCollections.observableArrayList();

    @Override
    public void ajouter(Posts t) {
        Date d1 = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(d1);
        String dc = date;
        try {
            String querry = "INSERT INTO posts(`title`, `content` ,`objet`, `picture`,`created_at`,`user_id`) VALUES ('" + t.getTitle() + "','" + t.getContent() + "','" + t.getObjet() + "','" + t.getPicture() + "','" + dc + "','" + t.getUser_id() + "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }

    @Override
    public List<Posts> afficher() {
        List<Posts> postss = new ArrayList();
        try {

            String querry = "SELECT * FROM `posts` ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(querry);
            while (rs.next()) {
                Posts p = new Posts();

                p.setId(rs.getInt(1));
                p.setTitle(rs.getString("title"));
                p.setContent(rs.getString("content"));
                p.setObjet(rs.getString("objet"));
                p.setPicture(rs.getString("picture"));
                p.setCreated_at(rs.getDate("created_at"));
                p.setIdcat(rs.getInt("idcat"));
                p.setUser_id(rs.getInt("user_id"));
                p.setArchived(rs.getString("archived"));
                p.setNblikes(rs.getInt("nblikes"));

                postss.add(p);
            }

            return postss;
        } catch (SQLException ex) {
        }
        return postss;
    }

    public ObservableList<Posts> getArticle() {
        ObservableList<Posts> obList = FXCollections.observableArrayList();

        try {

            String querry = "SELECT * FROM `posts` WHERE archived='" + 0 + "' ";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(querry);
            while (rs.next()) {
                Posts p = new Posts();

                p.setId(rs.getInt(1));
                p.setTitle(rs.getString("title"));
                p.setContent(rs.getString("content"));
                p.setObjet(rs.getString("objet"));
                p.setArchived(rs.getString("archived"));
                p.setPicture(rs.getString("picture"));
                p.setCreated_at(rs.getDate("created_at"));
                p.setIdcat(rs.getInt("idcat"));
                p.setUser_id(rs.getInt("user_id"));
                p.setNblikes(rs.getInt("nblikes"));
                obList.add(p);
            }

            return obList;
        } catch (SQLException ex) {
        }
        return obList;
    }

    public Posts findByArticleId(int id) {
        try {
            String query2 = "SELECT * FROM `posts` WHERE id=" + id;

            Statement stm = cnx.createStatement();

            Posts p = new Posts();
            ResultSet rs = stm.executeQuery(query2);
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString("title"));
                p.setContent(rs.getString("content"));
                p.setObjet(rs.getString("objet"));
                p.setArchived(rs.getString("archived"));
                p.setPicture(rs.getString("picture"));
                p.setCreated_at(rs.getDate("created_at"));
                p.setIdcat(rs.getInt("idcat"));
                p.setUser_id(rs.getInt("user_id"));
                p.setNblikes(rs.getInt("nblikes"));

                return p;

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void modifier(Posts t) {

        try {
            String req = "UPDATE `posts` SET `title`=?,`content`=?,`objet`=? WHERE id=?";

            PreparedStatement ste = cnx.prepareStatement(req);

            ste.setString(1, t.getTitle());
            ste.setString(2, t.getContent());
            ste.setString(3, t.getObjet());

            ste.setInt(4, t.getId());

            ste.executeUpdate();
            System.out.println(" Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Posts t) {

        String req = "UPDATE `posts` SET `archived`='" + 1 + "' WHERE id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
            System.out.println("post bien Archivé");

        } catch (SQLException ex) {
            System.out.println("Probléme d'archivage ");
            System.out.println(ex.getMessage());

        }

    }

    public List<Posts> search(String entry) throws SQLException {
        List<Posts> arr = new ArrayList<>();

        PreparedStatement ps = cnx.prepareStatement("SELECT id, user_id, title, content, objet, created_at, nblikes, idcat, picture, archived FROM posts  where (title like ?) ");
        ps.setString(1, "%" + entry + "%");
        ResultSet res = ps.executeQuery();

        System.out.println(ps.toString());
        while (res.next()) {
            int id = res.getInt("id");
            int user_id = res.getInt("id");
            String title = res.getString("title");
            String content = res.getString("content");
            String objet = res.getString("objet");
            String picture = res.getString("picture");
            String archived = res.getString("archived");
            Date created_at = res.getDate("created_at");
            int nblikes = res.getInt("nblikes");
            int idcat = res.getInt("idcat");
            int nbviews = res.getInt("nbviews");
            Date d = new Date();
            Posts p = new Posts(id, user_id, title, content, objet, created_at, nblikes, idcat, picture, archived, nbviews);
            System.out.println(p.toString());
            arr.add(p);
        }
        return arr;

    }

    public List<Posts> recherche(String entry) throws SQLException {
        List<Posts> arr = new ArrayList<>();

        List<Posts> list = (ArrayList) afficher();

        list.stream().filter(e -> e.getTitle().equals(entry)).forEach(e -> System.out.println(e));
        return list;

    }

//    public void likedarticle(Posts t) {
//
//        int isLiked = t.getLiked();
//
//        if (isLiked == 0) {
//            try {
//                String req = "UPDATE `article` SET`liked`=1 WHERE id=?";
//
//                PreparedStatement ste = cnx.prepareStatement(req);
//                ste.setInt(1, t.getId());
//
//                ste.executeUpdate();
//                System.out.println(" l'article est liké !!!");
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//        if (isLiked == 1) {
//            try {
//                String req = "UPDATE `article` SET`liked`=0 WHERE id=?";
//
//                PreparedStatement ste = cnx.prepareStatement(req);
//                ste.setInt(1, t.getId());
//
//                ste.executeUpdate();
//                System.out.println(" l'article est disliké !!!");
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//
//        }
//
//    }
    public void Dislikedarticle(Posts t) {

        try {
            String req = "UPDATE `posts` SET`liked`=0 WHERE id=?";

            PreparedStatement ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getId());

            ste.executeUpdate();
            System.out.println(" l'article est disliké !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Posts Maxliked() {

        Posts post = new Posts();
        try {

            String querry = "SELECT id, user_id, title, content, objet, created_at, nblikes, idcat, picture,MAX(nblikes) FROM posts";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(querry);

            Posts p = new Posts();

            p.setId(rs.getInt(1));
            p.setTitle(rs.getString("title"));
            p.setContent(rs.getString("content"));
            p.setObjet(rs.getString("objet"));
            p.setArchived(rs.getString("archived"));
            p.setPicture(rs.getString("picture"));
            p.setCreated_at(rs.getDate("created_at"));
            p.setIdcat(rs.getInt("idcat"));
            p.setUser_id(rs.getInt("user_id"));
            p.setNblikes(rs.getInt("nblikes"));

            return p;
        } catch (SQLException ex) {
        }
        return post;

    }

    public void addtocategory(Posts t, String category) {
        try {
            String req = "UPDATE posts A SET A.idcat= (SELECT idcat FROM category C WHERE C.nom='" + category + "') WHERE A.id=?";

            PreparedStatement ste = cnx.prepareStatement(req);

            ste.setInt(1, t.getId());

            ste.executeUpdate();
            System.out.println(" post affecte' to category !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void setView(int id) {
        try {
            String req = "UPDATE posts  SET nbviews=nbviews+1 WHERE id=" + id;

            PreparedStatement ste = cnx.prepareStatement(req);

            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
