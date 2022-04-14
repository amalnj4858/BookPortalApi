package com.example.BookPortalApi.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Books> fetchBooks() {
        return this.booksRepository.findAll();
    }

    public Optional<Books> getBookById(int id){
        return this.booksRepository.findById(id);
    }
}
