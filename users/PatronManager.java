package users;

import java.util.List;
import java.util.ArrayList;


public class PatronManager {

    private List<User> users;

    public PatronManager() {

        users = new ArrayList<>();

    }


    public void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
        }
    }

    public void removeUser(User user){
        if(users.contains(user)){
            users.remove(user);
        }
    }


    public List<User> getUsers(){
        return users;
    }

}