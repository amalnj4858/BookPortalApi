package com.example.BookPortalApi.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "getTransactionbyid")
    @ResponseBody
    public List<Transactions> getTransactionsById(@RequestParam int id){
        return this.transactionsService.fetchTransactionsById(id);
    }

    @GetMapping(path = "getBorrower")
    @ResponseBody
    public String getBorrowerByBookId(@RequestParam int bookid){
        return this.transactionsService.getBorrowerByBookId(bookid);
    }

    @GetMapping(path = "getalltransactions")
    @ResponseBody
    public List<Transactions> getAllTransactions(){
        return this.transactionsService.returnAllTransactions();
    }
}
