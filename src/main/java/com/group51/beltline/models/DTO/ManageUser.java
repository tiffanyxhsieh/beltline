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

    @Column(name="userType")
    private String userType;


    @Column(name="number_of_emails")
    private int number_of_emails;

    @Column(name="status")
    private String status;

    public ManageUser(){}

    public ManageUser(String username, String userType, int number_of_emails, String status) {
        this.username = username;
        this.number_of_emails = number_of_emails;
        this.status = status;
        this.userType = userType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public String getUsername() {
        return username;
    }

    public int getNumber_of_emails() {
        return number_of_emails;
    }

    public void setNumber_of_emails(int number_of_emails) {
        this.number_of_emails = number_of_emails;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
