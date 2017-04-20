package biblioteca;

public class Book {
    private final String title;
    private final String author;
    private final String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookDetails() {
        return title + "--" + author + "--" + yearPublished;
    }
}
