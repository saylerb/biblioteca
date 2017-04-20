package biblioteca;

import java.io.PrintStream;

public class Book {
    private final String title;
    private final String author;
    private final String yearPublished;
    private final PrintStream stream;

    public Book(PrintStream stream, String title, String author, String yearPublished) {
        this.stream = stream;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public void printBookDetails() {
        stream.println(title + "--" + author + "--" + yearPublished);
    }
}
