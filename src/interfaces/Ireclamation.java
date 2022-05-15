/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Modal.Reclamation;


public interface Ireclamation {
     //ajouter
    public boolean ajouterReclamation(Reclamation p);
     //lister
    public List<Reclamation> afficherReclamation();
    //public List<Reclamation>show();
    //update
    
      public boolean modifierReclamation(Reclamation p);
      //delete
          public boolean supprimerReclamation(Reclamation p);
           public void arch(Reclamation c ) ;
             public List<Reclamation> tristreamdescription() ;
    public List<Reclamation> rechstream(Reclamation x);
      
//
//    public ArrayList<Post> AfficherTrie();
 //public ArrayList<Reclamation> findBytitle(String title);

//    public ArrayList<Post> sortByDate();
          
          
          
          
          
}
