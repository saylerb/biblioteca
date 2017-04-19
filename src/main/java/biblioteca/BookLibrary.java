package biblioteca;

import java.io.PrintStream;

public class BookLibrary {

    private PrintStream stream;
    public BookLibrary(PrintStream stream) {
        this.stream = stream;
    }

    public void start() {
        stream.println("Welcome to the Biblioteca!");
    }
}
