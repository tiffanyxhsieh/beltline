package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.VisitEventKey;

@Entity
@IdClass(VisitEventKey.class)
@Table(name = "Visit_Event")
public class Visit_Event {
    @Id
    @Column(name="Username")
    private String username;
    @Id
    @Column(name="Name")
    private String name;
    @Id
    @Column(name="StartDate")
    private String startDate;
    @Id
    @Column(name="SiteName")
    private String siteName;
    @Id
    @Column(name="Date")
    private String date;

    public Visit_Event() {
    }

    public Visit_Event(String username, String name, String startDate, String siteName, String date) {
        this.username = username;
        this.name = name;
        this.startDate = startDate;
        this.siteName = siteName;
        this.date = date;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
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

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Visit_Event username(String username) {
        this.username = username;
        return this;
    }

    public Visit_Event name(String name) {
        this.name = name;
        return this;
    }

    public Visit_Event startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public Visit_Event siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public Visit_Event date(String date) {
        this.date = date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Visit_Event)) {
            return false;
        }
        Visit_Event visit_Event = (Visit_Event) o;
        return Objects.equals(username, visit_Event.username) && Objects.equals(name, visit_Event.name) && Objects.equals(startDate, visit_Event.startDate) && Objects.equals(siteName, visit_Event.siteName) && Objects.equals(date, visit_Event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, startDate, siteName, date);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", siteName='" + getSiteName() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}