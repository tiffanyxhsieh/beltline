package com.group51.beltline.models.DTO;

import com.group51.beltline.models.compositekeys.TransitHistoryKey;

import javax.persistence.*;

@Entity
@IdClass(TransitHistoryKey.class)
@Table(name="take_transit")
public class TransitHistory {
    @Id
    @Column(name="username")
    private String username;
    @Id
    @Column(name="date")
    private String date;
    @Id
    @Column(name="route")
    private String route;

    @Id
    @Column(name="type")
    private String type;
    @Id
    @Column(name="price")
    private double price;

    public TransitHistory() {}
    public TransitHistory(String username, String date, String route, String type, double price) {
        this.username = username;
        this.date = date;
        this.route = route;
        this.type = type;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
