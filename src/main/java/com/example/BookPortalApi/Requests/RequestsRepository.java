package com.example.BookPortalApi.Requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RequestsRepository extends JpaRepository<Requests,Integer> {

    @Query("SELECT request FROM Requests request WHERE request.lender_id = :id")
    List<Requests> findAllByLender_idEquals(@Param("id") int id);

    @Query("SELECT request FROM Requests request WHERE request.borrower_id = :borrower_id AND request.book_id= :book_id")
    Optional<Requests> findAllByBorrower_idEqualsAndBook_idEquals(@Param("borrower_id") int borrower_id, @Param("book_id") int book_id);

    @Modifying
    @Query("update Requests request set request.status = :status where request.request_id = :request_id")
    void updateRequestStatus(@Param(value = "request_id") int request_id, @Param(value = "status") String status);
}
