package com.example.BookPortalApi.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
