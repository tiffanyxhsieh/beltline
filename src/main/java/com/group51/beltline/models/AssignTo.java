package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.AssignToKey;

@Entity
@IdClass(AssignToKey.class)
@Table(name = "Assign_to")
public class AssignTo {
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

    public AssignTo() {
    }

    public AssignTo(String username, String name, String startDate, String siteName) {
        this.username = username;
        this.name = name;
        this.startDate = startDate;
        this.siteName = siteName;
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

    public AssignTo username(String username) {
        this.username = username;
        return this;
    }

    public AssignTo name(String name) {
        this.name = name;
        return this;
    }

    public AssignTo startDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public AssignTo siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AssignTo)) {
            return false;
        }
        AssignTo assign_to = (AssignTo) o;
        return Objects.equals(username, assign_to.username) && Objects.equals(name, assign_to.name) && Objects.equals(startDate, assign_to.startDate) && Objects.equals(siteName, assign_to.siteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, startDate, siteName);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", name='" + getName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", siteName='" + getSiteName() + "'" +
            "}";
    }

}