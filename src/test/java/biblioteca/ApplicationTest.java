package biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ApplicationTest {
    private PrintStream stream;
    private BookLibrary library;
    private BufferedReader reader;
    private Application app;

    @Before
    public void setUp() throws Exception {
        stream = mock(PrintStream.class);
        library = mock(BookLibrary.class);
        app = new Application(stream, library);
        reader = mock(BufferedReader.class);
    }

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() {
        app.start();

        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldDisplayListOfMenuOptions() {
        app.start();

        verify(stream).println("Menu");
        verify(stream).println("1. Enter 'a' for a list of all books");
    }

    @Test
    public void shouldTellLibraryToListAllBooksOnCustomerInput() throws IOException {
        app.start();

        when(reader.readLine()).thenReturn("a");

        verify(library).printAllBooks();
    }

}