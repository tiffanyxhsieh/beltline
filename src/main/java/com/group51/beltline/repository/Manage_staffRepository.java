package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Manage_staffRepository extends JpaRepository<Manage_staff, String> {

    // select info for screen 28
    // "select concat(u.firstname,' ',u.lastname) as staff_name,count(a.name) as num_event_shifts from assign_to as a join event as e 
    // on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename 
    // join user as u on a.username =u.username
    // where (a.startdate between $startdate and $enddate 
    // or e.enddate between :startdate and :enddate)
    // and a.username in (select username from shift_sites where sitename = :sitename)
    // group by a.username"

    @Query(value = "select concat(u.firstname,' ',u.lastname) as staff_name,count(a.name) as num_event_shifts from assign_to as a join event as e on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename join user as u on a.username =u.username where (a.startdate between :startdate and :enddate or e.enddate between :startdate and :enddate) and (:firstname is null or u.firstname=:firstname) and (:lastname is null or u.lastname=:lastname) and a.username in (select username from assign_to where (:sitename is null or sitename = :sitename)) group by a.username", nativeQuery = true)
    Collection<Manage_staff> filter(@Param("startdate") String startdate, 
    @Param("enddate") String enddate,
    @Param("sitename") String sitename, @Param("firstname") String firstname, @Param("lastname") String lastname);

    // @Query(value = "select concat(u.firstname,' ',u.lastname) as staff_name,count(a.name) as num_event_shifts from assign_to as a join event as e on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename join user as u on a.username =u.username where (?1 is null or a.startdate >= ?1) and (?2 is null or a.startdate <= ?2) group by a.username", nativeQuery = true)
    // Collection<Manage_staff> filter(@Param("startdate") String startdate, 
    // @Param("enddate") String enddate);

 
}