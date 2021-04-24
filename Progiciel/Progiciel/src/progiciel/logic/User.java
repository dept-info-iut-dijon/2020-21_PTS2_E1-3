/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

/**
 * Class representing an user
 * @author Bastien Kotte
 */
public class User {
    private int ID;
    private String login;
    private String passwordHash;
    private String lastName;
    private String firstName;
    private boolean isConnected = false;
    private boolean isChief = false;
    
    /**
     * constructor of the User class
     * @param id 
     */
    public User(int id){
        
    }
    
    /**
     * fonctiun allowing to copy the details of another user
     * @param u the user from whom to copy the details
     */
    public void Copy(User u){
        this.ID = u.getID();
        this.login = u.getLogin();
        this.passwordHash = u.getPasswordHash();
        this.lastName = u.getLastName();
        this.firstName = u.getFirstName();
        this.isConnected = u.isConnected();
        this.isChief = u.isChief();
    }
    
    /**
     * function that disconnects the user
     */
    public void Disconnect(){
        
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public void setIsChief(boolean isChief) {
        this.isChief = isChief;
    }

    public int getID() {
        return ID;
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isChief() {
        return isChief;
    }
}