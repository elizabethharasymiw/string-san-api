package org.example.controllers;


import org.example.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/getUser")
    public UserModel getUser(){
        return new UserModel("John", "Doe", 1234);
    }

}
