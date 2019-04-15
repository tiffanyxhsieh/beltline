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
    private boolean status;


    public User() {
        username="";
        firstName="";
        lastName="";
        status=false;
    }

    public User(String username,
                String email,
                String firstName,
                String lastName,
                boolean status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
