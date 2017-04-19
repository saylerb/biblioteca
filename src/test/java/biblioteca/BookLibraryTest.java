package biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

public class BookLibraryTest {

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() {
        PrintStream stream = mock(PrintStream.class);
        BookLibrary library = new BookLibrary(stream);
        library.start();
        verify(stream).println("Welcome to the Biblioteca!");
    }

}