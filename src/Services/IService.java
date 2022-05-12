/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Model.Annonce;

import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Mohamed
 */
public interface IService <T> {

    public abstract void add(T t) throws SQLException;

    //T read(String d) throws SQLException;

    boolean update(T t) throws SQLException;

    public void delete(Annonce annonce);

    public List<Annonce> read();
    /*
    ....
TO DO  
tri 
recherche 
.... 
    */

}
