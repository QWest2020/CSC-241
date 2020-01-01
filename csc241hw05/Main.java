/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw05;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        //Scanner
        Scanner input = new Scanner(System.in);
        
        //HashMap creation
        HashMap<String, String> myMap = new HashMap<String, String>();
        
        System.out.println("Enter the file name:");
        String fileName = input.nextLine();

        //pull lines from the text doc to make our hashmap!
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            //make our hashes!
            for (int i = 0; i < lines.size(); i++) {
                String key=lines.get(i).substring(0,lines.get(i).indexOf(" T")); //pulls the number before the words
                String value=lines.get(i).substring(lines.get(i).indexOf("This")); //pulls everything including and after the big T
                myMap.put(key,value);
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //is it here?
        System.out.println("Enter a key value:");
        String keyTest = input.nextLine();
        if(myMap.containsKey(keyTest)) //the key is here
            System.out.println("Value: "+myMap.get(keyTest));
        else
            System.out.println("No value found");
    }
}
