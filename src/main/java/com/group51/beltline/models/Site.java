package com.group51.beltline.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Site")
public class Site {
    @Id
    @Column(name="Name")
    private String name;

    @Column(name="Zipcode")
    private String zipcode;

    @Column(name="Address")
    private String address;

    @Column(name="OpenEveryday")
    private String openEveryday;

    @Column(name="Manager")
    private String manager;

    // public Site(String Name,
    //             String Zipcode,
    //             String Address,
    //             String OpenEveryday,
    //             String Manager) {
    //     this.Name = "";
    //     this.Zipcode = "";
    //     this.Address = "";
    //     this.OpenEveryday = "";
    //     this.Manager = "";
    //     }
    
    public Site() {}

    public Site(String name,
                String zipcode,
                String address,
                String openEveryday,
                String manager) {
        this.name = name;
        this.zipcode = zipcode;
        this.address = address;
        this.openEveryday = openEveryday;
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOpenEveryday() { return openEveryday;}

    public void setOpenEveryday(String openEveryday) {
        this.openEveryday = openEveryday;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
