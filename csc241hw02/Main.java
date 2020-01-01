/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author jearly
 */
public class Main implements Constants{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Random r = new Random();
        double sum = 0;

        Address custAddress = new House("Erie", 67, "13126", "single");
        Meter m1 = new PollMeter("ADB12345", "GE", "poll");
        // Add meter readings to this meter
        for (int i = 0; i < 100; i++) {
            double reading = (100 * r.nextDouble()) + 50;
            sum += reading;
            MeterReading mr = new MeterReading(reading, LocalDateTime.now(), "poll", m1);
            m1.addReading(mr);
        }
         Meter m2 = new PollMeter("ADB12346", "GE", "poll");
        // Add meter readings to this meter
        for (int i = 0; i < 100; i++) {
            double reading = (100 * r.nextDouble()) + 50;
            sum += reading;
            MeterReading mr = new MeterReading(reading, LocalDateTime.now(), "poll", m2);
            m2.addReading(mr);
        }
        custAddress.addMeter(m1);
        custAddress.addMeter(m2);
        
        Customer c = new Customer("Evans", "Elmer", custAddress);
        // Create a residential account
        Account acct = new ResidentialAccount("876-543-21", c);
        acct.addAddress(custAddress);

        System.out.println("SUM: " + sum);
        double rate = sum*residentialUnitRate;
        System.out.println("RATE: "+ rate);
        acct.updateBalance();
        System.out.println("getCurrentBalance: " + acct.getCurrentBalance());
    }
}
