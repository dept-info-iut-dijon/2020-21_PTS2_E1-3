/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe qui permet de gérer les techniciens 
 * @author margu
 */
public class Tech extends User{
    
    public Tech(int id) {
        super(id);
    }
    
    /**
     * Retourne les compétences d'un tech 
     * @return 
     */
    public ArrayList<Skill> getSkill(){
        ArrayList<Skill> rep = new ArrayList<>();
        
        try {
            //Connection to the DB
            Connection myConn;
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement retrieveSkills = myConn.createStatement();
            ResultSet myRs = retrieveSkills.executeQuery("SELECT competence.nom, possede.niveau FROM Possede "
                    + "INNER JOIN Competence ON possede.competenceID = competence.id "
                    + "WHERE possede.technicienID="+this.getID());
            
            while(myRs.next()){
                String name = myRs.getString("nom");
                String level = myRs.getString("niveau");
                Skill skill = new Skill(name, level);
                rep.add(skill);
            }

            } catch (SQLException ex) {
                Logger.getLogger(Tech.class.getName()).log(Level.SEVERE, null, ex);
            } 
        return rep;
    }
}
