/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors; 

public class Main {
    public static void main(String[] args) {
        //prompt
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = input.nextLine();

        File inputFile = new File(fileName);

        try {
            //Scanner
            Scanner fileScanner = new Scanner(inputFile);
            //make the list
            List<Student> students = new ArrayList<Student>();
            //with the help of Prof Early
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                // Set the delimiter to a comma
                lineScanner = lineScanner.useDelimiter(",");
                Student s = new Student(lineScanner.next(), lineScanner.nextInt(), lineScanner.next(), lineScanner.nextBoolean(), lineScanner.nextInt());
                // Add student to list
                students.add(s);
            }

            //count
            System.out.println("Count of students: " + students.stream().count());

            //age
            List<Integer> ages = students.stream()
                    .map(s -> s.age)
                    .collect(Collectors.toList());
            double total=0;
            for(int i=0;i<ages.size();i++){
                total+=ages.get(i);
            }
            System.out.println("Average age: " + total / students.stream().count());

            //majors (no duplicates)
            List<String> majors=students.stream()
                    .map(s->s.major)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println("List of majors:");
            for(int i=0;i<majors.size();i++){
                System.out.println(majors.get(i));
            }

            //sorted order
            Comparator<Student> sortByLastName = (s1, s2) -> s1.compareTo(s2);
            System.out.println("Sorted by last name:");
            students.stream().sorted(sortByLastName)
                    .forEach(s -> System.out.println(s.toString()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
