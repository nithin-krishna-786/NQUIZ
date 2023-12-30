package com.crio.codingame.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.crio.codingame.entities.User;

public class UserRepository implements IUserRepository{

    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
        userMap = new HashMap<String,User>();
    }

    public UserRepository(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement),entity.getName(),entity.getScore());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of User Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<User> findAll() {
        // return userMap.values()
        //        .stream()
        //        .collect(Collectors.toList());
               List<User> users = new ArrayList<>();
               for(User user:userMap.values())
               {
                   users.add(user);
               }
               return users;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        // TODO Auto-generated method stub
        
        return userMap.containsKey(id);
        //return false;
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub
        userMap.remove(entity.getId());
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        userMap.remove(id);
        
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return userMap.size();
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find the User Present in the Repository provided name
    // Tip:- Use Java Streams

    @Override
    public Optional<User> findByName(String name) {
        for(User user:userMap.values())
        {
           if(user.getName() == name)
           return Optional.ofNullable(user);
        }
           return Optional.ofNullable(null);    
        //  return Optional.empty();
    }    
}