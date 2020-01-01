/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeterReading {

    //wariables
    private double reading;
    private String flag;
    private Meter meter;
    private LocalDateTime date;
    
    //constructor
    public MeterReading(double r, LocalDateTime d, String f, Meter m){
        reading=r;
        flag=f;
        meter=m;
        date=d;
    }
    
    //accessors
    public double getReading(){
        return reading;
    }
    public LocalDateTime getDateTime(){
	return date;
    }
    //formats the date?
    public String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); //mess around with the formatting...
        LocalDateTime now = LocalDateTime.now();
        return(dtf.format(now));
    }
    public String getFlag(){
        return flag;
    }
    public Meter getMeter(){
        return meter;
    }
}
