package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Manage_eventKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Manage_eventKey.class)
@Table(name="manage_event")
public class Manage_event {
    // @Id
    // @Column(name="manager")
    // private String manager;

    @Id
    @Column(name="name")
    private String name;

    @Id
    @Column(name="CountStaff")
    private String CountStaff;

    @Id
    @Column(name="Duration")
    private String Duration;

    @Id
    @Column(name="TotalVisits")
    private String TotalVisits;

    @Id
    @Column(name="TotalRevenue")
    private double TotalRevenue;

    public Manage_event() {
    }

    public Manage_event(String name, String CountStaff, String Duration, String TotalVisits, double TotalRevenue) {
        this.name = name;
        this.CountStaff = CountStaff;
        this.Duration = Duration;
        this.TotalVisits = TotalVisits;
        this.TotalRevenue = TotalRevenue;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountStaff() {
        return this.CountStaff;
    }

    public void setCountStaff(String CountStaff) {
        this.CountStaff = CountStaff;
    }

    public String getDuration() {
        return this.Duration;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public String getTotalVisits() {
        return this.TotalVisits;
    }

    public void setTotalVisits(String TotalVisits) {
        this.TotalVisits = TotalVisits;
    }

    public double getTotalRevenue() {
        return this.TotalRevenue;
    }

    public void setTotalRevenue(double TotalRevenue) {
        this.TotalRevenue = TotalRevenue;
    }

    public Manage_event name(String name) {
        this.name = name;
        return this;
    }

    public Manage_event CountStaff(String CountStaff) {
        this.CountStaff = CountStaff;
        return this;
    }

    public Manage_event Duration(String Duration) {
        this.Duration = Duration;
        return this;
    }

    public Manage_event TotalVisits(String TotalVisits) {
        this.TotalVisits = TotalVisits;
        return this;
    }

    public Manage_event TotalRevenue(double TotalRevenue) {
        this.TotalRevenue = TotalRevenue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manage_event)) {
            return false;
        }
        Manage_event manage_event = (Manage_event) o;
        return Objects.equals(name, manage_event.name) && Objects.equals(CountStaff, manage_event.CountStaff) && Objects.equals(Duration, manage_event.Duration) && Objects.equals(TotalVisits, manage_event.TotalVisits) && TotalRevenue == manage_event.TotalRevenue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, CountStaff, Duration, TotalVisits, TotalRevenue);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", CountStaff='" + getCountStaff() + "'" +
            ", Duration='" + getDuration() + "'" +
            ", TotalVisits='" + getTotalVisits() + "'" +
            ", TotalRevenue='" + getTotalRevenue() + "'" +
            "}";
    }

    
}