package Comparator;

import BookInheritance.Book;
import java.util.Comparator;

public class BookCategoryComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        if (b2.getCategory().compareTo(b1.getCategory()) >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
