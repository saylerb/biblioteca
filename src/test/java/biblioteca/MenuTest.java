package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    private PrintStream stream;
    private BookLibrary library;
    private BufferedReader reader;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        stream = mock(PrintStream.class);
        library = mock(BookLibrary.class);
        reader = mock(BufferedReader.class);
        menu = new Menu(reader, stream, library);
    }

    @Test
    public void shouldTellLibraryToListAllBooksOnCustomerInput() throws IOException {

        menu.parseCustomerInput("a");

        verify(library).printAllBooks();
    }

    @Test
    public void shouldGiveCustomerAnErrorMessageWhenInvalidInputIsEntered() throws IOException {

        menu.parseCustomerInput("l");

        verify(stream).println("Select a valid option!");
    }


    @Test
    public void shouldTellLibraryToCheckoutBookWhenOptionCIsSelected() throws IOException {
        menu.parseCustomerInput("c");

        verify(library).checkoutBook();
    }
}