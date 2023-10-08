package part3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Student> ts = new TreeSet();

        Student s1 = new Student(139, "Nese", "Sahin");
        Student s2 = new Student(123, "Ali", "Candan");
        Student s3 = new Student(139, "Nese", "Sahin");
        Student s4 = new Student(123, "Ali", "Candan");
        Student s5 = new Student(111, "Zeynep", "Varlikli");

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);

        System.out.println(ts);

    }

}
