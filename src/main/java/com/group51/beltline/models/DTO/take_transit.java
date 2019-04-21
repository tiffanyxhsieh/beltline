package com.group51.beltline.models.DTO;

import com.group51.beltline.models.compositekeys.Take_TransitKey;

import javax.persistence.*;

@Entity
@IdClass(Take_TransitKey.class)
@Table(name="take_transit")
public class take_transit {
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

    public take_transit(){}
    public take_transit(String date, String route, String type, double price){
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
}
