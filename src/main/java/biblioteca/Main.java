package biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        PrintStream stream = System.out;
        List<Book> books = createBookList(stream);
        BookLibrary library = new BookLibrary(books);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu(reader, stream, library);
        Application app = new Application(stream, menu);

        app.start();
    }

    private static List<Book> createBookList(PrintStream stream) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(stream, "Harry Potter", "JK Rowling", "2004"));
        books.add(new Book(stream, "Tale of Two Cities", "Charles Dickens", "1859"));
        return books;
    }

}
