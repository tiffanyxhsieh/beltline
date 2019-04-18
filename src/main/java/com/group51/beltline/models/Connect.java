package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.ConnectKey;

@Entity
@Table(name = "Connect")
@IdClass(ConnectKey.class)
public class Connect {
    @Id
    @Column(name="SiteName")
    private String siteName;
    @Id
    @Column(name="Type")
    private String type;
    @Id
    @Column(name="Route")
    private String route;

    public Connect() {
    }

    public Connect(String siteName, String type, String route) {
        this.siteName = siteName;
        this.type = type;
        this.route = route;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoute() {
        return this.route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Connect siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public Connect type(String type) {
        this.type = type;
        return this;
    }

    public Connect route(String route) {
        this.route = route;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Connect)) {
            return false;
        }
        Connect connect = (Connect) o;
        return Objects.equals(siteName, connect.siteName) && Objects.equals(type, connect.type) && Objects.equals(route, connect.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(siteName, type, route);
    }

    @Override
    public String toString() {
        return "{" +
            " siteName='" + getSiteName() + "'" +
            ", type='" + getType() + "'" +
            ", route='" + getRoute() + "'" +
            "}";
    }
}