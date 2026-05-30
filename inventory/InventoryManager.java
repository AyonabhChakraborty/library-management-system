package inventory;

import books.*;
import java.util.*;
import users.*;



public class InventoryManager{

    private static InventoryManager inventory;

    private BookToUserMapper mapper;

    private InventoryManager(){
        mapper = new BookToUserMapper();
    }

    public static InventoryManager getInstance(){
        if(inventory == null){
            inventory = new InventoryManager();
        }

        return inventory;
    }

    public void borrowBook(Book book, User user){
        if(book.isAvailable()){
            book.setAvailable(false);
            mapper.borrowBook(user.getUserId(), book.getBookId());
        }
        
    }
    


    public void returnBook(Book book, User user){

         mapper.returnBook(
        user.getUserId(),
        book.getBookId()
    );
        if(book.isAvailable()==false){
            book.setAvailable(true);
        }

    }




}





