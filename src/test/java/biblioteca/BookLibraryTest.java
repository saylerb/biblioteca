package biblioteca;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

public class BookLibraryTest {
    private PrintStream stream;
    private BookLibrary library;
    private List<String> books;

    @Before
    public void setUp() {
        stream = mock(PrintStream.class);
        books = new ArrayList<String>();
        books.add("Harry Potter");
        books.add("Lord of the Rings");
        library = new BookLibrary(stream, books);
    }

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() {
        library.start();
        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test @Ignore
    public void shouldPrintNothingWhenNoBooksInLibrary() {
        BookLibrary emptyLibrary = new BookLibrary(stream, new ArrayList<>());
        emptyLibrary.start();
        verify(stream).println("Welcome to the Biblioteca!");
        verify(stream).println("");
    }

    @Test
    public void shouldPrintListOfBooksIfNonEmptyLibrary() {
        library.start();
        verify(stream).println("Welcome to the Biblioteca!");
        verify(stream).println("Harry Potter");
        verify(stream).println("Lord of the Rings");
    }

}