package Model;



public class Event {
    
    
    
     private int id,Categorie;
    private String Name,description,lieu,date,picture,archiver;


    
    public Event() {
    }

    public Event(int id, int Categorie, String Name, String date, String lieu, String description, String picture) {
        this.id = id;
        this.Categorie = Categorie;
        this.Name = Name;
          this.date = date;
        this.lieu = lieu;
              this.description = description;

        this.picture = picture;
    }

    public Event(int id, String Name, String description, String lieu, String date, String picture) {
        this.id = id;
        this.Name = Name;
        this.description = description;
        this.lieu = lieu;
        this.date = date;
        this.picture = picture;
    }

    public void setArchiver(String archiver) {
        this.archiver = archiver;
    }

    public Event(int id) {
        this.id = id;
    }

    public String getArchiver() {
        return archiver;
    }
    

    public Event(int id, String Name, String description) {
        this.id = id;
        this.Name = Name;
        this.description = description;
    }

    public Event(String Name, String date, String lieu, String description, String picture,int Categorie) {
        this.Name = Name;
         this.date = date;
          this.lieu = lieu;
        this.description = description;
       
       
        this.picture = picture;
        this.Categorie = Categorie;
    }
 public Event(String Name, String date, String lieu, String description, String picture) {
        this.Name = Name;
         this.date = date;
          this.lieu = lieu;
        this.description = description;
       
       
        this.picture = picture;
       
    }

   
    public Event(int id, int Categorie, String Name, String description, String lieu, String date, String picture, String archiver) {
        this.id = id;
        this.Categorie = Categorie;
        this.Name = Name;
        this.description = description;
        this.lieu = lieu;
        this.date = date;
        this.picture = picture;
        this.archiver = archiver;
    }

    
    

    public Event(int event_id, String name) {
         }
     
 @Override
    public String toString() {
 

       return "Event{" + "id=" + id + ", Name=" + Name + ", date=" + date   +  ", lieu=" + lieu + ", description=" + description + ", picture=" + picture + ", Categorie=" + Categorie + "}\n";
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public String getLieu() {
        return lieu;
    }

    public String getDate() {
        return date;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCategorie() {
        return Categorie;
    }

    public void setCategorie(int Categorie) {
        this.Categorie = Categorie;
    }

    
    

}
