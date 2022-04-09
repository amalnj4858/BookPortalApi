package com.example.BookPortalApi.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BooksRepository booksRepository;

    @Autowired
    BookService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public void addBook(Books book) {
        this.booksRepository.save(book);
    }
}
