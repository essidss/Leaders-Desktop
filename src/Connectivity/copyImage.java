/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;

import javafx.scene.text.Text;

/**
 *
 * @author abdallah
 */
public class copyImage {

    public static void deplacerVers(Text txtField, String path, String copyTo) {
        if (!(txtField.getText().equals("")) ){
            try {
                String[] args = { "CMD", "/C", "COPY", "/Y", path, copyTo };
                Process p = Runtime.getRuntime().exec(args);
                p.waitFor();
                System.out.println("done");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
