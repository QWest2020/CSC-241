/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
public class PushMeter extends Meter {
    
    //wariables
    private int interval;
    
   public PushMeter(String i, String b, String t){
       super(i,b,t);
   }
   
   @Override
   public String getType(){
       return "push";
   }
   
   //set interval
   public void setInterval(int s){
       interval=s;
   }
   
   //get interval
   public int getInterval(){
       return interval;
   }
}