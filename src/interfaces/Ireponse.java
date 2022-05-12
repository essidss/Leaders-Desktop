/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Model.Reclamation;
import Model.Reponse;





public interface Ireponse {
    //ajouter
public boolean ajouterReponse(Reponse p);
    //lister
    public List<Reponse> afficherReponse();

    //update
    public boolean modifierReponse(Reponse c);
    //delete

    public boolean supprimerReponse(Reponse c);
       public void arch(Reponse c ) ;
             public List<Reponse> tristreamdescription() ;
    public List<Reponse> rechstream(Reponse x);
      

//    public Map<Integer, List<String>> bestpost(int resp);
//      public ArrayList<Comment> sortBynblike();
//
//    public int Commentsum();
}
