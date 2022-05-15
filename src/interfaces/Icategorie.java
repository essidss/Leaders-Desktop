/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import Modal.Categorie;
import java.util.Map;

/**
 *
 * @author HP
 */
public interface Icategorie {
    
    public boolean ajouterCategorie(Categorie c);

    //lister
    public List<Categorie> afficherCategorie();

    //update
    public boolean modifierCategorie(Categorie c);
    //delete

    public boolean supprimerCategorie(Categorie c);
    public void arch(Categorie c ) ;
public List<Categorie> tristreamdescription() ;
    //public List<Categorie> rechstream(Categorie x);
   
   // public Map<Integer, List<String>> bestpost(int resp);
//      public ArrayList<Comment> sortBynblike();

    
}
