/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

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
    public Skill[] getSkill(){
        Skill[] rep = null;
        return rep;
    }
}
