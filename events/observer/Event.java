package observer;

import books.Book;
import users.User;




public class Event {

    public static final String BOOK_BORROWED = "BOOK_BORROWED";

    public static final String BOOK_RETURNED = "BOOK_RETURNED";

    private String eventType;
    private Book book;
    private User user;


    public Event(String eventType, Book book, User user){
        this.eventType = eventType;
        this.book = book;
        this.user = user;
    }


    public String getEvent(){
        return eventType;
    }

    public Book getBook(){
        return book;
    }

    public User getUser(){
        return user;
    }



}