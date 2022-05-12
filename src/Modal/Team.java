/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author leith
 */
public class Team {
    private int id;
    private String TeamName;
    private String Description;
    private String isActive;

    public Team(int id, String TeamName, String Description) {
        this.id = id;
        this.TeamName = TeamName;
        this.Description = Description;
    }

    public Team(String TeamName, String Description,String isactive) {
        this.TeamName = TeamName;
        this.Description = Description;
        this.isActive= isactive;
    }

    public Team() {
    }

    public String getIsactive() {
        return isActive;
    }

    public void setIsactive(String isactive) {
        this.isActive = isactive;
    }

    
    public int getId() {
        return id;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", TeamName=" + TeamName + ", Description=" + Description + '}';
    }
    
    
}
