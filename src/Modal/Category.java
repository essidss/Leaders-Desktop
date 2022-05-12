/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author hp
 */
public class Category {
    int idcat;
String nom;
int user_id;
boolean archived;
    public Category(int idcat, String nom, int user_id) {
        this.idcat = idcat;
        this.nom = nom;
        this.user_id = user_id;
    }

    public Category(int idcat, String nom) {
        this.idcat = idcat;
        this.nom = nom;
    }

    public Category(String nom) {
        this.nom = nom;
    }
 public Category( ) {
         
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    

@Override
    public String toString() {
        return "category{" + "id=" + idcat + " nom=" + nom + "\n";
    }
  
   
}
