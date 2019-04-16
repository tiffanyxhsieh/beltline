package com.group51.beltline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name="Username")
    private String username;

    @Column(name="Firstname")
    private String firstName;

    @Column(name="Lastname")
    private String lastName;

    @Column(name="Status")
    private Status status;

    @Column(name="Password")
    private String password;

    enum Status{
        Approved, Declined, Pending;
    };

    public User(String username, String email, String firstName, String lastName, Status status) {
        this.username ="";
        this.firstName ="";
        this.lastName ="";
        this.password="";
        this.status = Status.Pending;
    }
    public User() {}

    public User(String username,
                String email,
                String firstName,
                String lastName,
                String password,
                Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
