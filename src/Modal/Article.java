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
public class Article {
    
int id,user_id;
private String title,content;
Date date;
int liked;
int idcat;
String image;
 int totalReactions;
 int nbComments;
 int nbShares;

   


    public Article(int id, String title, String content, Date date, int liked, int idcat) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.liked = liked;
        this.idcat = idcat;
    }

    public Article(String title, String content, Date date, int liked, int idcat) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.liked = liked;
        this.idcat = idcat;
    }

    public Article(String title, String content, Date date, String image) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.image = image;
    }

    public Article(int id, String title, String content, Date date, int liked, int idcat, String image, int totalReactions, int nbComments, int nbShares,int user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.liked = liked;
        this.idcat = idcat;
        this.image = image;
        this.totalReactions = totalReactions;
        this.nbComments = nbComments;
        this.nbShares = nbShares;
        this.user_id = user_id;

    }

    


    public Article(String title, String content, String image) {
        this.title = title;
        this.content = content;
        this.image = image;
    }


    public Article(int id) {
        this.id = id;
    }

   
  



    public Article() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public int getIdcat() {
        return idcat;
    }

    public void setIdcat(int idcat) {
        this.idcat = idcat;
    }

  public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotalReactions() {
        return totalReactions;
    }

    public void setTotalReactions(int totalReactions) {
        this.totalReactions = totalReactions;
    }

    public int getNbComments() {
        return nbComments;
    }

    public void setNbComments(int nbComments) {
        this.nbComments = nbComments;
    }

    public int getNbShares() {
        return nbShares;
    }

    public void setNbShares(int nbShares) {
        this.nbShares = nbShares;
    }



@Override
    public String toString() {
        return "Articles{" + "id=" + id + ", title=" + title + ", content=" + content +  ", date=" + date +  ", category=" + idcat +    "\n";
    }

}
