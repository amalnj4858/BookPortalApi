package com.example.BookPortalApi.Transactions;

import com.example.BookPortalApi.Books.BookService;
import com.example.BookPortalApi.Requests.RequestsService;
import com.example.BookPortalApi.Users.UserRepository;
import com.example.BookPortalApi.Users.UserService;
import com.example.BookPortalApi.Users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {
    private TransactionsRepository transactionsRepository;
    private BookService bookService;
    private RequestsService requestsService;
    private UserService userService;

    @Autowired
    TransactionsService(TransactionsRepository transactionsRepository,BookService bookService,RequestsService requestsService,UserService userService){
        this.transactionsRepository = transactionsRepository;
        this.bookService = bookService;
        this.requestsService = requestsService;
        this.userService = userService;
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

    public String getBorrowerByBookId(int bookid) {
        int borrower_id = this.transactionsRepository.findBorroweridOfBookid(bookid);
        Users user = this.userService.returnUserById(borrower_id);
        return user.getName();
    }

    public boolean getTransactionOnBook(int bookid){
        Optional<Transactions> transaction = this.transactionsRepository.findByBook_idEquals(bookid);
        if(transaction.isPresent())
            return true;
        else
            return false;
    }

    public List<Transactions> returnAllTransactions() {
        return this.transactionsRepository.findAll();
    }
}
