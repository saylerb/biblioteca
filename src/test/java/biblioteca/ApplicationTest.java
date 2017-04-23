package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ApplicationTest {
    private PrintStream stream;
    private BookLibrary library;
    private BufferedReader reader;
    private Application app;

    @Before
    public void setUp() throws Exception {
        stream = mock(PrintStream.class);
        library = mock(BookLibrary.class);
        reader = mock(BufferedReader.class);
        app = new Application(stream, library, reader);
    }

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() throws IOException {
        when(reader.readLine()).thenReturn("q");
        app.start();

        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws IOException {
        when(reader.readLine()).thenReturn("q");
        app.start();

        verify(stream).println("Select a menu option: ");
        verify(stream).println("a - List all books");
        verify(stream).println("q - quit");
    }

    @Test
    public void shouldTellLibraryToListAllBooksOnCustomerInput() throws IOException {
        when(reader.readLine()).thenReturn("a", "q");

        app.start();

        verify(library).printAllBooks();
    }

    @Test
    public void shouldGiveCustomerAnErrorMessageWhenInvalidInputIsEntered() throws IOException {
        when(reader.readLine()).thenReturn("l", "q");

        app.start();

        verify(stream).println("Select a valid option!");
    }

    @Test
    public void shouldAllowCustomerToChooseMultipleMenuOptions() throws IOException {
        when(reader.readLine()).thenReturn("a", "a", "q");

        app.start();

        verify(library, times(2)).printAllBooks();
    }

}