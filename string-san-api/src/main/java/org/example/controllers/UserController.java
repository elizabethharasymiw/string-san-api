package org.example.controllers;


import org.example.model.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private Map<String, UserModel> userMap = new HashMap<>();

    public UserController(){
        userMap.put("John", new UserModel("John", "Doe", 1234));
        userMap.put("Jane", new UserModel("Jane", "Doe", 5432));
    }

    @GetMapping("/getUser/{userName}")
    public UserModel getUser(@PathVariable String userName){
        return userMap.get(userName);
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user){
        userMap.put(user.getFirstName(), user);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userName){
        userMap.remove(userName);
        return ResponseEntity.noContent().build();
    }

}
