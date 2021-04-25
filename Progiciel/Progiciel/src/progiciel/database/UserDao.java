/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.database;

import progiciel.logic.Tech;
import progiciel.logic.User;

/**
 * Gère l'accès des utilisateurs aux données 
 * @author margu
 */
public class UserDao {
    public User read(String login, String passHash){
        User rep = null;
        return rep;
    }
    
    public void update(User user){
        
    }
    
    /**
     * Retourne la liste des techniciens 
     * @return 
     */
    public Tech[] listTech(){
        Tech[] rep = null;
        return rep;
    }
}
