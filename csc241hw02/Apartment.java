/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

/**
 *
 * @author jearly
 */
public class Apartment extends Address {
    
    private String unit;

    public Apartment(String s, int h, String z, String t, String u) {
        super(s, h, z, t);
        unit = u;
    }

    public String getType() {
        return "apartment";
    }
    
    public void setUnit(String u){
        unit = u;
    }
    
    public String getUnit(){
        return unit;
    }
}
