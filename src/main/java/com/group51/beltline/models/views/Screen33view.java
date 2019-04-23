package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Screen33viewKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Screen33viewKey.class)
@Table(name="Screen33view")
public class Screen33view {
    // name, sitename, price, TicketsRem, TotalVisits, MyVisits
    @Id
    @Column(name="name")
    private String name;

    @Id
    @Column(name="sitename")
    private String sitename;

    @Id
    @Column(name="price")
    private String price;

    @Id
    @Column(name="TicketsRem")
    private String TicketsRem;

    @Id
    @Column(name="TotalVisits")
    private double TotalVisits;

    @Id
    @Column(name="MyVisits")
    private double MyVisits;

    public Screen33view() {
    }

    public Screen33view(String name, String sitename, String price, String TicketsRem, double TotalVisits, double MyVisits) {
        this.name = name;
        this.sitename = sitename;
        this.price = price;
        this.TicketsRem = TicketsRem;
        this.TotalVisits = TotalVisits;
        this.MyVisits = MyVisits;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSitename() {
        return this.sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTicketsRem() {
        return this.TicketsRem;
    }

    public void setTicketsRem(String TicketsRem) {
        this.TicketsRem = TicketsRem;
    }

    public double getTotalVisits() {
        return this.TotalVisits;
    }

    public void setTotalVisits(double TotalVisits) {
        this.TotalVisits = TotalVisits;
    }

    public double getMyVisits() {
        return this.MyVisits;
    }

    public void setMyVisits(double MyVisits) {
        this.MyVisits = MyVisits;
    }

    public Screen33view name(String name) {
        this.name = name;
        return this;
    }

    public Screen33view sitename(String sitename) {
        this.sitename = sitename;
        return this;
    }

    public Screen33view price(String price) {
        this.price = price;
        return this;
    }

    public Screen33view TicketsRem(String TicketsRem) {
        this.TicketsRem = TicketsRem;
        return this;
    }

    public Screen33view TotalVisits(double TotalVisits) {
        this.TotalVisits = TotalVisits;
        return this;
    }

    public Screen33view MyVisits(double MyVisits) {
        this.MyVisits = MyVisits;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Screen33view)) {
            return false;
        }
        Screen33view screen33view = (Screen33view) o;
        return Objects.equals(name, screen33view.name) && Objects.equals(sitename, screen33view.sitename) && Objects.equals(price, screen33view.price) && Objects.equals(TicketsRem, screen33view.TicketsRem) && TotalVisits == screen33view.TotalVisits && MyVisits == screen33view.MyVisits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sitename, price, TicketsRem, TotalVisits, MyVisits);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", sitename='" + getSitename() + "'" +
            ", price='" + getPrice() + "'" +
            ", TicketsRem='" + getTicketsRem() + "'" +
            ", TotalVisits='" + getTotalVisits() + "'" +
            ", MyVisits='" + getMyVisits() + "'" +
            "}";
    }

}