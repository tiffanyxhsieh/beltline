package com.group51.beltline.models;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(table="User", name="Username")
    private String username;

    @Column(table="User", name="Firstname")
    private String firstName;

    @Column(table="User", name="Lastname")
    private String lastName;

    @Column(table="User", name="Status")
    private String status;

    @Column(table="User", name="Password")
    private String password;



    public User(String username, String firstName, String lastName, String password, String status) {
        this.username ="";
        this.firstName ="";
        this.lastName ="";
        this.password="";
        this.status = "";
    }
    public User() {
        this.status="";
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


    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }
}
