/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
public class Commercial extends Address{

    public Commercial(String sN, int bN, String z, String t) { //street name, building number, zip, and type
        super(sN, bN, z, t);
    }
    
    //constructor without unit
    public Commercial(String sN, String z, String t){
        super(sN,z,t);
    }
    
    @Override
    public String getType() {
       return "commercial"; 
    }
}
