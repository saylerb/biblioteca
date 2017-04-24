package biblioteca;

import java.util.Collection;
import java.util.List;

public class BookLibrary {
    private Collection<Book> books;

    public BookLibrary(List<Book> books) {
        this.books = books;
    }


    public void printAllBooks() {
        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void checkoutBook(String bookTitle) {
        Book book = findBook(bookTitle);

        if (book != null) {
            books.remove(book);
        }
    }

    public Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.hasTitle(bookTitle)) {
                return book;
            }
        }
        return null;

//        for (int i = 0; i < books.size(); i++) {
//            if (books.get(i).getInfo().contains(bookTitle)) {
//                return i;
//            }
//        }
//        return -1;
    }
}
