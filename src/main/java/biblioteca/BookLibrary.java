package biblioteca;

import java.util.List;

public class BookLibrary {
    private List<Book> books;

    public BookLibrary(List<Book> books) {
        this.books = books;
    }


    public void printAllBooks() {
        for (Book book : books) {
            book.printBookDetails();
        }
    }

    public void checkoutBook(String bookTitle) {
        int bookIndex = getBookIndex(bookTitle);
        books.remove(bookIndex);
    }

    public int getBookIndex(String bookTitle) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getInfo().contains(bookTitle)) {
                return i;
            }
        }
        return -1;
    }
}
