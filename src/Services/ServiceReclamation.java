/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Model.Reclamation;
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
public class ServiceReclamation implements IService<Reclamation>{
private final Connection cnx = MyDb.getInstance().getCnx() ;
   
    @Override
    public void ajouter( Reclamation t) {
    try {
        String querry= "INSERT INTO Reclamation(`sujet`,`description`, `date`) VALUES ('"+t.getSujet()+"','"+t.getDescription()+"','"+t.getDate()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Reclamation> afficher() {
     List<Reclamation> personnes = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `Reclamation` where archiver is NULL";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Reclamation p = new Reclamation();
            
             p.setId(rs.getInt(1));
            
                p.setDescription(rs.getString("description"));
                p.setDate(rs.getString("date"));
                 p.setSujet(rs.getString("sujet"));
                  
                 
            personnes.add(p);
            
            
          
            
            
            
            
            
            
            
            
        }
        
        
        
        return personnes;
    } catch (SQLException ex) {
        }
    return personnes;
    }

    
    
    @Override
   public void modifier(Reclamation t) {
        try {
            String requete =  "UPDATE `reclamation` SET `description`=?,`date`=?,`sujet`=? WHERE id =?";
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getDescription());
             pst.setString(2, t.getDate());
              pst.setString(3, t.getSujet());
               pst.setInt(4, t.getId());
            pst.executeUpdate();
            System.out.println("Reclamation a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }
    
   
   @Override
    public void supprimer(int z) {
        try
       {
           //DELETE FROM  WHERE 0
           String requete="DELETE FROM `reclamation` WHERE id ="+z ;
          PreparedStatement pste=MyDb.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("la reclamation a été supprimé");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
         }
    
    
    
    
    
//    
//    @Override
//    public void rechercher(int x) {
//        List<Reclamation> reclamations = new ArrayList();
//      boolean test ;
//         try {
//       
//        String query ="SELECT * FROM reclamation";
//        Statement stm = cnx.createStatement();
//            ResultSet rs= stm.executeQuery(query);
//        while (rs.next()){
//            Reclamation c = new Reclamation();
//            
//             c.setId(rs.getInt(1));
//           
//            c.setDescription(rs.getString("description"));
//            c.setDate(rs.getString("date"));
//            c.setSujet(rs.getString("sujet"));
//            
//            reclamations.add(c);
//        }
//       
//   test =reclamations.stream().anyMatch((p -> p.getId()==x ));
//   if (test ==true ){
//     for (int i = 0; i < reclamations.size(); i++) {
//           if (reclamations.get(i).getId()== x) {
//                 System.out.println( reclamations.get(i));
//           
//           } }
//   
//   }
//   else
//   {
//       System.out.println( "aucune reclamation");
//   }
//        } catch (SQLException ex){} ;
//       
//    }
//    
//
// 
//    
//    
//    @Override
//    public void trier() {
//        List<Reclamation> reclamations = new ArrayList();
//         try {
//       
//        String query ="SELECT * FROM reclamation";
//        Statement stm = cnx.createStatement();
//            ResultSet rs= stm.executeQuery(query);
//        while (rs.next()){
//            Reclamation c = new Reclamation();
//            c.setId(rs.getInt(1));
//           
//            c.setDescription(rs.getString("description"));
//            c.setDate(rs.getString("date"));
//            c.setSujet(rs.getString("sujet"));
//            
//            reclamations.add(c);
//           
//           
//        }
//       
//   reclamations.stream().sorted((a,b) -> a.getDescription().compareTo(b.getDescription())).forEach(System.out::println);;
//    } catch (SQLException ex) {} 
//    }
//
//
//
//
//
//
//

















































public List<Reclamation> tristreamdescription() {
   
   return afficher().stream().sorted((p1,p2)->p1.getDescription().compareTo(p2.getDescription())).collect(Collectors.toList());

    }
 public List<Reclamation> tristreamsujet() {
   
  return afficher().stream().sorted((p1,p2)->p1.getSujet().compareTo(p2.getSujet())).collect(Collectors.toList());

    }
 public List<Reclamation> tristreamdate() {
   
  return afficher().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }










@Override
    public List<Reclamation> rechstream(Reclamation x) {
     
     
     return afficher().stream().filter(p->p.getDescription().contains(x.getDescription())).collect(Collectors.toList());
  

      
    }



 








    
    
    
    
     @Override
    public void arch(Reclamation t) {
         try {
            String req = "update reclamation set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("reclamation modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
    
    
    
    
}
