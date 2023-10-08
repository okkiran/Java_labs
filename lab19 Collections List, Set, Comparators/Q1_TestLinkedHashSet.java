

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TestLinkedHashSet {

    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while (sc.hasNext()) {
                set.add(sc.next());
            }

            System.out.println(set);
            Iterator<String> it = set.iterator();
            
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
