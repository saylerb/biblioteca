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
        stream.println("Select a menu option: ");
        stream.println("a - List all books");
        stream.println("q - quit");

        String customerInput = "";

        while (!customerInput.equals("q")) {
            customerInput = getCustomerInput();
            parseCustomerInput(customerInput);
        }

        stream.println("Quitting Application");
    }

    private String getCustomerInput() {
        String customerInput = "";
        try {
            customerInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerInput;
    }

    private void parseCustomerInput(String customerInput) {
        if (customerInput.equals("a")) {
            library.printAllBooks();
        } else if (customerInput.equals("q")) {
            return;
        } else {
            stream.println("Select a valid option!");
        }
    }
}
