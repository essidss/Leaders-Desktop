/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HP
 */
public class Reclamation {
    private int id;

    public Reclamation(String description) {
        this.description = description;
    }
    private String description,date,sujet,archiver;

    public void setArchiver(String archiver) {
        this.archiver = archiver;
    }

    public Reclamation(int id, String sujet) {
        this.id = id;
        this.sujet = sujet;
    }

    public String getArchiver() {
        return archiver;
    }

    public Reclamation() {
    }

    public Reclamation(int id) {
        this.id = id;
    }

    public Reclamation(String description, String date, String sujet) {
        this.description = description;
        this.date = date;
        this.sujet = sujet;
    }

    
    public Reclamation(int id, String description, String date, String sujet) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.sujet = sujet;
    }

    
 @Override
    public String toString() {
       return "Reclamation{" + "id=" + id + ", sujet=" + sujet + ", date=" + date +  ",description=" + description   + "}\n";
    }
               
               
               
     
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getSujet() {
        return sujet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public Reclamation(String description, String sujet) {
        this.description = description;
        this.sujet = sujet;
    }

    public Reclamation(int id, String description, String sujet) {
        this.id = id;
        this.description = description;
        this.sujet = sujet;
    }

    
    
    
}