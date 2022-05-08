/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.util.List;

/**
 *
 * @author leith
 */
public interface Service <T> {
    
    public boolean  ajouter(T t);
    public List<T> afficher();
    public void  modifier (String t,T a);
    public void supprimer (T t);
    //public void TruncateTable();
}
