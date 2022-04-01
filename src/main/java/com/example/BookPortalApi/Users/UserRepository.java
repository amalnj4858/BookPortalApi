package com.example.BookPortalApi.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findAllByEmailEquals(String email);
    List<Users> findAllByPhoneEquals(String phone);
}
