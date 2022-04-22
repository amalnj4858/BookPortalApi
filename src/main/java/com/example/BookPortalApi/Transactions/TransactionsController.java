package com.example.BookPortalApi.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "transactions")
@CrossOrigin("*")
public class TransactionsController {
    private TransactionsService transactionsService;

    @Autowired
    TransactionsController(TransactionsService transactionsService){
        this.transactionsService = transactionsService;
    }

    @PostMapping
    public String createTransaction(@RequestBody Transactions transaction){
        return this.transactionsService.addTransaction(transaction);
    }
}
