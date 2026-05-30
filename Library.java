import books.Book;
import books.BookManager;


import users.User;
import users.PatronManager;

import inventory.InventoryManager;

import observer.Event;
import observer.Observer;


import java.util.List;
import java.util.ArrayList;




public class Library {

    private BookManager bookManager;
    private PatronManager patronManager;
    private InventoryManager inventoryManager;

    private List<Observer> observers;


    public Library(){
        bookManager = new BookManager();
        patronManager = new PatronManager();
        inventoryManager = InventoryManager.getInstance();

        observers = new ArrayList<>();

    }


    public BookManager getBookManager(){
        return bookManager;
    }

    public PatronManager getPatronManager(){
        return patronManager;
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(Event event){

        for(Observer observer : observers){
            observer.update(event);
        }
    }


    public void borrowBook(Book book, User user){

        inventoryManager.borrowBook(book, user);

        Event event = new Event("BOOK_BORROWED", book, user);


        notifyObservers(event);

    }


    public void returnBook(Book book, User user){
        inventoryManager.returnBook(book, user);
        Event event = new Event("BOOK_RETURNED", book, user);
        notifyObservers(event);
    }




    
}
