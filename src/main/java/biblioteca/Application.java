package biblioteca;

import java.io.PrintStream;

public class Application {

    private final BookLibrary library;
    private final PrintStream stream;

    public Application(PrintStream stream, BookLibrary library) {
        this.library = library;
        this.stream = stream;
    }

    public void start() {
        stream.println("Welcome to the Biblioteca!");
        library.printAllBooks();
    }
}
