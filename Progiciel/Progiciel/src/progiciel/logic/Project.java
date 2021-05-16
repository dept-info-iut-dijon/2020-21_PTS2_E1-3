/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

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
    public void Start(){

    }
    
    /**
     * Permet d'annuler un projet 
     */
    public void Cancel(){
        
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
        return estimatedDurationHours;
    }

    public float getEstimatedDurationDays() {
        return estimatedDurationDays;
    }
}
