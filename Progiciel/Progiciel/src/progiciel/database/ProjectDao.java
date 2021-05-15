/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import progiciel.hmi.ProfileWindow.ProfileWindow;
import progiciel.logic.Project;

/**
 * Classe gérant les données des projets 
 * @author margu
 */
public class ProjectDao {
   
    /**
     * Renvoie toutes les informations des projets 
     * @return 
     */
    public ResultSet listAll(){
        ResultSet myRs = null;
        try {
           //Connection to the DB
           Connection myConn;
           myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
           Statement ident = myConn.createStatement();
           myRs = ident.executeQuery("SELECT * FROM PROJET ORDER BY ID DESC");
           
            } catch (SQLException ex) {
            Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myRs;
    } 
    
    /**
     * Permet d'update un projet p
     * @param p 
     */
    public void update(Project p){
        
    }
}
