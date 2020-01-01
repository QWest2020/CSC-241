/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw01;

import java.util.ArrayList;

public class Account {

    //wariables
    private String accountNum;
    private Customer customer;
    private double balance;
    private ArrayList<Address> addressList = new ArrayList<Address>();
    private Address[] allAddresses={};

    //constructor
    public Account(String aN, Customer c) {
        accountNum = aN;
        customer = c;
        balance = 0;
    }

    //accessors
    public String getAccountNumber() {
        return accountNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getCurrentBalance() {
        return balance;
    }

    public Address[] getAddresses() {
        return addressList.toArray(allAddresses);
    }

    //add an address
    public boolean addAddress(Address a) {
        addressList.add(a);
        //check to see if this was added to the list
        return (addressList.get(addressList.size()-1)==a); 
    }
    
    //remove an address
    public boolean removeAddress(Address a){
        for (int i=0; i<addressList.size(); i++){
            if(addressList.get(i).equals(a)){
                addressList.remove(i);
                return true; // we deleted something
            }
        }
        return false; //couldn't find it
    }
}
