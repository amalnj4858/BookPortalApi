package com.example.BookPortalApi.Users;


import javax.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", allocationSize = 1)
    @GeneratedValue(generator = "mySeqGen")
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private int due_amt;

    public Users() {
    }

    public Users(String name, String phone, String email, String address, int due_amt) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.due_amt = due_amt;
    }

    public int getDue_amt() {
        return due_amt;
    }

    public void setDue_amt(int due_amt) {
        this.due_amt = due_amt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone + '\'' +
                ", address=" + address + '\'' +
                ", due=" + due_amt +
                '}';
    }
}
