package com.example.BookPortalApi.Requests;

import com.example.BookPortalApi.Books.BookService;
import com.example.BookPortalApi.Books.Books;
import com.example.BookPortalApi.Books.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class RequestsService {
    private RequestsRepository requestsRepository;
    private BookService bookService;

    @Autowired
    RequestsService(RequestsRepository requestsRepository, BookService bookService){
        this.requestsRepository = requestsRepository;
        this.bookService = bookService;
    }
    public String addRequest(Requests request) {
        Optional<Books> book_requested = this.bookService.getBookById(request.getBook_id());
        System.out.println(request);
        if(book_requested.isPresent()){
            Books book = book_requested.get();
            if(book.getBook_status().toLowerCase(Locale.ROOT).equals("available")){
                this.requestsRepository.save(request);
                return "Request Created";
            }
            else
                return "Book not available";
        }
        else
            return "Book does not exist in pool";
    }
}
