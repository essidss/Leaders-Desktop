/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Categorie;
import java.util.List;

/**
 *
 * @author abdallah
 */
public interface IServiceCategorie {

    public void add(Categorie cat);

    public void delete(Categorie categorie);

    public boolean update(Categorie c);

    public List<Categorie> getall();
}
