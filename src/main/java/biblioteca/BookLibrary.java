package biblioteca;

import java.util.List;

public class BookLibrary {
    private List<Book> books;

    public BookLibrary(List<Book> books) {
        this.books = books;
    }


    public void printAllBooks() {
        for (Book book : books) {
            book.printBookDetails();
        }
    }
}
