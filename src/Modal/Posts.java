/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import java.util.Date;
import java.lang.Boolean;

/**
 *
 * @author hp
 */
public class Posts {

    int id, user_id;
    private String title, content,objet;
    Date created_at;
    int nblikes;
    int idcat;
    String picture;
    String archived;
    int nbviews;

    public Posts(int id, int user_id, String title, String content, String objet, Date created_at, int nblikes, int idcat, String picture, String archived,int nbviews) {
        this.id = id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.objet = objet;
        this.created_at = created_at;
        this.nblikes = nblikes;
        this.idcat = idcat;
        this.picture = picture;
        this.archived = archived;
        this.nbviews=nbviews;
    }

    public Posts(String title, String content, String objet, Date created_at, int nblikes, int idcat, String picture, String archived,int nbviews ) {
        this.title = title;
        this.content = content;
        this.objet = objet;
        this.created_at = created_at;
        this.nblikes = nblikes;
        this.idcat = idcat;
        this.picture = picture;
        this.archived = archived;
        this.nbviews=nbviews;

    }

    public Posts(int id, String title, String content, String objet, Date created_at, int nblikes, int idcat, String picture, String archived,int nbviews ) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.objet = objet;
        this.created_at = created_at;
        this.nblikes = nblikes;
        this.idcat = idcat;
        this.picture = picture;
        this.archived = archived;
        this.nbviews=nbviews;

    }

    public Posts() {
    }

    public Posts(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getNblikes() {
        return nblikes;
    }

    public void setNblikes(int nblikes) {
        this.nblikes = nblikes;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public int getNbviews() {
        return nbviews;
    }

    public void setNbviews(int nbviews) {
        this.nbviews = nbviews;
    }

    
@Override
    public String toString() {
        return "Posts{" + "id=" + id + ", title=" + title + ", content=" + content + ", objet=" + objet + ", picture=" + picture + ", created_at=" + created_at + ", category=" + idcat +  ", user_id=" + user_id +   ", archived=" + archived +   "\n";
    }
     

    



}
