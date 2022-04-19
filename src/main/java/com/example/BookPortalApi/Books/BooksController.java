package com.example.BookPortalApi.Books;


import com.example.BookPortalApi.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String addBook(@RequestBody Books Book){
        String response = this.bookService.addBook(Book);
        return response;
    }

    @GetMapping
    public List<Books> getBooks(){
        return this.bookService.fetchBooks();
    }

    @GetMapping(path ="getbook")
    @ResponseBody
    public Books getBookInfo(@RequestParam String name, @RequestParam String lender_name){
        Optional<Books> existingBook =  this.bookService.findBookByNameAndLender(name,lender_name);
        if(existingBook.isPresent())
            return existingBook.get();
        else
            return new Books();
    }

}
