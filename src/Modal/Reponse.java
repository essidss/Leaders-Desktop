/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP
 */
public class Reponse {
    public static Object stream() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      private int id,Reclamation;
    private String reponse,date,archiver;
     private Reclamation id_reclamation;

    public void setId_reclamation(Reclamation id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public Reponse(int id, int Reclamation, String reponse, String date) {
        this.id = id;
        this.Reclamation = Reclamation;
        this.reponse = reponse;
        this.date = date;
    }

    public Reponse(int id, int Reclamation, String reponse) {
        this.id = id;
        this.Reclamation = Reclamation;
        this.reponse = reponse;
    }

    public Reclamation getId_reclamation() {
        return id_reclamation;
    }

    public void setArchiver(String archiver) {
        this.archiver = archiver;
    }

    public Reponse(String reponse, String date, Reclamation id_reclamation) {
        this.reponse = reponse;
        this.date = date;
        this.id_reclamation = id_reclamation;
    }

    public Reponse(int id, String reponse, String date, Reclamation id_reclamation) {
        this.id = id;
        this.reponse = reponse;
        this.date = date;
        this.id_reclamation = id_reclamation;
    }

    public String getArchiver() {
        return archiver;
    }

    public Reponse() {
    }

    public Reponse(String reponse, String date) {
        this.reponse = reponse;
        this.date = date;
    }

    public Reponse(int id, String reponse, String date) {
        this.id = id;
        this.reponse = reponse;
        this.date = date;
    }

    public Reponse(String reponse, String date, int Reclamation) {
        this.reponse = reponse;
        this.date = date;
        this.Reclamation = Reclamation;
    }

      
 @Override
    public String toString() {
       return "Reponse{" + "id=" + id + ", reponse=" + reponse +",date=" + date   + ", Reclamation=" + Reclamation + "}\n";
    }

    public int getId() {
        return id;
    }

    public String getReponse() {
        return reponse;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReclamation() {
        return Reclamation;
    }

    public void setReclamation(int Reclamation) {
        this.Reclamation = Reclamation;
    }
               
        
    
    
}
