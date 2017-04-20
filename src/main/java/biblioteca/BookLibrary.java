package biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BookLibrary {

    private PrintStream stream;
    private List<String> books;

    public BookLibrary(PrintStream stream) {
        this.stream = stream;
        this.books = createBookList();
    }

    private List<String> createBookList() {
        books = new ArrayList<>();
        books.add("Harry Potter");
        books.add("Tale of Two Cities");
        return books;
    }


    public void start() {
        stream.println("Welcome to the Biblioteca!");
        for(String book : books) {
            stream.println(book);
        }
    }
}
