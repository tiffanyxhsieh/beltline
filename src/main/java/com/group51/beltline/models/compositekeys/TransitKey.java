package com.group51.beltline.models.compositekeys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class TransitKey implements Serializable {
    private String type;
    private String route;
 }

// @Embeddable
// public class TransitKey implements Serializable {

//     @Column(name="Type", nullable = false)
//     private String type;

//     // need to figure out how to do composite key
//     @Column(name="Route", nullable = false)
//     private String route;

//     /** getters and setters **/
//     public String getType() {
//         return type;
//     }

//     public void setType(String type) {
//         this.type = type;
//     }


//     public String getRoute() {
//         return route;
//     }

//     public void setRoute(String route) {
//         this.route = route;
//     }
// }