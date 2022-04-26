package com.example.BookPortalApi.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    List<Users> findAllByEmailEquals(String email);
    List<Users> findAllByPhoneEquals(String phone);

    Optional<Users> findByEmail(String email);

    @Modifying
    @Query("update Users user set user.due_amt = :dues where user.id = :userid")
    void updateDues(@Param(value = "userid") int userid, @Param(value = "dues") int dues);

    @Modifying
    @Query("update Users user set user.password = :password where user.id = :id")
    void updatePassword(@Param(value = "id") int id,@Param(value = "password") String password);
}
