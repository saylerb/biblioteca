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
        String customerInput = "";
        while (!customerInput.equals("q")) {
            try {
                customerInput = reader.readLine();
                parseCustomerInput(customerInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseCustomerInput(String customerInput) {
        if (customerInput.equals("a")) {
            library.printAllBooks();
        } else if (customerInput.equals("q")) {
            stream.println("Quitting Application");
        } else {
            stream.println("Select a valid option!");
        }
    }
}
