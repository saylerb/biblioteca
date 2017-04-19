package biblioteca;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.List;

public class BookLibrary {

    private PrintStream stream;
    private List<String> books;

    public BookLibrary(PrintStream stream, List<String> books) {
        this.stream = stream;
        this.books = books;
    }

    public void start() {
        stream.println("Welcome to the Biblioteca!");
        for(String book : books) {
            stream.println(book);
        }
    }
}
