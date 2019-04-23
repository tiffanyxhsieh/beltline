package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Screen29viewKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Screen29viewKey.class)
@Table(name="Screen29view")
public class Screen29view {

    @Id
    @Column(name="date")
    private String date;

    @Id
    @Column(name="EventCount")
    private String EventCount;

    @Id
    @Column(name="NumEvents")
    private String NumEvents;

    @Id
    @Column(name="TotalVisits")
    private String TotalVisits;

    @Id
    @Column(name="Revenue")
    private double Revenue;

    public Screen29view() {
    }

    public Screen29view(String date, String EventCount, String NumEvents, String TotalVisits, double Revenue) {
        this.date = date;
        this.EventCount = EventCount;
        this.NumEvents = NumEvents;
        this.TotalVisits = TotalVisits;
        this.Revenue = Revenue;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEventCount() {
        return this.EventCount;
    }

    public void setEventCount(String EventCount) {
        this.EventCount = EventCount;
    }

    public String getNumEvents() {
        return this.NumEvents;
    }

    public void setNumEvents(String NumEvents) {
        this.NumEvents = NumEvents;
    }

    public String getTotalVisits() {
        return this.TotalVisits;
    }

    public void setTotalVisits(String TotalVisits) {
        this.TotalVisits = TotalVisits;
    }

    public double getRevenue() {
        return this.Revenue;
    }

    public void setRevenue(double Revenue) {
        this.Revenue = Revenue;
    }

    public Screen29view date(String date) {
        this.date = date;
        return this;
    }

    public Screen29view EventCount(String EventCount) {
        this.EventCount = EventCount;
        return this;
    }

    public Screen29view NumEvents(String NumEvents) {
        this.NumEvents = NumEvents;
        return this;
    }

    public Screen29view TotalVisits(String TotalVisits) {
        this.TotalVisits = TotalVisits;
        return this;
    }

    public Screen29view Revenue(double Revenue) {
        this.Revenue = Revenue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Screen29view)) {
            return false;
        }
        Screen29view screen29view = (Screen29view) o;
        return Objects.equals(date, screen29view.date) && Objects.equals(EventCount, screen29view.EventCount) && Objects.equals(NumEvents, screen29view.NumEvents) && Objects.equals(TotalVisits, screen29view.TotalVisits) && Revenue == screen29view.Revenue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, EventCount, NumEvents, TotalVisits, Revenue);
    }

    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", EventCount='" + getEventCount() + "'" +
            ", NumEvents='" + getNumEvents() + "'" +
            ", TotalVisits='" + getTotalVisits() + "'" +
            ", Revenue='" + getRevenue() + "'" +
            "}";
    }

   
}