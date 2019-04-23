package com.group51.beltline.models.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeProfile")
public class EmployeeProfile {

    @Id
    @Column(name="username")
    private String username;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="employeeID")
    private String employeeID;
    @Column(name="phone")
    private long phone;
    @Column(name="address")
    private String address;

    public EmployeeProfile(){}
    public EmployeeProfile(String username,
                           String firstname,
                           String lastname,
                           String employeeID,
                           long phone,
                           String address) {
        this.username = username;
        this.firstName = firstname;
        this.lastName = lastname;
        this.employeeID = employeeID;
        this.phone = phone;
        this.address = address;
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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
