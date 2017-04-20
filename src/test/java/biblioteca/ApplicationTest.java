package biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {
    @Test
    public void shouldDisplayAWelcomeMessageOnStart() {
        PrintStream stream = mock(PrintStream.class);
        BookLibrary library = mock(BookLibrary.class);
        Application app = new Application(stream, library);

        app.start();

        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldTellLibraryToListAllBooksOnStart() {
        PrintStream stream = mock(PrintStream.class);
        BookLibrary library = mock(BookLibrary.class);
        Application app = new Application(stream, library);

        app.start();

        verify(library).printAllBooks();
    }

}