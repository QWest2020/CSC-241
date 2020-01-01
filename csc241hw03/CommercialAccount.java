/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;

import java.text.DecimalFormat;

public class CommercialAccount extends Account implements Constants {

    public CommercialAccount(String aN, Customer c) {
        super(aN, c);
    }

    @Override
    public void updateBalance() {
        double sum = 0;
        for (Address addr : getAddresses()) {
            for (Meter m : addr.getMeters()) {
                for (MeterReading mr : m.getReadings()) {
                    sum = sum + mr.getReading();
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        this.setBalance(Double.parseDouble(df.format(sum * commercialUnitRate)));
        
    }
}
