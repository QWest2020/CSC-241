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
public class PollMeter extends Meter {
    
    // - A constructor to initialize ID, brand, and type.
    public PollMeter(String i, String b, String t) {
        super(i, b, t);
    }

    public String getType() {
        return "poll";
    }
    
}
