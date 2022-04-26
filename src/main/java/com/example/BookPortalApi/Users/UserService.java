package com.example.BookPortalApi.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String addUser(Users user) {
        if(this.userRepository.findAllByEmailEquals(user.getEmail()).size()>0)
            return "Duplicate email";
        if(this.userRepository.findAllByPhoneEquals(user.getPhone()).size()>0)
            return "Duplicate phone";
        this.userRepository.save(user);
        Optional<Users> currentUser = this.userRepository.findByEmail(user.getEmail());
        return Integer.toString(currentUser.get().getId());
    }

    public boolean checkIfUserExists(Users user) {
        Optional<Users> userExists =  this.userRepository.findByEmail(user.getEmail());
        return userExists.isPresent();
    }

    public boolean isPasswordCorrect(Users user) {
        Optional<Users> existingUser =  this.userRepository.findByEmail(user.getEmail());
        return existingUser.get().getPassword().equals(user.getPassword());
    }

    public Users returnUser(String email) {
        Optional<Users> existingUser =  this.userRepository.findByEmail(email);
        return existingUser.get();
    }

    public Users returnUserById(int id) {
        Optional<Users> existingUser =  this.userRepository.findById(id);
        return existingUser.get();
    }

    @Transactional
    public void updateUserDues(int userid, int dayslate) {
        int dues = dayslate*10;
        this.userRepository.updateDues(userid,dues);
    }

    @Transactional
    public String clearDues(int id) {
        this.userRepository.updateDues(id,0);
        return "Paid!";
    }

    @Transactional
    public void updatePassword(int id, String password) {
        this.userRepository.updatePassword(id,password);
    }
}
