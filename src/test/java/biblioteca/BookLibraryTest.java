package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookLibraryTest {
    private BookLibrary library;
    private List<Book> books;
    private PrintStream stream;

    @Before
    public void setUp() {
        stream = mock(PrintStream.class);
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        library = new BookLibrary(books);
    }

    @Test
    public void shouldCallPrintAllBooksOnEachBook() {
        Book book = books.get(0);

        library.printAllBooks();

        verify(book).printBookDetails();
    }
}