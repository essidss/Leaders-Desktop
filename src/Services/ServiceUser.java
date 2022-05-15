
package Services;

import Modal.User;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.util.prefs.Preferences;
import Connectivity.ConnectionClass;
import Modal.Posts;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author leith
 */
public class ServiceUser implements Service<User> {
   
    private Connection cnx = ConnectionClass.getInstance().getCnx();
    public static User user;
    ServiceTeam serviceTeam =new ServiceTeam();
    @Override
    public boolean ajouter(User t) {
        
        try {
        String querry= "INSERT INTO `User`(`email`, `username`, `roles`, `password`,`picture_profil`,`isactive`) VALUES ('"+t.getEmail()+"','"+t.getUsername()+"','"+t.getRole()+"','"+t.getPassword()+"','"+t.getAvatar()+"','"+t.getIsactive()+"')";
        Statement stm = cnx.createStatement();
    
        int x = stm.executeUpdate(querry);
        if(x==0){
            return false;
        }else{
            return true;
        }
    } catch (SQLException ex) {
        System.out.println("service classe ajouter methode  ");
        System.out.println(ex.getMessage());
    
    }
     return false;   
    }

    @Override
    public ObservableList<User> afficher() {
        ObservableList<User> users =FXCollections.observableArrayList();
        //List<User> users = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `User`";
        Statement stm = cnx.createStatement();
        
            ResultSet rs= stm.executeQuery(querry);
            
        while (rs.next()){
            User p = new User();
            
            p.setId(rs.getInt(1));
            p.setEmail(rs.getString("email"));

            p.setUsername(rs.getString("username"));
            p.setRole(rs.getString("roles"));
            p.setPassword(rs.getString(5));
            p.setIsactive(rs.getString("isactive"));
            users.add(p);
        }
        return users;
    } catch (SQLException ex) {
        System.out.print(ex);
        }
    return users;
    }

public User findByUserId(int id){
              try {
       String query2="SELECT * FROM `User` WHERE id="+id;

Statement stm = cnx.createStatement();
//                PreparedStatement smt = cnx.prepareStatement(query2);
//                smt.setInt(1, id);
                User p = new User();
                ResultSet rs= stm.executeQuery(query2);
                while(rs.next()){
                  // p= new Posts(rs.getInt("id"),rs.getString("title"),rs.getString(3),rs.getDate("date"),rs.getInt("idcat"));
              p.setId(rs.getInt(1));
            p.setUsername(rs.getString(3));
            p.setEmail(rs.getString(2));
            p.setRole(rs.getString(4));
            p.setPassword(rs.getString(5));
            p.setIsactive(rs.getString(7));

                              return p;

                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                }
              return null;
    }



    @Override
    public void modifier(String t2,User t) {
       
        try {
        String querry= "UPDATE `User` SET `email`='"+t.getEmail()+"',`username`='"+t.getUsername()+"',`roles`='"+t.getRole()+"',`password`='"+t.getPassword()+"' WHERE email='"+t2+"'";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
        if(stm.executeUpdate(querry)==1){
            System.out.print("user modifier");
        }
    
        } catch (SQLException ex) {
            System.out.println("service classe modif methode  ");
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public void supprimer(User t) {
        
        try {
        String querry= "UPDATE `User` SET `isactive` = 'deleted' where email='"+t.getEmail()+"'";
        Statement stm = cnx.createStatement();
    
        stm.executeUpdate(querry);
        if(stm.executeUpdate(querry)==1){
            System.out.print("user supprimer");
        }
        } catch (SQLException ex) {
            System.out.println("service classe supprimer methode  ");
            System.out.println(ex.getMessage());

        }
    }


    public boolean login(String email, String password){
        
        try {
           
        String querry ="SELECT * FROM `User` where email ='"+email+"' and password ='"+password+"'";
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(querry);

        if(!rs.isBeforeFirst()){
            System.out.println("user not found !!!!");
            return false;
        }
        else{
            System.out.println("user is logged");
            while(rs.next()){
                LoginSession.UID=rs.getInt("id");
                LoginSession.Role=rs.getString("roles");
                LoginSession.Username=rs.getString("username");
                LoginSession.Email=rs.getString("email");
                LoginSession.Password=rs.getString("password"); 
                LoginSession.picture_profil=rs.getString("picture_profil");
                LoginSession.IsLogged=true;
            }
            

            return true;
        }
        } catch (SQLException ex) {
            //System.out.println(ex);
        }
        return false;
    }  
    
    public void logout(){
        LoginSession.IsLogged=false;
    }
    
    public ObservableList<User> rechercherUser(String n){
        
        //List<User> users = new ArrayList();
        ObservableList<User> users =FXCollections.observableArrayList();
        try {
        String querry ="SELECT id,username,email,password,roles FROM `User` where email like '%"+n+"%' or username like '%"+n+"%' or roles like '%"+n+"%'";
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(querry);
        System.out.println(querry);
        while (rs.next()){
            User p = new User();
            p.setId(rs.getInt(1));
            p.setUsername(rs.getString(2));
            p.setEmail(rs.getString(3));
            p.setRole(rs.getString(4));
            p.setPassword(rs.getString(5));
            users.add(p);
        }
        
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return users;
    }
    
    public ObservableList<User> triWithUsername(){
        ObservableList<User> users =FXCollections.observableArrayList();
        users.addAll(afficher().stream()
        .sorted((o1, o2)->o1.getUsername().compareTo(o2.getUsername()))
        .collect(Collectors.toList()));
        return users;
    }
    
    public ObservableList<User> triWithEmail(){
        ObservableList<User> users =FXCollections.observableArrayList();
        users.addAll(afficher().stream()
        .sorted((o1, o2)->o1.getEmail().compareTo(o2.getEmail()))
        .collect(Collectors.toList()));
        return users;
    }
    
    public ObservableList<User> triWithIsActive(){
        ObservableList<User> users =FXCollections.observableArrayList();
        users.addAll(afficher().stream()
        .sorted((o1, o2)->o1.getIsactive().compareTo(o2.getIsactive()))
        .collect(Collectors.toList()));
        return users;
    }









    
}

    

