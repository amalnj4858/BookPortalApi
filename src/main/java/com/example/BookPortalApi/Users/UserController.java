package com.example.BookPortalApi.Users;

import org.apache.coyote.Response;
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
    @ResponseBody
    public Users returnUserDetails(@RequestParam String email){
        return this.userService.returnUser(email);
    }

    @PostMapping
    public void createUser(@RequestBody Users user){
        this.userService.addUser(user);
    }

    @PostMapping(path = "signin")
    public String authenticateUser(@RequestBody Users user){
        if(this.userService.checkIfUserExists(user)){
            if(this.userService.isPasswordCorrect(user)){
                return "Authorised";
            }
            else
                return "Wrong Password";
        }
        else
            return "No Such User!";
    }
}
