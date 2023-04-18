package com.nikolay.mvc.dao;

import com.nikolay.mvc.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static Long USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(1l,"Ivan", "Ivanov", 18));
        users.add(new User(2l,"Petr", "Ivanov", 12));
        users.add(new User(3l,"Gena", "Ivanov", 13));
    }
    public List<User> getAll(){
        return users;
    }
    public User getById(final int id){
        return users.stream().filter(u-> u.getId()==id).findAny().orElse(new User());
    }
 }
