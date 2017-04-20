package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Application {

    private final BookLibrary library;
    private final PrintStream stream;
    private final BufferedReader reader;

    public Application(PrintStream stream, BookLibrary library, BufferedReader reader) {
        this.library = library;
        this.stream = stream;
        this.reader = reader;
    }

    public void start() {
        stream.println("Welcome to the Biblioteca!");
        stream.println("Menu");
        stream.println("1. Enter 'a' for a list of all books");
    }

    public void getCustomerInput() {
        try {
            String menuOption = reader.readLine();
            parseCustomerInput(menuOption);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseCustomerInput(String menuOption) {
        if (menuOption.equals("a")) {
            library.printAllBooks();
        } else {
            stream.println("Select a valid option!");
        }
    }

}
