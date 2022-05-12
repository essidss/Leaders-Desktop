/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import Model.Reponse;
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
 * @author HP
 */
public class ServiceReponse implements IService<Reponse>{
private final Connection cnx = MyDb.getInstance().getCnx() ;
   
    @Override
    public void ajouter( Reponse t) {
    try {
        String querry= "INSERT INTO Reponse(`reponse`, `date`,`reclamation_id`) VALUES ('"+t.getReponse()+"','"+t.getDate()+"','"+t.getReclamation()+"')";
        Statement stm = cnx.createStatement();
    
    stm.executeUpdate(querry);
    
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    
    }
        
        
    }

    @Override
    public List<Reponse> afficher() {
     List<Reponse> personnes = new ArrayList();
        try {
       
        String querry ="SELECT * FROM `Reponse` where archiver is NULL";
        Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Reponse p = new Reponse();
            
             p.setId(rs.getInt(1));
            
                p.setReponse(rs.getString("reponse"));
                p.setDate(rs.getString("date"));
                 p.setReclamation(rs.getInt("reclamation_id"));
                  
                 
            personnes.add(p);
            
            
          
            
            
            
            
            
            
            
            
        }
        
        
        
        return personnes;
    } catch (SQLException ex) {
        }
    return personnes;
    }

    
    
    
    
    
    
    @Override
   public void modifier(Reponse t) {
        try {
            String requete =  "UPDATE `reponse` SET `reponse`=?,`date`=? WHERE id =?";
           
            PreparedStatement pst= MyDb.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, t.getReponse());
             pst.setString(2, t.getDate());
              pst.setInt(3, t.getId());
            
            pst.executeUpdate();
            System.out.println("Reponse a été MODIFIE!");                        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
       }
    
  @Override
    public void supprimer(int z) {
        try
       {
           //DELETE FROM  WHERE 0
           String requete="DELETE FROM `reponse` WHERE id ="+z ;
          PreparedStatement pste=MyDb.getInstance().getCnx().prepareStatement(requete);
           if (pste.execute())
          { System.out.println("la reponse a été supprimée");}
           
       }catch(SQLException ex)
       {
          System.out.println(ex.getMessage());
       }
         }
      
   
    
    
    
    
    
    
    
    
    
    
//     @Override
//    public void rechercher(int x) {
//        List<Reponse> reponses = new ArrayList();
//      boolean test ;
//         try {
//       
//        String query ="SELECT * FROM reponse";
//        Statement stm = cnx.createStatement();
//            ResultSet rs= stm.executeQuery(query);
//        while (rs.next()){
//            Reponse c = new Reponse();
//            
//             c.setId(rs.getInt(1));
//            c.setReponse(rs.getString("reponse"));
//            c.setDate(rs.getString("date"));
//            
//            reponses.add(c);
//        }
//       
//   test =reponses.stream().anyMatch((p -> p.getId()==x ));
//   if (test ==true ){
//     for (int i = 0; i < reponses.size(); i++) {
//           if (reponses.get(i).getId()== x) {
//                 System.out.println( reponses.get(i));
//           
//           } }
//   
//   }
//   else
//   {
//       System.out.println( "aucune categorie");
//   }
//        } catch (SQLException ex){} ;
//       
//    }
//    
//
//    
//    
//    @Override
//    public void trier() {
//        List<Reponse> reponses = new ArrayList();
//         try {
//       
//        String query ="SELECT * FROM reponse";
//        Statement stm = cnx.createStatement();
//            ResultSet rs= stm.executeQuery(query);
//        while (rs.next()){
//            Reponse c = new Reponse();
//             c.setId(rs.getInt(1));
//            c.setReponse(rs.getString("reponse"));
//            c.setDate(rs.getString("date"));
//            
//            reponses.add(c);
//            
//           
//           
//        }
//       
//   reponses.stream().sorted((a,b) -> a.getReponse().compareTo(b.getReponse())).forEach(System.out::println);;
//    } catch (SQLException ex) {} 
//    }
//

    
    
    
    
    
    
    
public List<Reponse> tristreamdescription() {
   
   return afficher().stream().sorted((p1,p2)->p1.getReponse().compareTo(p2.getReponse())).collect(Collectors.toList());

    }
  public List<Reponse> tristreamdate() {
   
  return afficher().stream().sorted((p1,p2)->p1.getDate().compareTo(p2.getDate())).collect(Collectors.toList());

    }
    
    
    
    
    
@Override
    public List<Reponse> rechstream(Reponse x) {
     
      return afficher().stream().filter(p->p.getReponse().contains(x.getReponse())).collect(Collectors.toList());
  

       
    }


    
    
    
    
    
    
    
   @Override
    public void arch(Reponse t) {
         try {
            String req = "update Reponse set archiver= ? where id= ?";
            PreparedStatement ps = cnx.prepareStatement(req);
             ps.setString(1,"1");
            ps.setInt(2, t.getId());
            ps.executeUpdate();
            System.out.println("reponse modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       }
    
}
