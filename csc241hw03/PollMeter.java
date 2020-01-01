/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;

public class PollMeter extends Meter{
    
   public PollMeter(String i, String b, String t){
       super(i,b,t);
   }
   @Override
   public String getType(){
       return "poll";
   }
}
