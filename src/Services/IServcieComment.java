/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import Modal.Posts;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IServcieComment <T> {
      public void  ajouter(T t);
    public List<T> afficher(Posts a);
    public void  modifier (T t);
    public void supprimer (T t);
}
