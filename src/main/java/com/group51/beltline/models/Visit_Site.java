package com.group51.beltline.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.group51.beltline.models.compositekeys.VisitSiteKey;

@Entity
@IdClass(VisitSiteKey.class)
@Table(name = "Visit_Site")
public class Visit_Site {
    @Id
    @Column(name="Username")
    private String username;
    @Id
    @Column(name="SiteName")
    private String siteName;
    @Id
    @Column(name="Date")
    private String Date;

    public Visit_Site() {
    }

    public Visit_Site(String username, String siteName, String Date) {
        this.username = username;
        this.siteName = siteName;
        this.Date = Date;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public Visit_Site username(String username) {
        this.username = username;
        return this;
    }

    public Visit_Site siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public Visit_Site Date(String Date) {
        this.Date = Date;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Visit_Site)) {
            return false;
        }
        Visit_Site visit_Site = (Visit_Site) o;
        return Objects.equals(username, visit_Site.username) && Objects.equals(siteName, visit_Site.siteName) && Objects.equals(Date, visit_Site.Date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, siteName, Date);
    }

    @Override
    public String toString() {
        return "{" +
            " username='" + getUsername() + "'" +
            ", siteName='" + getSiteName() + "'" +
            ", Date='" + getDate() + "'" +
            "}";
    }

}