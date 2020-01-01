/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
public class Apartment extends Address{
    
    //wariables
    private String unit;

    public Apartment(String sN, int bN, String z, String t) { //street name, building number, zip, and type
        super(sN, bN, z, t);
    }
    //constructor without unit
    public Apartment(String sN, String z, String t){
        super(sN,z,t);
    }
    
    @Override
    public String getType() {
       return "apartment"; 
    }
    
    //get the unit for the apartment
    public String getUnit(){
        return unit;
    }
    
    //set the unit
    public void setUnit(String u){
        unit=u;
    }
}
