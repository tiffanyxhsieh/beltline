package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Daily_detailKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Daily_detailKey.class)
@Table(name="Daily_detail")
public class Daily_detail {
    // @Id
    // @Column(name="manager")
    // private String manager;

    @Id
    @Column(name="username")
    private String username;

    @Id
    @Column(name="event")
    private String event;

    @Id
    @Column(name="total_daily_visits")
    private String total_daily_visits;

    @Id
    @Column(name="total_revenue")
    private String total_revenue;

    public Daily_detail() {
    }

    public Daily_detail(String username, String event, String total_daily_visits, String total_revenue) {
        this.username = username;
        this.event = event;
        this.total_daily_visits = total_daily_visits;
        this.total_revenue = total_revenue;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvent() {
        return this.event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getTotal_daily_visits() {
        return this.total_daily_visits;
    }

    public void setTotal_daily_visits(String total_daily_visits) {
        this.total_daily_visits = total_daily_visits;
    }

    public String getTotal_revenue() {
        return this.total_revenue;
    }

    public void setTotal_revenue(String total_revenue) {
        this.total_revenue = total_revenue;
    }

    public Daily_detail username(String username) {
        this.username = username;
        return this;
    }

    public Daily_detail event(String event) {
        this.event = event;
        return this;
    }

    public Daily_detail total_daily_visits(String total_daily_visits) {
        this.total_daily_visits = total_daily_visits;
        return this;
    }

    public Daily_detail total_revenue(String total_revenue) {
        this.total_revenue = total_revenue;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Daily_detail)) {
            return false;
        }
        Daily_detail daily_detail = (Daily_detail) o;
        return Objects.equals(username, daily_detail.username) && Objects.equals(event, daily_detail.event) && Objects.equals(total_daily_visits, daily_detail.total_daily_visits) && Objects.equals(total_revenue, daily_detail.total_revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, event, total_daily_visits, total_revenue);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", event='" + getEvent() + "'" +
            ", total_daily_visits='" + getTotal_daily_visits() + "'" +
            ", total_revenue='" + getTotal_revenue() + "'" +
            "}";
    }

}