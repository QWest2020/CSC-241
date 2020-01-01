/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
public class House extends Address{

    public House(String sN, int bN, String z, String t) { //street name, building number, zip, and type
        super(sN, bN, z, t);
    }
    
    //constructor without unit
    public House(String sN, String z, String t){
        super(sN,z,t);
    }

    @Override
    public String getType() {
       return "house"; 
    }
}
