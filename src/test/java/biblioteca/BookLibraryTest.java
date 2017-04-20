package biblioteca;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;


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
        library = new BookLibrary(stream);
    }

    @Test
    public void shouldDisplayAWelcomeMessageOnStart() {
        library.start();
        verify(stream).println("Welcome to the Biblioteca!");
    }

    @Test
    public void shouldPrintListOfBooksIfNonEmptyLibrary() {
        library.start();

        verify(stream).println(Mockito.contains("Harry Potter"));
        verify(stream).println(Mockito.contains("Tale of Two Cities"));
    }

    @Test
    public void shouldPrintListOfBooksWithAuthorAndYearPublished() {
        library.start();

        verify(stream).println("Harry Potter--JK Rowling--2004");
        verify(stream).println("Tale of Two Cities--Charles Dickens--1859");
    }


}