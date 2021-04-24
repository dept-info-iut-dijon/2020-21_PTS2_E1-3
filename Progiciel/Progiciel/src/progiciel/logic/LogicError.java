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
public class LogicError extends Exception {

    /**
     * Creates a new instance of <code>LogicError</code> without detail message.
     */
    public LogicError() {
    }

    /**
     * Constructs an instance of <code>LogicError</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public LogicError(String msg) {
        super(msg);
    }
}