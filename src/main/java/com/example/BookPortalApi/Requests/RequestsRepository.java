package com.example.BookPortalApi.Requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests,Integer> {

    @Query("SELECT request FROM Requests request WHERE request.lender_id = :id")
    List<Requests> findAllByLender_idEquals(@Param("id") int id);
}
