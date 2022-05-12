/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Model.Event;
import Model.Categorie;

/**
 *
 * @author HP
 */
public interface Ievent {
     public boolean ajouterEvent(Event c);

    //lister
    public List<Event> afficherEvent();

    //update
    public boolean modifierEvent(Event c);
    //delete

    public boolean supprimerEvent(Event c);
 public void arch(Event c ) ;
  public List<Event> tristreamdescription() ;
    public List<Event> rechstream(Event x);
//    public Map<Integer, List<String>> bestpost(int resp);
////      public ArrayList<Comment> sortBynblike();

    
}




