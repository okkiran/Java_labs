
package MainandSystemClass;

import GUI.*;

public class BookMain {

    public static void main(String[] args) {
        BookSys.readFromFile();
        BookFrame bf = new BookFrame();
        bf.setVisible(true);
       

    }

}
