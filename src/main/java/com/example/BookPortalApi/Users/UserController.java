package com.example.BookPortalApi.Users;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping(path = "updatepassword")
    @ResponseBody
    public void returnUserById(@RequestParam int id, @RequestParam String password){
        this.userService.updatePassword(id,password);
    }

    @GetMapping(path = "getallusers")
    @ResponseBody
    public List<Users> returnUsers(){
        return this.userService.returnAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody Users user){
        String result = this.userService.addUser(user);
        return result;
    }

    @GetMapping(path = "payoff")
    @ResponseBody
    public String payOffDues(@RequestParam int id){
        return this.userService.clearDues(id);
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
