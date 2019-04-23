package com.group51.beltline.models.DTO;

import com.group51.beltline.models.compositekeys.VisitorHistoryKey;

import javax.persistence.*;


@Entity
@IdClass(VisitorHistoryKey.class)
@Table(name="visit_history")
public class VisitorHistory {

    @Id
    @Column(name="username")
    private  String username;
    @Id
    @Column(name="date")
    private String date;

    @Id
    @Column(name="event_name")
    private String event_name;


    @Column(name="sitename")
    private String sitename;


    @Column(name="price")
    private long price;

    public VisitorHistory() {}

    public VisitorHistory(String username, String date, String event_name, String sitename, long price){
        this.username = username;
        this.date = date;
        this.event_name = event_name;
        this.sitename = sitename;
        this.price=price;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSite_name(String site_name) {
        this.sitename = site_name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
