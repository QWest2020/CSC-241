/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
import java.util.ArrayList;

public abstract class Meter {
    
    //wariables 
    private String IdNum;
    private String brand;
    private String type;
    private String location;
    private Address address;
    private ArrayList<MeterReading> readings = new ArrayList<MeterReading>();
    private MeterReading[] allReadings={};
    
    //constructor
    public Meter(String i, String b, String t){
        IdNum=i;
        brand=b;
        type=t;
    }
    
    //accessors
    public String getID(){
        return IdNum;
    }
    public MeterReading[] getReadings(){
         allReadings=readings.toArray(allReadings);
         return allReadings;
    }
    public ArrayList <MeterReading> getMeterReadingList(){
        return readings;
    }
    
    public MeterReading getCurrentReading(){
        if(readings.size()<1)
            return null;
        else if(readings.size()<2) //1 element
            return readings.get(1);
        else
            return readings.get(readings.size()-1);
    }
    public String getBrand(){
        return brand;
    }
    //abstract method
    public abstract String getType();
    
    public String getLocation(){
        return location;
    }
    public Address getAddress(){
        return address;
    }
    
    //add a Reading
    public void addReading(MeterReading m){
        readings.add(m);
    }
    
    //set a location
    public void setLocation(Address a, String n){
        address = a;
        location=n;
    }
    
    //set a location?
    public void setCurrentLocation(String l){
        location=l;
    }
}
