/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author HP
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HP
 */
public class Categorie {
    private int id;
    private String name,description,archiver;

    public void setArchiver(String archiver) {
        this.archiver = archiver;
    }

    public Categorie(int id) {
        this.id = id;
    }

    public String getArchiver() {
        return archiver;
    }

    public Categorie() {
    }

    public Categorie(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Categorie(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
     @Override
    public String toString() {
       return "Categorie{" + "id=" + id + ", name=" + name + ", description=" + description + "}\n";
       
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
