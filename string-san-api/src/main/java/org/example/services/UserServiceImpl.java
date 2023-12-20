package org.example.services;

import org.example.model.UserModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Qualifier("user_service_Q")
public class UserServiceImpl {

    private Map<String, UserModel> userMap = new HashMap<>();

    public UserServiceImpl(){
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 5432));
    }

    public UserModel getUser(String userName){
        return userMap.get(userName);
    }

    public void addUser(UserModel user){
        userMap.put(user.getFirstName(), user);
    }

    public void deleteUser(String userName){
        userMap.remove(userName);
    }

}
