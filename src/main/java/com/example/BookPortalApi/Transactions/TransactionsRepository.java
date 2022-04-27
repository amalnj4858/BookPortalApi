package com.example.BookPortalApi.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {
    @Query("SELECT transaction FROM Transactions transaction WHERE transaction.borrower_id = :borrower_id")
    List<Transactions> findAllByBorrower_idEquals(@Param("borrower_id") int borrower_id);

    @Modifying
    @Query("update Transactions transaction set transaction.date_returned = :returndate, transaction.book_status = :returnstatus where transaction.id = :transactionid")
    void returnBook(@Param("transactionid") int transactionid,@Param("returndate") LocalDate returndate,@Param("returnstatus") String returnstatus);

    @Modifying
    @Query("update Transactions transaction set transaction.expected_return_date = :extendedDate where transaction.id = :transactionid")
    void extendDate(@Param("transactionid") int transationid,@Param("extendedDate") LocalDate extendedDate);
}
