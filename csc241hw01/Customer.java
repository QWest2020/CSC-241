/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw01;

import java.util.ArrayList;

public class Customer {

    //wariables
    private String firstName;
    private String lastName;
    private Address address;
    private ArrayList<Account> accountList = new ArrayList<Account>();
    private Account[] allAccounts={}; 
    
    //constructor
    public Customer(String lN, String fN, Address a){
        firstName=fN;
        lastName=lN;
        address=a;
    }
    
    //accessors
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public Address getMailingAddress(){
        return address;
    }
    public Account[] getAccounts(){
        return accountList.toArray(allAccounts);
    }
    
    //add an account
    public boolean addAccount(Account a){
        accountList.add(a);
        return (accountList.get(accountList.size()-1)==a);
    }
    //remove and account
    public boolean removeAccount(Account a){
        for (int i=0; i<accountList.size(); i++){
            if(accountList.get(i)==a){
                accountList.remove(i);
                return true; // we deleted something
            }
        }
        return false; //couldn't find it
    }
}
