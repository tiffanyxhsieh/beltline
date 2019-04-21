package com.group51.beltline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee{


    @Id
    @Column(name="Username")
    private String username;

    @Column(name="EmployeeID")
    private int employeeId;//unique 9-digit

    @Column(name="Phone")
    private long phone;

    @Column(name="Address")
    private String address;

    @Column(name="City")
    private String city;

    @Column(name="State")
    private String state;

    @Column(name="Zipcode")
    private int zipcode;

    public Employee(){}

   public Employee(String username,
            int employeeId,
            long phone,
            String address,
            String city,
            String state,
            int zipcode) {
       this.username = username;
       this.employeeId = employeeId;
       this.phone = phone;
       this.address = address;
       this.city = city;
       this.state = state;
       this.zipcode = zipcode;


   }

    public long getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
