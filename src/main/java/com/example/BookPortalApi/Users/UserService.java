package com.example.BookPortalApi.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void addUser(Users user) {
        if(this.userRepository.findAllByEmailEquals(user.getEmail()).size()>0)
            throw new IllegalArgumentException("Duplicate email");
        if(this.userRepository.findAllByPhoneEquals(user.getPhone()).size()>0)
            throw new IllegalArgumentException("Duplicate phone");
        this.userRepository.save(user);
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
}
