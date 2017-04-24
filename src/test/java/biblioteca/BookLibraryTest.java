package biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    public void shouldRemoveFirstBookListWhenCustomerChecksOutBook() {
        when(books.get(0).getInfo()).thenReturn("Harry Potter");
        when(books.get(1).getInfo()).thenReturn("A Tale of Two Cities");

        library.checkoutBook("Harry Potter");

        assertThat(books.size(), is(1));
    }

    @Test
    public void shouldRemoveLastBookListWhenCustomerChecksOutBook() {
        when(books.get(0).getInfo()).thenReturn("Harry Potter");
        when(books.get(1).getInfo()).thenReturn("A Tale of Two Cities");

        library.checkoutBook("A Tale of Two Cities");

        assertThat(books.size(), is(1));
    }

    @Test @Ignore
    public void shouldBeAbleToDetermineIndexOfFirstBookWhenGivenATitle() {
        when(books.get(0).getInfo()).thenReturn("Harry Potter");
        when(books.get(1).getInfo()).thenReturn("A Tale");

        Integer index = library.getBookIndex("Harry Potter");

        assertThat(index, is(0));
    }

    @Test
    public void shouldBeAbleToDetermineIndexOfSecondBookWhenGivenATitle() {
        when(books.get(0).getInfo()).thenReturn("Harry Potter");
        when(books.get(1).getInfo()).thenReturn("A Tale");

        Integer index = library.getBookIndex("A Tale");

        assertThat(index, is(1));
    }

}