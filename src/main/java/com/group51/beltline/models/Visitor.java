package com.group51.beltline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Visitor")
public class Visitor {

    @Id
    @Column(name="Username")
    private String username;

    public Visitor(){
    }

    public Visitor(String username){
        this.username = username;

    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
