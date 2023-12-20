package org.example.controllers;


import org.example.model.UserModel;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    private UserService service;

    public UserController(@Qualifier("user_service_Q") UserService service){
        this.service = service;
    }

    @GetMapping("/getUser/{userName}")
    public ResponseEntity<UserModel> getUser(@PathVariable String userName){
        /*if(userMap.containsKey(userName)){
            return ResponseEntity.of(Optional.of(userMap.get(userName)));
        }
        else{
            return ResponseEntity.notFound().build();
        }*/
        return ResponseEntity.of(Optional.ofNullable(service.getUser(userName)));
    }

    @PostMapping("/addUser")
    public ResponseEntity<HttpStatus> createUser(@RequestBody UserModel user){
        //userMap.put(user.getFirstName(), user);
        service.addUser(user);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/deleteUser/{userName}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userName){
        //userMap.remove(userName);
        service.deleteUser(userName);
        return ResponseEntity.noContent().build();
    }

}
