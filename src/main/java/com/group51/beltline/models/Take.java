package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.TakeKey;

@Entity
@Table(name = "Take")
@IdClass(TakeKey.class)
public class Take {
    @Id
    @Column(name="Username")
    private String username;
    @Id
    @Column(name="Type")
    private String type;
    @Id
    @Column(name="Route")
    private String route;
    @Id
    @Column(name="Date")
    private String date;

    public Take() {
    }

    public Take(String username, String type, String route, String date) {
        this.username = username;
        this.type = type;
        this.route = route;
        this.date = date;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Take username(String username) {
        this.username = username;
        return this;
    }

    public Take type(String type) {
        this.type = type;
        return this;
    }

    public Take route(String route) {
        this.route = route;
        return this;
    }

    public Take date(String date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Take)) {
            return false;
        }
        Take take = (Take) o;
        return Objects.equals(username, take.username) && Objects.equals(type, take.type) && Objects.equals(route, take.route) && Objects.equals(date, take.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, type, route, date);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", type='" + getType() + "'" +
            ", route='" + getRoute() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }

}