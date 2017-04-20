package biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class BookTest {

    @Test
    public void getBookDetails() throws Exception {
        PrintStream stream = mock(PrintStream.class);
        Book book = new Book(stream, "Harry Potter", "JK Rowling", "2004");

        book.printBookDetails();

        verify(stream).println("Harry Potter--JK Rowling--2004");
    }

}