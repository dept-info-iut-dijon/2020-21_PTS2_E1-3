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
import java.util.logging.Logger;

/**
 * Permet de gérer les message 
 * @author margu
 */
public class MessageDao {
    
    /**
     * Permet de lister tout les messages
     * @return 
     */
    public ResultSet listAll(){
         ResultSet myRs = null;
        try {
           //Connection to the DB
           Connection myConn;
           myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
           Statement ident = myConn.createStatement();
           myRs = ident.executeQuery("SELECT * FROM MESSAGE ORDER BY ID DESC LIMIT 1");
           
            } catch (SQLException ex) {
            System.err.println("ProjectDao: Erreur de chargement de données");
            Logger.getLogger(ex.getMessage());
        }
        return myRs;
    }
}
