package biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private PrintStream stream;
    private List<Book> books;

    public BookLibrary(PrintStream stream) {
        this.stream = stream;
        this.books = createBookList();
    }

    private List<Book> createBookList() {
        books = new ArrayList<>();
        books.add(new Book("Harry Potter", "JK Rowling", "2004"));
        books.add(new Book("Tale of Two Cities", "Charles Dickens", "1859"));
        return books;
    }


    public void start() {
        stream.println("Welcome to the Biblioteca!");
        for(Book book : books) {
            stream.println(book.getBookDetails());
        }
    }
}
