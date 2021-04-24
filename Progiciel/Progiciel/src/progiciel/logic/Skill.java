/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

/**
 *
 * @author bkott
 */
public class Skill {
    private String name;
    private String level;

    public Skill(String name, String level) {
        this.name = name;
        this.level = level;
    }
    
    public Skill(){
        
    }
    
    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}