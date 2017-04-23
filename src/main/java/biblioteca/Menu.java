package biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {
    private final BufferedReader reader;
    private PrintStream stream;
    private BookLibrary library;

    public Menu(BufferedReader reader, PrintStream stream, BookLibrary library) {
        this.reader = reader;

        this.stream = stream;
        this.library = library;
    }


    String readLine() {
        String customerInput = "";
        try {
            customerInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerInput;
    }

    void parseCustomerInput(String customerInput) {
        if (customerInput.equals("a")) {
            library.printAllBooks();
        } else if (customerInput.equals("q")) {
            return;
        } else if (customerInput.equals("c")) {
            library.checkoutBook();
        } else {
            stream.println("Select a valid option!");
        }
    }
}
