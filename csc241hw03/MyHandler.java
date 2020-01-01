/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.*;

public class MyHandler extends DefaultHandler {

    //ArrayList of objects so we can keep adding new ones as they appear!
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Address> addresses = new ArrayList<>();
    private ArrayList<Meter> meters = new ArrayList<>();
    private ArrayList<MeterReading> meterReadings = new ArrayList<>();

    //temporary holders to store objects
    private Customer c = null;
    private Account a = null;
    private Address aD = null;
    private Meter m = null;
    private MeterReading mR = null;

    //Strings for every variable
    String firstName = "", lastName = "",
            accountType = "", accountNum = "",
            zip = "", number = "", street = "", unit = "", buildingType = "",
            iD = "", meterType = "", location = "", brand = "",
            flag = "", date = "", reading = "";

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        //Customer
        if (qName.equals("customer")) {
            firstName = attributes.getValue("firstName");
            lastName = attributes.getValue("lastName");
            c = new Customer(lastName, firstName, null);
            if (customers == null) {
                customers = new ArrayList<>();
            }
        }

        //Account
        if (qName.equals("account")) {
            accountType = attributes.getValue("type");
            accountNum = attributes.getValue("accountNumber");
            if (accountType.equals("commercial")) {
                a = new CommercialAccount(accountNum, null);
                a.setType("commercial");
            } else if (accountType.equals("residential")) {
                a = new ResidentialAccount(accountNum, null);
                a.setType("residential");
            }
            if (accounts == null) {
                accounts = new ArrayList<>();
            }
        }

        //Address
        if (qName.equals("address")) {
            zip = attributes.getValue("zip");
            number = attributes.getValue("number");
            street = attributes.getValue("street");
            unit = attributes.getValue("unit");
            buildingType = attributes.getValue("type");
            switch (buildingType) {
                case "house":
                    if (unit != null) {
                        aD = new House(street, Integer.parseInt(unit), zip, buildingType); //street name, building number, zip, and type
                    } else {
                        aD = new House(street, zip, buildingType);
                    }
                    break;
                case "apartment":
                    if (unit != null) {
                        aD = new Apartment(street, Integer.parseInt(unit), zip, buildingType);
                    } else {
                        aD = new Apartment(street, zip, buildingType);
                    }
                    break;
                case "commercial":
                    if (unit != null) {
                        aD = new Commercial(street, Integer.parseInt(unit), zip, buildingType);
                    } else {
                        aD = new Commercial(street, zip, buildingType);
                    }
                    break;
                case "mailing":
                    //aD remains null here! We won't count it when we loop through to add them to the account
                    c.setAddress(aD);
                default:
                    break;
            }
            if (addresses == null) {
                addresses = new ArrayList<>();
            }
        }

        //Meter
        if (qName.equals("meter")) {
            iD = attributes.getValue("id");
            meterType = attributes.getValue("type");
            location = attributes.getValue("location");
            brand = attributes.getValue("brand");
            switch (meterType) {
                case "poll":
                    m = new PollMeter(iD, brand, meterType); //ID, brand, type
                    m.setCurrentLocation(location);
                    break;
                case "push":
                    m = new PushMeter(iD, brand, meterType); //ID, brand, type
                    m.setCurrentLocation(location);
                    break;
                default:
                    break;
            }
            if (meters == null) {
                meters = new ArrayList<>();
            }
        }

        //MeterReading
        if (qName.equals("meterReading")) {
            flag = attributes.getValue("flag");
            date = attributes.getValue("date");
            reading = attributes.getValue("reading");
            mR = new MeterReading(Double.parseDouble(reading), LocalDateTime.parse(date), flag, null);
            if (meterReadings == null) {
                meterReadings = new ArrayList<>();
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        //Customer object is created!
        if (qName.equals("customer")) {
            for (int i = 0; i < accounts.size(); i++) {
                c.addAccount(accounts.get(i));
            }
            customers.add(c);
            //clear the list
            accounts.clear();
        }

        //Account object is created!
        if (qName.equals("account")) {
            for (int i = 0; i < addresses.size(); i++) {
                if (addresses.get(i) != null) {
                    switch (a.getAccountType()) {
                        case "commercial":
                            if (addresses.get(i).getType().equals("house")
                                    || addresses.get(i).getType().equals("commercial")) {
                                a.addAddress(addresses.get(i));
                            }
                            break;
                        case "residential":
                            if (addresses.get(i).getType().equals("house")
                                    || addresses.get(i).getType().equals("apartment")) {
                                a.addAddress(addresses.get(i));
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
            accounts.add(a);
            //clear the list
            addresses.clear();
        }

        //Address object is created!
        if (qName.equals("address")) {
            for (int i = 0; i < meters.size(); i++) {
                aD.addMeter(meters.get(i));
            }
            addresses.add(aD);
            //clear the list
            meters.clear();
        }

        //Meter object is created!
        if (qName.equals("meter")) {
            for (int i = 0; i < meterReadings.size(); i++) {
                m.addReading(meterReadings.get(i));
            }
            meters.add(m);
            //clear the list
            meterReadings.clear();
        }

        //MeterReading object is created!
        if (qName.equals("meterReading")) {
            meterReadings.add(mR);
        }
    }

    //accessors for our arrayLists
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }
}
