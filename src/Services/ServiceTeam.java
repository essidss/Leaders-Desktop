/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connectivity.ConnectionClass;
import Modal.Team;
import Modal.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author leith
 */
public class ServiceTeam implements Service<Team>{
    
    private final Connection cnx = ConnectionClass.getCnx() ;

    @Override
    public boolean ajouter(Team t) {
        
        try {
        String querry= "INSERT INTO `Team`(`team_name`, `description`, `isActive`) VALUES ('"+t.getTeamName()+"','"+t.getDescription()+"','"+t.getIsactive()+"')";
        Statement stm = cnx.createStatement();
    
        int row= stm.executeUpdate(querry);
        if(row==0){
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
    public ObservableList<Team> afficher() {
        
        ObservableList<Team> teams =FXCollections.observableArrayList();
        try {
       
        String querry ="SELECT * FROM `Team`";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Team p = new Team();
            
            p.setId(rs.getInt(1));
            p.setTeamName(rs.getString(2));
            p.setDescription(rs.getString(3)); 
            p.setIsactive(rs.getString("isActive"));
            teams.add(p);
//            System.out.println(LoginSession.Role);
        }

        return teams;
        } catch (SQLException ex) {
            }
        return teams;
    }

    @Override
    public void modifier(String a,Team t) {
        
        try {
        String querry= "UPDATE `Team` SET `TeamName`='"+t.getTeamName()+"',`Description`='"+t.getDescription()+"' WHERE TeamName='"+a+"'";
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
    public void supprimer(Team t) {
        
        try {
        String querry= "UPDATE `Team` SET `isactive` = 'deleted' where team_name='"+t.getTeamName()+"'";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(querry);
    
        } catch (SQLException ex) {
            System.out.println("service classe supprimer methode  ");
            System.out.println(ex.getMessage());
        }
    }

//    @Override
//    public void TruncateTable() {
//        
//        try {
//        String querry= "TRUNCATE TABLE `Team`";
//        Statement stm = cnx.createStatement();
//    
//        stm.executeUpdate(querry);
//    
//        } catch (SQLException ex) {
//            System.out.println("service classe vider table methode  ");
//            System.out.println(ex.getMessage());
//
//        }
//    }
    public ObservableList<Team> rechercherTeam(String n){
        
        
        ObservableList<Team> teams =FXCollections.observableArrayList();
        try {
        String querry ="SELECT id,TeamName,Description,isactive FROM `Team` where TeamName like '%"+n+"%' or Description like '%"+n+"%' or isactive like '%"+n+"%'";
        Statement stm = cnx.createStatement();
        ResultSet rs= stm.executeQuery(querry);
        System.out.println(querry);
        while (rs.next()){
            Team p = new Team();
            p.setId(rs.getInt(1));
            p.setTeamName(rs.getString(2));
            p.setDescription(rs.getString(3));
            p.setIsactive(rs.getString(4));
            teams.add(p);
        }
        
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return teams;
    }
    

    

    
}
