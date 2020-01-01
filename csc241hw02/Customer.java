/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.util.ArrayList;

/**
 *
 * @author jearly
 */
public class Customer {
// Customer - This class represents individuals that are paying for energy 
// services.
// Variables

    private String lastName;
    private String firstName;
    private Address mailingAddress;
    private ArrayList<Account> accounts;

//    The following methods should be available:
//getLastName() - Returns a String containing the customer’s last name
    public String getLastName() {
        return lastName;
    }

//getFirstName() - Returns a String containing the customer’s first name
    public String getFirstName() {
        return firstName;
    }
//getMailingAddress()  - Returns an Address reference (see above)

    public Address getMailingAddress() {
        return mailingAddress;
    }

//getAccounts() - Returns an array of Account objects for this customer
    public Account[] getAccounts() {
        Account[] accountArray = new Account[accounts.size()];
        accountArray = accounts.toArray(accountArray);
        return accountArray;
    }

//addAccount(Account a) - Add an account for this customer
    public void addAccount(Account a) {
        accounts.add(a);
    }
//removeAccount(Account a) - remove account.

    public boolean removeAccount(Account a) {
        return accounts.remove(a);
    }
//A constructor that initializes the last name, first name, and address of the customer.

    public Customer(String l, String f, Address a) {
        lastName = l;
        firstName = f;
        mailingAddress = a;
        accounts = new ArrayList<Account>();
    }
}
