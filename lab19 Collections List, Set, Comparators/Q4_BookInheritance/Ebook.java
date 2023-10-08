
package BookInheritance;


public class Ebook extends Book {

    private String format;

    public Ebook(int isbn, String authorName, String category, String title, int year, String format) {
        super(isbn, authorName, category, title, year);
        this.format = format;
    }

    @Override
    public String toString() {
        return "Ebook\n" + super.toString() + "\nFormat= " + format + "\n";
    }

    @Override
    public int compareTo(Book t) {
        int res = this.isbn - t.getIsbn();
        return (res);
    }

}
