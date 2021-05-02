/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.Exceptions;

/**
 *
 * @author margu
 */
public abstract class ExceptionHMI extends Exception{
    private String message;
    private String nom;
    
    /**
     * Constructeur
     * @param nom nom de l'exception
     * @param message message Ã  afficher
     */
    public ExceptionHMI(String nom,String message) {
        this.message = message;
        this.nom = nom;
    }
    
    /**
     * Renvoie le nom de l'exception
     * @return le nom de l'exception
     */
    public String getNom() {
        return this.nom;
    }
    
    @Override
    public String getMessage() {
        return this.message;
    }
}
