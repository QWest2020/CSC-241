/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

/**
 *
 * @author jearly
 */
public class Commercial extends Address {

    public Commercial(String s, int h, String z, String t) {
        super(s, h, z, t);
    }

    public String getType() {
        return "commercial";
    }
}
