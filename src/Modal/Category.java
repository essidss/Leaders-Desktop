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
    

@Override
    public String toString() {
        return "category{" + "id=" + idcat + " nom=" + nom + "\n";
    }
  
   
}
