/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Model.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.MyDb;

/**
 *
 * @author Skander
 */
public class ServiceEvent implements IService<Event>{
private  Connection cnx = MyDb.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Event t) {
    try {
        String querry= "INSERT INTO event(`Name`, `date`,`description`,`lieu`,`picture`,`categorie_id`) VALUES ('"+t.getName()+"','"+t.getDate()+"','"+t.getDescription()+"','"+t.getLieu()+"','"+t.getPicture()+"','"+t.getCategorie()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Event> afficher() {
     List<Event> events = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `event` where archiver =0";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Event p = new Event();
            
             p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
               
                 p.setLieu(rs.getString("lieu"));
                  p.setDate(rs.getString("date"));
                  p.setPicture(rs.getString("picture"));
                   p.setCategorie(rs.getInt("categorie_id"));
                 
            events.add(p);
            
            
        }
        
        
        
        return events;
    } catch (SQLException ex) {
        }
    return events;
    }

  @Override 
   public void modifier(Event t) {
        try {
            String requete =  "UPDATE `event` SET `Name`=?,`description`=?,`lieu`=?,`date`=?,`picture`=?,`categorie_id`=? WHERE id =?";
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getName());
            pst.setString(2, t.getDescription());
             pst.setString(3, t.getLieu());
              pst.setString(4, t.getDate());
               pst.setString(5, t.getPicture());
                pst.setInt(6, t.getCategorie());
                  pst.setInt(7, t.getId());
            pst.executeUpdate();
            System.out.println("Evenement a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }  
   
   
   
   
   
   
   
   @Override
    public void supprimer(int z) {
        try
       {
           //DELETE FROM  WHERE 0
           String requete="DELETE FROM `event` WHERE id ="+z ;
          PreparedStatement pste=MyDb.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("un évènement a été supprimé");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
         }
    



//
//
// @Override
//    public void rechercher(int x) {
//        List<Event> events = new ArrayList();
//      boolean test ;
//         try {
//       
//        String query ="SELECT * FROM event";
//        Statement stm = cnx.createStatement();
//            ResultSet rs= stm.executeQuery(query);
//        while (rs.next()){
//            Event c = new Event();
//            
//             c.setId(rs.getInt(1));
//            c.setName(rs.getString("name"));
//            c.setDescription(rs.getString("description"));
//            c.setLieu(rs.getString("lieu"));
//            c.setDate(rs.getString("date"));
//            c.setPicture(rs.getString("picture"));
//            
//            events.add(c);
//        }
//       
//   test =events.stream().anyMatch((p -> p.getId()==x ));
//   if (test ==true ){
//     for (int i = 0; i < events.size(); i++) {
//           if (events.get(i).getId()== x) {
//                 System.out.println( events.get(i));
//           
//           } }
//   
//   }
//   else
//   {
//       System.out.println( "aucun evenement");
//   }
//        } catch (SQLException ex){} ;
//       
//    }
//    
//
//
//
//
//@Override
//    public void trier() {
//  
//       
//   afficher().stream().sorted((a,b) -> a.getName().compareTo(b.getName())).forEach(System.out::println);;
//    }
//

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
public List<Event> tristreamnom() {
   
   return afficher().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

    }   
    
    
public List<Event> tristreamdescription() {
   
   return afficher().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
 public List<Event> tristreamlieu() {
   
  return afficher().stream().sorted((p1,p2)->p1.getLieu().compareTo(p2.getLieu())).collect(Collectors.toList());

    }
 public List<Event> tristreamdate() {
   
  return afficher().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }


    
    
    
    
    
    
    
    
    
    
    
@Override
    public List<Event> rechstream(Event x) {
     
     
     return afficher().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }

    
    
    
    
    
    
    
    
    
    


@Override
    public void arch(Event t) {
         try {
            String req = "update event set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("event modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<String> afficherlist() {
        String s1="";
         List<String> s2 = new ArrayList();
     List<Event> events = new ArrayList();
        try {
     
        String querry ="SELECT * FROM `event` where archiver = 0";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Event p = new Event();
            
             p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
               
                 p.setLieu(rs.getString("lieu"));
                  p.setDate(rs.getString("date"));
                  p.setPicture(rs.getString("picture"));
                   p.setCategorie(rs.getInt("categorie_id"));
                 
            events.add(p);
            s1="Name= "+p.getName()+"description= "+p.getDescription();
            
            s2.add(s1);
            
            
        }
        
        
        
        return s2;
    } catch (SQLException ex) {
        }
    return s2;
    }
}
