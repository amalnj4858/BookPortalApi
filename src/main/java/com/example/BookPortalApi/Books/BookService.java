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
}
