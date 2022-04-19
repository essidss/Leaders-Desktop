/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import java.util.List;

/**
 *
 * @author hp
 */
public interface IServiceCategory  <T>{
 public void  ajouter(T t);
    public List<T> afficher();
    public void supprimer (T t);
    
}
