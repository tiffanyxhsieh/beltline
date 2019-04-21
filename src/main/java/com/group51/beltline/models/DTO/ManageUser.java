package com.group51.beltline.models.DTO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="manage_user")
public class ManageUser {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="COUNT(emailaddress)")
    private int count;

    @Column(name="status")
    private String status;

    public ManageUser(){}

    public ManageUser(String username, int count, String status) {
        this.username = username;
        this.count = count;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getUsername() {
        return username;
    }
}
