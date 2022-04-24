package com.example.BookPortalApi.Transactions;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

@Table
@Entity
public class Transactions {
    @Id
    @SequenceGenerator(name = "transactions", sequenceName = "transactionSeq", allocationSize = 1)
    @GeneratedValue(generator = "transactions")
    private int id;
    private int request_id;
    private int book_id;
    private int borrower_id;
    private int lender_id;
    private LocalDate issue_date;
    private LocalDate expected_return_date;
    private String book_status;
    private LocalDate date_returned;

    public Transactions() {
    }

    public Transactions(int id, int request_id, int book_id, int borrower_id, int lender_id, LocalDate issue_date, LocalDate expected_return_date, LocalDate date_returned, String book_status) {
        this.id = id;
        this.request_id = request_id;
        this.book_id = book_id;
        this.borrower_id = borrower_id;
        this.lender_id = lender_id;
        this.issue_date = issue_date;
        this.expected_return_date = expected_return_date;
        this.book_status = book_status;
        this.date_returned = date_returned;
    }

    public int getId() {
        return id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public LocalDate getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(LocalDate date_returned) {
        this.date_returned = date_returned;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(int borrower_id) {
        this.borrower_id = borrower_id;
    }

    public int getLender_id() {
        return lender_id;
    }

    public void setLender_id(int lender_id) {
        this.lender_id = lender_id;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public LocalDate getExpected_return_date() {
        return expected_return_date;
    }

    public void setExpected_return_date(LocalDate expected_return_date) {
        this.expected_return_date = expected_return_date;
    }

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }
}
