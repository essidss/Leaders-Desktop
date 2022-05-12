/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Categorie;
import Model.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;






/**
 *
 * @author HP
 */
public class ServiceCategorie implements IService<Categorie>{
private  Connection cnx = MyDb.getInstance().getCnx() ;
   
    @Override
    public void ajouter(Categorie t) {
    try {
        String querry= "INSERT INTO categorie(`name`, `description`) VALUES ('"+t.getName()+"','"+t.getDescription()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Categorie> afficher() {
     List<Categorie> categories = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `categorie` where archiver = 0";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Categorie p = new Categorie();
            
             p.setId(rs.getInt(1));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
               
            categories.add(p);
            
            
          
            
            
            
            
            
            
            
            
        }
        
        
        
        return categories;
    } catch (SQLException ex) {
        }
    return categories;
    }
















@Override
   public void modifier(Categorie t) {
        try {
            String requete =  "UPDATE `categorie` SET `name`=?,`description`=? WHERE id =?";
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getName());
            pst.setString(2, t.getDescription());
             pst.setInt(3, t.getId());
            pst.executeUpdate();
            System.out.println("Categorie a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }



@Override
    public void supprimer(int z) {
        try
       {
           //DELETE FROM  WHERE 0
           String requete="DELETE FROM `categorie` WHERE id ="+z ;
          PreparedStatement pste=MyDb.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("categorie a été supprimé");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
         }
    




    
    
    
//    
//     @Override
//    public void rechercher(int x) {
//         boolean test ;
//      //   try {
//       
////        String query ="SELECT * FROM categorie";
////        Statement stm = cnx.createStatement();
////            ResultSet rs= stm.executeQuery(query);
////        while (rs.next()){
////            Categorie c = new Categorie();
////            
////             c.setId(rs.getInt(1));
////            c.setName(rs.getString("name"));
////            c.setDescription(rs.getString("description"));
////            
////            categories.add(c);
////        }
////       
//
//    afficher().stream().filter(p -> x == p.getId()).collect(Collectors.toList());
//   test =afficher().stream().anyMatch((p -> p.getId()==x ));
////   if (test ==true ){
////     for (int i = 0; i < categories.size(); i++) {
////           if (categories.get(i).getId()== x) {
////                 System.out.println( categories.get(i));
////           
////           } }
////   
////   }
////   else
////   {
////       System.out.println( "aucune categorie");
////   }
////        } catch (SQLException ex){} ;
////       
//    }
//    
//
//
////
////    
////    @Override
////    public void trier() {
////        List<Categorie> categories = new ArrayList();
////         try {
////       
////        String query ="SELECT * FROM categorie";
////        Statement stm = cnx.createStatement();
////            ResultSet rs= stm.executeQuery(query);
////        while (rs.next()){
////            Categorie c = new Categorie();
////             c.setId(rs.getInt(1));
////            c.setName(rs.getString("name"));
////            c.setDescription(rs.getString("description"));
////            
////            categories.add(c);
////            
////           
////        }
////       
////   categories.stream().sorted((a,b) -> a.getName().compareTo(b.getName())).forEach(System.out::println);;
////    } catch (SQLException ex) {} 
////    }
////
////    
//    
//    
//    
    
    
    
       
public List<Categorie> tristreamnom() {
   
   return afficher().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).collect(Collectors.toList());

    }
  public List<Categorie> tristreamdescription() {
   
  return afficher().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
    
  

@Override
    public List<Categorie> rechstream(Categorie x) {
     
     
     return afficher().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }



    
    
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    
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

}









    




    

    

