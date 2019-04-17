package com.group51.beltline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
// import com.group51.beltline.models.compositekey.TransitCompositeKey;


@Entity
@Table(name = "Transit")
// @IdClass(TransitCompositeKey.class)
public class Transit {
    
    @Column(name="Type")
    @Id private String type;

    // need to figure out how to do composite key
    @Column(name="Route")
    private String route;

    @Column(name="Price")
    private Double price;

    public Transit() {}

    public Transit(String type,
                String route,
                Double price) {
        this.type = type;
        this.route = route;
        this.price = price;
    }

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