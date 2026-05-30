package inventory.searchpackage;
import books.Book;
import java.util.List;
import java.util.ArrayList;


public class searchByISBN implements SearchInterface {

    public List<Book> search(List<Book> books, String value){

        List<Book> result = new ArrayList<>();

        for(Book book : books){
            if(book.getIsbn().toString().equalsIgnoreCase(value)){
                result.add(book);
            }
        }

        return result;
    }


}