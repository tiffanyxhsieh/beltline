package com.group51.beltline.models.DTO;

import com.group51.beltline.models.compositekeys.manage_transitKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(manage_transitKey.class)
@Table(name="manage_transit")
public class Manage_transit {
    @Id
    @Column(name="route")
    private String route;

    @Id
    @Column(name="type")
    private String type;

    @Id
    @Column(name="price")
    private String price;

    @Id
    @Column(name="connected_sites")
    private String connected_sites;

    @Id
    @Column(name="transits_logged")
    private double transits_logged;

    public Manage_transit() {
    }

    public Manage_transit(String route, String type, String price, String connected_sites, double transits_logged) {
        this.route = route;
        this.type = type;
        this.price = price;
        this.connected_sites = connected_sites;
        this.transits_logged = transits_logged;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getConnected_sites() {
        return this.connected_sites;
    }

    public void setConnected_sites(String connected_sites) {
        this.connected_sites = connected_sites;
    }

    public double getTransits_logged() {
        return this.transits_logged;
    }

    public void setTransits_logged(double transits_logged) {
        this.transits_logged = transits_logged;
    }

    public Manage_transit route(String route) {
        this.route = route;
        return this;
    }

    public Manage_transit type(String type) {
        this.type = type;
        return this;
    }

    public Manage_transit price(String price) {
        this.price = price;
        return this;
    }

    public Manage_transit connected_sites(String connected_sites) {
        this.connected_sites = connected_sites;
        return this;
    }

    public Manage_transit transits_logged(double transits_logged) {
        this.transits_logged = transits_logged;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manage_transit)) {
            return false;
        }
        Manage_transit manage_transit = (Manage_transit) o;
        return Objects.equals(route, manage_transit.route) && Objects.equals(type, manage_transit.type) && Objects.equals(price, manage_transit.price) && Objects.equals(connected_sites, manage_transit.connected_sites) && transits_logged == manage_transit.transits_logged;
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, type, price, connected_sites, transits_logged);
    }

    @Override
    public String toString() {
        return "{" +
            " route='" + getRoute() + "'" +
            ", type='" + getType() + "'" +
            ", price='" + getPrice() + "'" +
            ", connected_sites='" + getConnected_sites() + "'" +
            ", transits_logged='" + getTransits_logged() + "'" +
            "}";
    }

   
}