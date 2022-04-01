package com.example.BookPortalApi.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "users")
@CrossOrigin("*")
public class UserController {
    private UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public String print(){
        return "helloooo";
    }

    @PostMapping
    public void createUser(@RequestBody Users user){
        this.userService.addUser(user);
    }
}
