package com.group51.beltline.models.DTO;

import com.group51.beltline.models.compositekeys.Take_TransitKey;

import javax.persistence.*;

@Entity
@IdClass(Take_TransitKey.class)
@Table(name="take_transit")
public class take_transit {
    @Id
    @Column(name="ConnectedSites")
    private int connectedSite;

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
    public take_transit(int connectedSites, String route, String type, double price){
        this.route = route;
        this.type = type;
        this.price = price;
        this.connectedSite =connectedSites;
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

    public int getConnectedSite() {
        return connectedSite;
    }

    public void setConnectedSite(int connectedSite) {
        this.connectedSite = connectedSite;
    }
}
