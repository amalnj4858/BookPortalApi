package com.example.BookPortalApi.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {
    @Query("SELECT book FROM Books book WHERE book.name = :book_name and book.lender_name = :lender_name")
    Optional<Books> findFirstByNameEqualsAndLender_nameEquals(@Param("book_name") String book_name,@Param("lender_name") String lender_name);

    @Modifying
    @Query("update Books book set book.book_status = :status where book.id = :book_id")
    void updateStatus(@Param(value = "book_id") int book_id, @Param(value = "status") String status);
}

