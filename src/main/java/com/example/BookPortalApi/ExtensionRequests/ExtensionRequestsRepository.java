package com.example.BookPortalApi.ExtensionRequests;

import com.example.BookPortalApi.Books.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExtensionRequestsRepository extends JpaRepository<ExtensionRequests,Integer> {

    @Query("SELECT request FROM ExtensionRequests request WHERE request.book_id = :bookid and request.user_id = :userid")
    Optional<ExtensionRequests> findFirstByBook_idEqualsAndUser_idEquals(@Param("userid") int userid, @Param("bookid") int bookid);
}
