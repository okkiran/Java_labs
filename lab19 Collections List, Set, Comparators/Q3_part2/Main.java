package part2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Student> hs = new HashSet();

        Student s1 = new Student(139, "Nese", "Sahin");
        Student s2 = new Student(123, "Ali", "Candan");
        Student s3 = new Student(139, "Nese", "Sahin");
        Student s4 = new Student(123, "Ali", "Candan");
        Student s5 = new Student(111, "Zeynep", "Varlikli");

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);
        hs.add(s4);
        hs.add(s5);

        System.out.println(hs);

    }

}
