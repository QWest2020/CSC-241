/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw01;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeterReading {

    //wariables
    private float reading;
    private String flag;
    private Meter meter;
    private LocalDateTime date;
    
    //constructor
    public MeterReading(float r, LocalDateTime d, String f, Meter m){
        reading=r;
        flag=f;
        meter=m;
        date=d;
    }
    
    //accessors
    public float getReading(){
        return reading;
    }
    public LocalDateTime getDateTime(){
	LocalDateTime now = LocalDateTime.now();
        return now;
    }
    //formats the date?
    public String getDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
