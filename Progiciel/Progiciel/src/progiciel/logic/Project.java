/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import progiciel.hmi.ProfileWindow.ProfileWindow;

/**
 * Classe d'un projet
 * @author margu
 */
public class Project {
    private String name;
    private int finalDuration;
    private String status;
    private int ID;
    private int estimatedDurationMinutes;
    private float estimatedDurationHours;
    private float estimatedDurationDays;
    
    /**
     * Constructor
     * @param name
     * @param finalDuration
     * @param status
     * @param ID
     * @param minutes 
     */
    public Project(String name, int finalDuration, String status, int ID, int minutes){
        this.name = name;
        this.ID = ID;
        this.finalDuration = finalDuration;
        this.status = status;
        this.estimatedDurationMinutes = minutes;
        this.estimatedDurationDays = minutes / 1440;
        this.estimatedDurationHours = minutes / 60;
    }
    
    /**
     * Permet de démarer un projet (Conception adpatée aux besoins du projet)
     */
    public boolean Start(){
        boolean res = false;
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE projet SET statut ="+"'"+ProjectStatus.WORKING+"'"+" WHERE id="+this.ID);
            res = true;
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return res;
    }
    
    /**
     * Permet d'annuler un projet 
     */
    public boolean Cancel(){
        boolean res = false;
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE projet SET statut ="+"'"+ProjectStatus.CANCELED+"'"+" WHERE id="+this.ID);
            res = true;
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return res;
    }
    
    /**
     * Met un projet en attente 
     * @return 
     */
    public boolean Waiting(){
        boolean res = false;
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE projet SET statut ="+"'"+ProjectStatus.WAITING+"'"+" WHERE id="+this.ID);
            res = true;
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return res;
    }
    
    /**
     * Défini le projet comme terminé
     * @return 
     */
    public boolean Ended(){
        boolean res = false;
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE projet SET statut ="+"'"+ProjectStatus.ENDED+"'"+" WHERE id="+this.ID);
            res = true;
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return res;
    }
    
    /**
     * Permet de valider un projet
     * @return 
     */
    public boolean Validated() {
        boolean res = false;
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ident.executeUpdate("UPDATE projet SET statut ="+"'VALIDATED'"+" WHERE id="+this.ID);
            res = true;
            } catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return res;
    }
    
    public String getName() {
        return name;
    }

    public int getFinalDuration() {
        return finalDuration;
    }

    public String getStatus() {
        return status;
    }

    public int getID() {
        return ID;
    }

    public int getEstimatedDurationMinutes() {
        return estimatedDurationMinutes;
    }

    public float getEstimatedDurationHours() {
        return this.estimatedDurationHours;
        
    }

    public float getEstimatedDurationDays() {
        return estimatedDurationDays;
    }

    /**
     * Donne le temps estimé au formet JJ/HH/MM
     * @return 
     */
    public String getEstimatedTimeString(){
        return this.estimatedDurationMinutes/24/60 + " Days " + this.estimatedDurationMinutes/60%24 + " Hours " + this.estimatedDurationMinutes%60+" Minutes";
    }
}
