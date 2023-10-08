package MainandSystemClass;

import Comparator.*;
import BookInheritance.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookSys {

    private static HashSet<Book> bookSet = new HashSet<Book>();

    public static void readFromFile() {
        Scanner sc = null;
        int isbn, year;
        Ebook eb;
        String category, format, authorName, title;

        try {
            File file1 = new File("books.txt");

            sc = new Scanner(file1);
            while (sc.hasNext()) {
                isbn = sc.nextInt();
                authorName = sc.next();
                category = sc.next();
                title = sc.next();
                year = sc.nextInt();
                format = sc.next();

                eb = new Ebook(isbn, authorName, category, title, year, format);
                bookSet.add(eb);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BookSys.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc.close();
    }

    public static boolean addToBookSet(int isbn, String authorName, String category, String title, int year, String format) {
        for (Book b : bookSet) {
            if (b.getIsbn() == isbn) {
                return false;
            }
        }

        Book eb = new Ebook(isbn, authorName, category, title, year, format);
        bookSet.add(eb);
        return true;
    }

    public static Set<Book> getBook() {
        return bookSet;
    }

    public static Book search(int isbn) {
        //With the iterator
        Iterator<Book> i = bookSet.iterator();
        while (i.hasNext()) {
            Book g = i.next();
            if (g.getIsbn() == isbn) {
                return g;
            }
        }
        //With for loop
        /*
        for (Book g : bookSet) {
            if (g.getIsbn() == isbn) {
                return g;
            }
        }*/

        return null;
    }

    public static String[] getIsbn() {
        //With for loop
        int i = 0;

        TreeSet<Book> gt = new TreeSet<>();
        gt.addAll(bookSet);
        String[] isbn = new String[gt.size()];
        for (Book g : gt) {
            isbn[i] = g.getIsbn() + "";
            i++;
        }
        //with the iterator
        /*
        int j = 0;
        Iterator<Book> it = gt.iterator();
        while (it.hasNext()) {
            isbn[j] = it.next().getIsbn() + "";
            j++;
        }
         */
        return isbn;
    }

    public static String displayAll() {

        TreeSet<Book> ts = new TreeSet();
        ts.addAll(bookSet);
        String res = "";
        for (Book g : ts) {
            res += g.toString() + "\n\n";
        }
        return res;
    }

    public static String displayBooksByCategory() {
        BookCategoryComparator bcc = new BookCategoryComparator();
        TreeSet<Book> ts = new TreeSet(bcc);// compare according to the category by using comparator
        ts.addAll(bookSet);
        String res = "";
        for (Book g : ts) {
            res += g.toString() + "\n";
        }

        return res;
    }

}
