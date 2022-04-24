package com.example.BookPortalApi.Books;

import com.example.BookPortalApi.Transactions.TransactionsService;
import com.example.BookPortalApi.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BooksRepository booksRepository;
    private TransactionsService transactionsService;
    private UserService userService;

    @Autowired
    BookService(BooksRepository booksRepository, @Lazy TransactionsService transactionsService, UserService userService){
        this.booksRepository = booksRepository;
        this.transactionsService = transactionsService;
        this.userService = userService;
    }

    public String addBook(Books book) {
        Optional<Books> sameBook = this.booksRepository.findFirstByNameEqualsAndLender_nameEquals(book.getName(), book.getLender_name());
        if(sameBook.isPresent())
            return "Book Exists";
        this.booksRepository.save(book);
        return "Success";
    }

    public List<Books> fetchBooks() {
        return this.booksRepository.findAll();
    }

    public Optional<Books> findBookByNameAndLender(String name, String lender_name){
        return this.booksRepository.findFirstByNameEqualsAndLender_nameEquals(name,lender_name);
    }

    public Optional<Books> getBookById(int id){
        return this.booksRepository.findById(id);
    }

    public void makeBookUnAvailable(int id){
        this.booksRepository.updateStatus(id,"Unavailable");
    }

    @Transactional
    public void makeBookAvailable(int bookid, LocalDate returndate, int numberofdayslate, int userid, int transactionid){
        this.booksRepository.updateStatus(bookid,"Available");
        this.transactionsService.updateTransactionStatus(transactionid,returndate);
        this.userService.updateUserDues(userid,numberofdayslate);
    }

}
