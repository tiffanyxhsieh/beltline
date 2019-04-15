package com.group51.beltline.models;

public class Employee extends User {
    private int employeeId;//unique 9-digit
    private int phone;
    private String address;
    private String city;
    private String state;
    private int zipcode;

   public Employee(String username, String email, String firstName, String lastName, boolean status,
                   int employeeId,
            int phone,
            String address,
            String city,
            String state,
            int zipcode) {
       super(username, email, firstName, lastName, status);
       this.employeeId = employeeId;
       this.phone = phone;
       this.address = address;
       this.city = city;
       this.state = state;
       this.zipcode = zipcode;
   }

    public int getPhone() {
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
}
