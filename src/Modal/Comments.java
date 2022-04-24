/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author hp
 */
public class Comments {
    
int id;
private String content;

    public Comments() {
    }


    public Comments(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comments( String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
@Override
    public String toString() {
        return "Comment{" + "id=" + id + " content=" + content + "\n";
    }

}

