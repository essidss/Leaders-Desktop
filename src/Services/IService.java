/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author Mohamed
 * @param <Event>
 */
public interface IService <Event> {
    
    public void  ajouter(Event t);
    public List<Event> afficher();
    public void  modifier (Event t );
    public void supprimer(int z);
    public List<Event> tristreamdescription() ;
    public List<Event> rechstream(Event x);
   

//    public void rechercher(int x);
//     public void trier() ;
    public void arch(Event t ) ;
    /*
    ....
TO DO  
tri 
recherche 
.... 
    */

}
