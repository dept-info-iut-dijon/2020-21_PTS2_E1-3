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
import progiciel.hmi.LoginWindowPackage.LoginWindow;
import progiciel.hmi.MainWindowPackage.ErrorLogin;
import progiciel.hmi.MainWindowPackage.MainWindow;
import progiciel.logic.Tech;
import progiciel.logic.User;
import progiciel.Exceptions.ExceptionHMI;

/**
 * Gère l'accès des utilisateurs aux données 
 * @author margu
 */
public class UserDao {
    public User read(String login, String passHash) throws Exception {
        User rep = null;
        
        //Variables des résultats de la requête
        String resLogin = null;
        String resPass = null;
        int resId = 0;
        
        try {
            //Connection to the DB
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            Statement ident = myConn.createStatement();
            ResultSet myRs = ident.executeQuery("SELECT * FROM utilisateur WHERE login="+"'"+login+"'");

            //Attributions des résultats de la requête 
            while(myRs.next()){
                resLogin = (myRs.getString("LOGIN"));
                resPass = (myRs.getString("PASSWORD")); 
                resId = Integer.parseInt(myRs.getString("ID"));    
            }
            //Test du mdp 
            if(resLogin != null){
                if(resPass.equals(passHash)){
                    User connectedUser = new User(resId);
                    rep = connectedUser;
                    MainWindow mainwindow = new MainWindow(connectedUser);
                    mainwindow.setVisible(true);
                }
                //Lance une exception et un pop up si le mdp est mauvais 
                else{
                    ErrorLogin error = new ErrorLogin();
                    error.setVisible(true);
                    throw new ExceptionHMI("UserDao","Wrong Login or Password") {};
                }
            }
            //Lance une exception et un pop up si le login est vide 
            else{
                ErrorLogin error = new ErrorLogin();
                error.setVisible(true);    
                throw new ExceptionHMI("UserDao","Wrong Login or Password") {};
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
