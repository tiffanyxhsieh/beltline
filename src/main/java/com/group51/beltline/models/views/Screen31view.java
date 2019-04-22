package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Screen31viewKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Screen31viewKey.class)
@Table(name="manage_event")
public class Screen31view {

    @Id
    @Column(name="name")
    private String name;

    @Id
    @Column(name="sitename")
    private String sitename;

    @Id
    @Column(name="startdate")
    private String startdate;

    @Id
    @Column(name="enddate")
    private String enddate;

    @Id
    @Column(name="staff_count")
    private double staff_count;

    public Screen31view() {
    }

    public Screen31view(String name, String sitename, String startdate, String enddate, double staff_count) {
        this.name = name;
        this.sitename = sitename;
        this.startdate = startdate;
        this.enddate = enddate;
        this.staff_count = staff_count;
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

    public String getStartdate() {
        return this.startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return this.enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public double getStaff_count() {
        return this.staff_count;
    }

    public void setStaff_count(double staff_count) {
        this.staff_count = staff_count;
    }

    public Screen31view name(String name) {
        this.name = name;
        return this;
    }

    public Screen31view sitename(String sitename) {
        this.sitename = sitename;
        return this;
    }

    public Screen31view startdate(String startdate) {
        this.startdate = startdate;
        return this;
    }

    public Screen31view enddate(String enddate) {
        this.enddate = enddate;
        return this;
    }

    public Screen31view staff_count(double staff_count) {
        this.staff_count = staff_count;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Screen31view)) {
            return false;
        }
        Screen31view screen31view = (Screen31view) o;
        return Objects.equals(name, screen31view.name) && Objects.equals(sitename, screen31view.sitename) && Objects.equals(startdate, screen31view.startdate) && Objects.equals(enddate, screen31view.enddate) && staff_count == screen31view.staff_count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sitename, startdate, enddate, staff_count);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", sitename='" + getSitename() + "'" +
            ", startdate='" + getStartdate() + "'" +
            ", enddate='" + getEnddate() + "'" +
            ", staff_count='" + getStaff_count() + "'" +
            "}";
    }
}