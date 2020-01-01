/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.util.ArrayList;

/**
 *
 * @author jearly
 */
public class House extends Address {

    public House(String s, int h, String z, String t) {
        super(s, h, z, t);
    }

    public String getType() {
        return "house";
    }
}
