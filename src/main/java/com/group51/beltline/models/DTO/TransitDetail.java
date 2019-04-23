package com.group51.beltline.models.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transit_detail")
public class TransitDetail {

    @Id
    @Column(name="route")
    private String route;

    @Column(name="type")
    private String type;

    @Column(name="price")
    private long price;

    @Column(name="connected_sites")
    private String connected_sites;

    public TransitDetail(String route, String type, long price, String connected_sites){
        this.route = route;
        this.type = type;
        this.price = price;
        this.connected_sites = connected_sites;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getConnected_sites() {
        return connected_sites;
    }

    public void setConnected_sites(String connected_sites) {
        this.connected_sites = connected_sites;
    }
}
