package com.example.BookPortalApi.Requests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests,Integer> {
    List<Requests> findAllByLender_idEquals(int id);
}
