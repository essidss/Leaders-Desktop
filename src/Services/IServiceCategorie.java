/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Annonce_Categorie;
import java.util.List;

/**
 *
 * @author abdallah
 */
public interface IServiceCategorie {

    public void add(Annonce_Categorie cat);

    public void delete(Annonce_Categorie categorie);

    public boolean update(Annonce_Categorie c);

    public List<Annonce_Categorie> getall();
}
