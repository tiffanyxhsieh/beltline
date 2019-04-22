package com.group51.beltline.models.views;

import com.group51.beltline.models.compositekeys.Manage_staffKey;

import java.util.Objects;

import javax.persistence.*;

@Entity
@IdClass(Manage_staffKey.class)
@Table(name="Manage_staff")
public class Manage_staff {

    @Id
    @Column(name="staff_name")
    private String staff_name;

    @Id
    @Column(name="num_event_shifts")
    private String num_event_shifts;

    public Manage_staff() {
    }

    public Manage_staff(String staff_name, String num_event_shifts) {
        this.staff_name = staff_name;
        this.num_event_shifts = num_event_shifts;
    }

    public String getStaff_name() {
        return this.staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getNum_event_shifts() {
        return this.num_event_shifts;
    }

    public void setNum_event_shifts(String num_event_shifts) {
        this.num_event_shifts = num_event_shifts;
    }

    public Manage_staff staff_name(String staff_name) {
        this.staff_name = staff_name;
        return this;
    }

    public Manage_staff num_event_shifts(String num_event_shifts) {
        this.num_event_shifts = num_event_shifts;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Manage_staff)) {
            return false;
        }
        Manage_staff manage_staff = (Manage_staff) o;
        return Objects.equals(staff_name, manage_staff.staff_name) && Objects.equals(num_event_shifts, manage_staff.num_event_shifts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff_name, num_event_shifts);
    }

    @Override
    public String toString() {
        return "{" +
            " staff_name='" + getStaff_name() + "'" +
            ", num_event_shifts='" + getNum_event_shifts() + "'" +
            "}";
    }

}