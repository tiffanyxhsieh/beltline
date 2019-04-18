package com.group51.beltline.models;

import javax.persistence.Column;
// import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.TransitKey;

@Entity
@Table(name = "Transit")
@IdClass(TransitKey.class)
public class Transit {
    @Id
    @Column(name="Type", nullable = false)
    private String type;

    @Id
    @Column(name="Route", nullable = false)
    private String route;

    @Column(name="Price")
    private Double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}