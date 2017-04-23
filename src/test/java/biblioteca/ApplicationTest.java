package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ApplicationTest {
    private PrintStream stream;
    private Application app;
    private Menu menu;

    @Before
    public void setUp() throws Exception {
        stream = mock(PrintStream.class);
        menu = mock(Menu.class);
        app = new Application(stream, menu);
    }

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() throws IOException {
        when(menu.readLine()).thenReturn("q");

        app.start();

        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldDisplayListOfMenuOptions() throws IOException {
        when(menu.readLine()).thenReturn("q");

        app.start();

        verify(stream).println("Select a menu option: ");
        verify(stream).println("a - List all books");
        verify(stream).println("c - check out a book");
        verify(stream).println("q - quit");

    }

    @Test
    public void shouldAllowCustomerToChooseMultipleMenuOptions() throws IOException {
        when(menu.readLine()).thenReturn("a", "a", "q");

        app.start();

        verify(menu, times(2)).parseCustomerInput("a");
    }


}