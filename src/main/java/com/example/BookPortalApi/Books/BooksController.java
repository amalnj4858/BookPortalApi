package com.example.BookPortalApi.Books;


import com.example.BookPortalApi.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "books")
@CrossOrigin("*")
public class BooksController {
    private BookService bookService;

    @Autowired
    BooksController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody Books Book){
        this.bookService.addBook(Book);
    }
}
