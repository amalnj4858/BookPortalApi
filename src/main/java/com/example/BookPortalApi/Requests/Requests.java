package com.example.BookPortalApi.Requests;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Requests {
    @Id
    @SequenceGenerator(name = "req_seq", sequenceName = "request", allocationSize = 1)
    @GeneratedValue(generator = "req_seq")
    private int request_id;
    private int borrower_id;
    private int book_id;
    private int lender_id;
    private String status;

    public Requests(int request_id, int borrower_id, int book_id, int lender_id, String status) {
        this.request_id = request_id;
        this.borrower_id = borrower_id;
        this.book_id = book_id;
        this.lender_id = lender_id;
        this.status = status;
    }

    public Requests() {
    }



    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public int getBorrower_id() {
        return borrower_id;
    }

    public void setBorrower_id(int borrower_id) {
        this.borrower_id = borrower_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getLender_id() {
        return lender_id;
    }

    public void setLender_id(int lender_id) {
        this.lender_id = lender_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + request_id +
                ", borrower_id=" + borrower_id + '\'' +
                ", lender_id=" + lender_id + '\'' +
                ", book_id=" + book_id + '\'' +
                ", status=" + status +
                '}';
    }
}
