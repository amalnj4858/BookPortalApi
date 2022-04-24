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

    @GetMapping(path = "findbyid")
    @ResponseBody
    public Users returnUserById(@RequestParam int id){
        return this.userService.returnUserById(id);
    }

    @PostMapping
    public String createUser(@RequestBody Users user){
        String result = this.userService.addUser(user);
        return result;
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
