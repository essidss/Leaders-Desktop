package Model;

/**
 *
 * @author abdallah
 */
public class Annonce_Categorie {

    private int id = 0;
    private String nom = "";

    public Annonce_Categorie() {
    }

    public Annonce_Categorie(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Annonce_Categorie( String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", nom=" + nom + '}';
    }

}