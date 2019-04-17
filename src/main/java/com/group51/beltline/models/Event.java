package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.EventKey;

@Entity
@Table(name = "Event")
@IdClass(EventKey.class)
public class Event {
    @Id
    @Column(name="Name")
    private String name;
    @Id
    @Column(name="StartDate")
    private String startDate;
    @Id
    @Column(name="SiteName")
    private String siteName;

    @Column(name="EndDate")
    private String endDate;

    @Column(name="Price")
    private Double price;

    @Column(name="Capacity")
    private int capacity;

    @Column(name="MinStaffReq")
    private int minStaffReq;

    @Column(name="Description")
    private String description;

    public Event() {
    }

    public Event(String name, String startDate, String siteName, String endDate, Double price, int capacity, int minStaffReq, String description) {
        this.name = name;
        this.startDate = startDate;
        this.siteName = siteName;
        this.endDate = endDate;
        this.price = price;
        this.capacity = capacity;
        this.minStaffReq = minStaffReq;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getMinStaffReq() {
        return this.minStaffReq;
    }

    public void setMinStaffReq(int minStaffReq) {
        this.minStaffReq = minStaffReq;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Event name(String name) {
        this.name = name;
        return this;
    }

    public Event startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public Event siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public Event endDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Event price(Double price) {
        this.price = price;
        return this;
    }

    public Event capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Event minStaffReq(int minStaffReq) {
        this.minStaffReq = minStaffReq;
        return this;
    }

    public Event description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Event)) {
            return false;
        }
        Event event = (Event) o;
        return Objects.equals(name, event.name) && Objects.equals(startDate, event.startDate) && Objects.equals(siteName, event.siteName) && Objects.equals(endDate, event.endDate) && Objects.equals(price, event.price) && capacity == event.capacity && minStaffReq == event.minStaffReq && Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startDate, siteName, endDate, price, capacity, minStaffReq, description);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", siteName='" + getSiteName() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", price='" + getPrice() + "'" +
            ", capacity='" + getCapacity() + "'" +
            ", minStaffReq='" + getMinStaffReq() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }


}