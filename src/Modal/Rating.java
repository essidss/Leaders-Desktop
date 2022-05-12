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
int post_id;
int user_id;

    public Rating(int nb_etoiles, int post_id, int user_id) {
        this.nb_etoiles = nb_etoiles;
        this.post_id = post_id;
        this.user_id = user_id;
    }

    public Rating(int id, int nb_etoiles, int post_id, int user_id) {
        this.id = id;
        this.nb_etoiles = nb_etoiles;
        this.post_id = post_id;
        this.user_id = user_id;
    }

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

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



}
