/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;
import java.util.ArrayList;

public abstract class Account{

    //wariables
    private String accountNum;
    private Customer customer;
    private String accountType;
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
    
    public String getAccountType(){
        return accountType;
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
    
    public ArrayList<Address> getAddressList(){
        return addressList;
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
    //set the balance
    public void setBalance(double b){
        balance=b;
    }
    //abstract update method
    public abstract void updateBalance();
    
    //set the type
    public void setType(String t){
        accountType=t;
    }
}
