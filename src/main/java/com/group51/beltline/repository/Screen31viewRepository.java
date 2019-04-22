package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import com.group51.beltline.models.StaffName;
import com.group51.beltline.models.User;
import com.group51.beltline.models.views.Screen31view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Screen31viewRepository extends JpaRepository<Screen31view, String> {

    // get info for screen 31
    // "select  distinct a.name, a.sitename, a.startdate, e.enddate, count(*) as staff_count from assign_to a join event e on a.name = e.name and a.sitename = e.sitename and a.startdate = e.startdate group by a.name, a.sitename, a.startdate, e.enddate"


    @Query(value = "select  distinct a.name, a.sitename, a.startdate, e.enddate, count(*) as staff_count from assign_to a join event e on a.name = e.name and a.sitename = e.sitename and a.startdate = e.startdate WHERE (?1 is null or a.username=?1) AND (?2 is NULL or a.name like concat('%', ?2,'%')) AND (?3 is NULL OR e.description like concat('%', ?3,'%')) AND a.startdate between ?4 and ?5 AND e.enddate between ?4 and ?5 group by a.name, a.sitename, a.startdate, e.enddate", nativeQuery = true)
    Collection<Screen31view> filter(@Param("username") String username, @Param("name") String name, @Param("description") String description, @Param("start_date") String start_date, @Param("end_date") String end_date);

}