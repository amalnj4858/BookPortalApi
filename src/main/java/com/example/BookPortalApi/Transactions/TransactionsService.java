package com.example.BookPortalApi.Transactions;

import com.example.BookPortalApi.Books.BookService;
import com.example.BookPortalApi.Requests.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import javax.transaction.Transactional;

@Service
public class TransactionsService {
    private TransactionsRepository transactionsRepository;
    private BookService bookService;
    private RequestsService requestsService;

    @Autowired
    TransactionsService(TransactionsRepository transactionsRepository,BookService bookService,RequestsService requestsService){
        this.transactionsRepository = transactionsRepository;
        this.bookService = bookService;
        this.requestsService = requestsService;
    }

    @Transactional
    public String addTransaction(Transactions transaction) {
        this.transactionsRepository.save(transaction);
        System.out.println(transaction.getBook_id());
        System.out.println(transaction.getRequest_id());
        this.bookService.makeBookUnAvailable(transaction.getBook_id());
        this.requestsService.updateRequestStatus(transaction.getRequest_id());
        return "Success";
    }
}
