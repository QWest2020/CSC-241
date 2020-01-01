/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw01;

import java.util.ArrayList;

public class Address {

    //wariables 
    //no meters and no account
    private String streetName;
    private int buildingNumber;
    private String zip;
    private String buildingType;
    private ArrayList<Meter> meters = new ArrayList<Meter>();
    private Meter[] allMeters = {};
    private Account account;
    
    //constructor
    public Address(String sN, int bN, String z, String t){
        streetName=sN;
        buildingNumber=bN;
        zip=z;
        buildingType=t;
    }
    
    //accessors
    public String getStreet(){
        return streetName;
    }
    public int getNumber(){
        return buildingNumber;
    }
    public String getZipCode(){
        return zip;
    }
    public String getType(){
        return buildingType;
    }
    public Meter[] getMeters(){
        return meters.toArray(allMeters);
    }
    public Account getAccount(){
        return account;
    }
    
    //add a meter
    public boolean addMeter(Meter m){
        meters.add(m);
        return (meters.get(meters.size()-1)==m); //checks to see if the most recent added is equal to our parameter
    }
    
    //remove a meter
    public boolean removeMeter (String id){
        for (int i=0; i<meters.size(); i++){
            if(meters.get(i).getID().equals(id)){
                meters.remove(i);
                return true; // we deleted something
            }
        }
        return false; //couldn't find it
    }
    
    //set an account
    public void setAccount(Account a){
        account=a;
    }
}
