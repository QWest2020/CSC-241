/*
 *######################################################
 *#                                                    #
 *#                   Liam McMahan                     #
 *#                                                    #
 *######################################################
 */
package csc241hw06;
public class Student implements Comparable{
    
    //wariables
    String lastName; 
    int age;
    String major;
    boolean dormRes;
    int gradYear;
    
    //constructor
    public Student (String ln, int a, String m, boolean d, int g){
        lastName=ln;
        age=a;
        major=m;
        dormRes=d;
        gradYear=g;
    }
    
    //to String
    @Override
    public String toString(){
        return "name:"+lastName+
                " age:"+age+
                " major:"+major+
                " inDorm:"+dormRes+
                " gradYear:"+gradYear;
    }
    
    //compareTo
    @Override
    public int compareTo(Object t) {
        // Cast parameter to a Student
        Student s = (Student)t;
        return this.lastName.compareTo(s.lastName);
    }
}
