package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.ManageEvent26Key;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(ManageEvent26Key.class)
@Table(name="ManageEvent26")
public class ManageEvent26 {

    @Id
    @Column(name="date")
    private String date;

    @Id
    @Column(name="daily_visits")
    private String daily_visits;

    @Id
    @Column(name="daily_revenue")
    private String daily_revenue;

    public ManageEvent26() {
    }

    public ManageEvent26(String date, String daily_visits, String daily_revenue) {
        this.date = date;
        this.daily_visits = daily_visits;
        this.daily_revenue = daily_revenue;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDaily_visits() {
        return this.daily_visits;
    }

    public void setDaily_visits(String daily_visits) {
        this.daily_visits = daily_visits;
    }

    public String getDaily_revenue() {
        return this.daily_revenue;
    }

    public void setDaily_revenue(String daily_revenue) {
        this.daily_revenue = daily_revenue;
    }

    public ManageEvent26 date(String date) {
        this.date = date;
        return this;
    }

    public ManageEvent26 daily_visits(String daily_visits) {
        this.daily_visits = daily_visits;
        return this;
    }

    public ManageEvent26 daily_revenue(String daily_revenue) {
        this.daily_revenue = daily_revenue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ManageEvent26)) {
            return false;
        }
        ManageEvent26 manageEvent26 = (ManageEvent26) o;
        return Objects.equals(date, manageEvent26.date) && Objects.equals(daily_visits, manageEvent26.daily_visits) && Objects.equals(daily_revenue, manageEvent26.daily_revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, daily_visits, daily_revenue);
    }

    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", daily_visits='" + getDaily_visits() + "'" +
            ", daily_revenue='" + getDaily_revenue() + "'" +
            "}";
    }
}