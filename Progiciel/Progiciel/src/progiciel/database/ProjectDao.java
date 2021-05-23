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
import progiciel.hmi.ProjectsWindowPackage.UpdateConfirmation;
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
            System.err.println("ProjectDao: Erreur de chargement de données");
            Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myRs;
    } 
    
    /**
     * Permet d'update un projet p
     * @param p 
     */
    public void update(Project p){
        ProjectDao projectLoader = new ProjectDao();
        ResultSet loader = projectLoader.listAll();

   
        try {
                String name = null;
                int estTime = 0;
                int finale = 0;
                String statut = null;
                
                //Connection to the DB
                Connection myConn;
                myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
                Statement ident = myConn.createStatement();
                Statement check = myConn.createStatement();
                
                ResultSet checker = check.executeQuery("SELECT * FROM projet WHERE ID="+p.getID());
                
                while(checker.next()){
                    name = checker.getString("nom");
                    estTime = checker.getInt("dureeEstimee");
                    finale = checker.getInt("dureeFinale");
                    statut = checker.getString("statut");
                }
                
                //Mise à jour du nom 
                if(p.getName() != null && !p.getName().equals(name)){
                    ident.executeUpdate("UPDATE projet SET nom ="+"'"+p.getName()+"'"+" WHERE ID="+p.getID());
                }
                //Mise à jour de dureeEstimee
                if(p.getEstimatedDurationMinutes() > -1 && p.getEstimatedDurationMinutes() != estTime){
                    ident.executeUpdate("UPDATE projet SET dureeEstimee ="+p.getEstimatedDurationMinutes()+" WHERE ID="+p.getID());
                }
                //Mise à jour de dureeFianle
                if(p.getFinalDuration() > -1 && p.getFinalDuration() != finale){
                    ident.executeUpdate("UPDATE projet SET dureeFinale ="+p.getFinalDuration()+" WHERE ID="+p.getID());
                }
                //Mise à jour du status 
                if(p.getStatus() != null && !p.getStatus().equals(statut)){
                    ident.executeUpdate("UPDATE projet SET statut ="+"'"+p.getStatus()+"'"+" WHERE ID="+p.getID());
                }
                
                UpdateConfirmation allGood = new UpdateConfirmation();
                allGood.setVisible(true);
            } 
        catch (SQLException ex) {
                Logger.getLogger(ProfileWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Permet de créer un nouveau projet 
     * @param p 
     */
    public void createProject(Project p){
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement create = myConn.createStatement();
            
            create.executeUpdate("INSERT INTO Projet VALUES"
                    + "("+p.getID()+","+1+",'"+p.getName()+"',"+p.getEstimatedDurationMinutes()+","+p.getFinalDuration()+",'"+p.getStatus()+"')");
            
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
