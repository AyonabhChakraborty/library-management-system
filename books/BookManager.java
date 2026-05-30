package books;

import java.util.List;

import inventory.searchpackage.SearchInterface;

import java.util.ArrayList;



public class BookManager {

    private List<Book> books;

    public BookManager() {
        books = new ArrayList<>();
    }


    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }
    }


    public void removeBook(Book book){
        if(books.contains(book)){
            books.remove(book);
        }
    }


    public List<Book> getBooks(){
        return books;
    }

    public List<Book> searchBy(SearchInterface searcher,  String value){
        return searcher.search(books, value);
    }



}