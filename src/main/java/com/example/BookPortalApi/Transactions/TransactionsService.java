package com.example.BookPortalApi.Transactions;

import com.example.BookPortalApi.Books.BookService;
import com.example.BookPortalApi.Requests.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;

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
        this.bookService.makeBookUnAvailable(transaction.getBook_id());
        this.requestsService.updateRequestStatus(transaction.getRequest_id());
        return "Success";
    }

    public List<Transactions> fetchTransactionsById(int id) {
        return this.transactionsRepository.findAllByBorrower_idEquals(id);
    }

    @Transactional
    public void updateTransactionStatus(int transactionid, LocalDate returndate) {
        this.transactionsRepository.returnBook(transactionid,returndate,"Returned");
    }
}
