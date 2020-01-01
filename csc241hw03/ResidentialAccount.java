/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;

import java.text.DecimalFormat;

public class ResidentialAccount extends Account implements Constants {

    public ResidentialAccount(String aN, Customer c) {
        super(aN,c);
    }

    @Override
    public void updateBalance() {
        double sum = 0;
        for (Address addr : this.getAddresses()) {
            for (Meter m: addr.getMeters()) {
                for (MeterReading mr : m.getReadings()) {
                    sum = sum + mr.getReading();
                }
            }
        }
        DecimalFormat df = new DecimalFormat("#.##");
        this.setBalance(Double.parseDouble(df.format(sum * residentialUnitRate)));
    }
}
