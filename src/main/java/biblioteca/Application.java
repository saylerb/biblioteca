package biblioteca;

import java.io.PrintStream;

public class Application {

    private final PrintStream stream;
    private Menu menu;

    public Application(PrintStream stream, Menu menu) {
        this.stream = stream;
        this.menu = menu;
    }

    public void start() {
        stream.println("Welcome to the Biblioteca!");
        stream.println("Select a menu option: ");
        stream.println("a - List all books");
        stream.println("c - check out a book");
        stream.println("q - quit");

        String customerInput = "";

        while (!customerInput.equals("q")) {
            customerInput = menu.readLine();
            menu.parseCustomerInput(customerInput);
        }

        stream.println("Quitting Application");
    }

}
