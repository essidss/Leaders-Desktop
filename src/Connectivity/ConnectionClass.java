/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class ConnectionClass {
   static private  Connection connection;
final  String URL ="jdbc:mysql://localhost/mahdi";
   final  String LOGIN ="root";
   final  String PASSWORD ="";
   static  private ConnectionClass instance ;
    public ConnectionClass() {
 
       try {
           connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
           System.out.println("Connexion reussie ......");
       
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());   

    }
   



}
  static public ConnectionClass getInstance(){
       if(instance==null)
       instance= new ConnectionClass();
       
       return instance;//null
   }
  
  static public Connection getCnx (){
      return connection;
  }
}

