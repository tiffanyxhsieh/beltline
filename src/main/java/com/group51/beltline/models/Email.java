package com.group51.beltline.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name="Email")
public class Email {

    @Column(name="Username")
    private String username;

    @Id
    @Column(name="EmailAddress")
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
