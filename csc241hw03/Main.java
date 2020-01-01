/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw03;

import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;

public class Main extends DefaultHandler {

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        MyHandler handler = new MyHandler();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Enter the input file name:");
            String fileName = input.nextLine();
            saxParser.parse(fileName, handler);
            //our objects pull from the parser
            ArrayList<Customer> customers = handler.getCustomers();
            System.out.println("Enter the account number:");
            String accountNumber = input.nextLine();
            //pull the account by comparing its number to the string entered
            boolean found = false;
            for (int i = 0; i < customers.size(); i++) {
                ArrayList<Account> accounts = customers.get(i).getAccountList();
                for (int j = 0; j < accounts.size(); j++) {
                    if (accounts.get(j).getAccountNumber().equals(accountNumber)) { //if we get a match
                        accounts.get(j).updateBalance();
                        System.out.println("Balance: $" + accounts.get(j).getCurrentBalance());
                        found = true;
                        break; //break completely
                    }
                }
                if (found) {
                    break; //break completely
                }
            }
            if (!found) //account number not found
            {
                System.out.println("Account number " + accountNumber + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
