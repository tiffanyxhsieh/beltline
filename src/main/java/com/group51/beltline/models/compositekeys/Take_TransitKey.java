package com.group51.beltline.models.compositekeys;

import java.io.Serializable;

public class Take_TransitKey implements Serializable {
    String route;
    String type;
    double price;
    int connectedSite;
}
