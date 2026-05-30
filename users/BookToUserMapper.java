package users;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;


public class BookToUserMapper{

    private Map<Integer, List<Integer>> mapper;

    public BookToUserMapper(){

        mapper = new HashMap<>();
        
    }


    public void borrowBook(Integer userId, Integer bookId){
        if(!mapper.containsKey(userId)){
            mapper.put(userId, new ArrayList<>());
        }

        mapper.get(userId).add(bookId);
    }


    public void returnBook(Integer userId, Integer bookId){
        if(mapper.containsKey(userId)){
        mapper.get(userId).remove(bookId);
        }
    }


    public Map<Integer, List<Integer>> getMapper(){
        return mapper;
    }



}