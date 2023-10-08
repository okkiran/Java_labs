
package BookInheritance;

public abstract class Book implements Comparable<Book>{
    protected int isbn;
    protected String authorName;
    protected String category;
    protected String title;
    protected int year;

    public Book(int isbn, String authorName, String category, String title, int year) {
        this.isbn = isbn;
        this.authorName = authorName;
        this.category = category;
        this.title = title;
        this.year = year;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }
    
    
    @Override
    public String toString() {
        return "Book" + "\nISBN= " + isbn + 
                "\nAuthor Name= " + authorName + 
                "\nCategory= " + category + 
                "Title= " + title + 
                "\nYear= " + year;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.isbn;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.isbn != other.isbn) {
            return false;
        }
        return true;
    }
    
    
    
}
