import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        System.out.println("Enter CTIS courses:");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        while (!str.equalsIgnoreCase("STOP")) {
            set.add(str);
            str = sc.next();
        }

        System.out.println(set);
        
        TreeSet<String> ts = new TreeSet<>(set);

        System.out.println(ts);

    }

}
