/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progiciel.logic;

/**
 *
 * @author jm457011
 */
public class BadProjectStatus extends LogicError {
    
    /**
     * Creates a new instance of BadProjectStatus without detail message.
     */
    public BadProjectStatus(){
        
    }
    
    /**
     * Creates a new instance of BadProjectStatus with a detailed message.
     * @param msg 
     */
    public BadProjectStatus(String msg){
        super(msg);
    }
    
}
