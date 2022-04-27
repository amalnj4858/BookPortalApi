package com.example.BookPortalApi.ExtensionRequests;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class ExtensionRequests {
    @Id
    @SequenceGenerator(name = "extension_seq", sequenceName = "extension_request", allocationSize = 1)
    @GeneratedValue(generator = "extension_seq")
    private int id;
    private int user_id;
    private int book_id;
    private int transaction_id;
    private LocalDate extendedDate;

    public ExtensionRequests(int id, int user_id, int book_id, int transaction_id, LocalDate extendedDate) {
        this.id = id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.transaction_id = transaction_id;
        this.extendedDate = extendedDate;
    }

    public ExtensionRequests(int user_id, int book_id, int transaction_id, LocalDate extendedDate) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.transaction_id = transaction_id;
        this.extendedDate = extendedDate;
    }

    public ExtensionRequests() {
    }

    public LocalDate getExtendedDate() {
        return extendedDate;
    }

    public void setExtendedDate(LocalDate extendedDate) {
        this.extendedDate = extendedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
}
