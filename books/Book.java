package books;

public class Book {
    
    private Integer bookId;
    private String title;
    private String author;
    private Integer isbn;
    private Integer publicationYear;
    private String genre;
    private Boolean availability;


    public Book(Integer bookId, String title, String author, Integer isbn, Integer publicationYear, String genre, Boolean availability){
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.availability = availability;
    }


    public Integer getBookId() {
    return bookId;
}


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailable(boolean available) {
        this.availability = available;
    }



}