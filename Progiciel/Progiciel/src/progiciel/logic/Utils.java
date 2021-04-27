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
public class Utils {
    
    /**
     * returns the hashed password
     * @param pass
     * @return 
     */
    public static String HashPassword(String pass){
        String res="";
        
        for(int i=0; i<pass.length(); i++){
            
            // We get the char to convert
            char _char = pass.charAt(i);
            
            // Conversion into the ASCII code (int)
            int charToInt = (int)_char;
           
            // Convert the ASCII value into hexa
            String intToHex = Integer.toHexString(charToInt);
            
            // Add the result to the return String
            res+=intToHex;
        }
        
        return res;
    }
    
    /**
     * return true if the password is safe enough
     * 8 character password length
     * 1 Capital letter minimum
     * 1 Digital number minimum
     * @param pass
     * @return 
     */
    public static Boolean IsPasswordSafe(String pass){
        Boolean res=false;
        int nbCh=0;
        int nbMaj=0;
        int nbNb=0;
        
        for(int i=0; i<pass.length(); i++){
            char ch = pass.charAt(i);
            nbCh++;
            
            // Is the Character a capital letter
            if(Character.isUpperCase(ch)){
                nbMaj++;
            }
            
            // Is the characted a digital number
            if(Character.isDigit(ch)){
                nbNb++;
            }
            
            
        }
        
        // Is the password safe ?
        if(nbCh>=8 && nbMaj>=1 && nbNb>=1){
            res=true;
        }
        
        return res;
    }
    
}
