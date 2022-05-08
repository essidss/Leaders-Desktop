/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author hp
 */
public class Rating {
    int id;
int nb_etoiles;

    public Rating(int id, int nb_etoiles) {
        this.id = id;
        this.nb_etoiles = nb_etoiles;
    }

    public Rating(int nb_etoiles) {
        this.nb_etoiles = nb_etoiles;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_etoiles() {
        return nb_etoiles;
    }

    public void setNb_etoiles(int nb_etoiles) {
        this.nb_etoiles = nb_etoiles;
    }


}
