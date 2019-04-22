package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.Manage_event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Manage_eventRepository extends JpaRepository<Manage_event, String> {
    
    // query all manage_event
    @Query(value = "SELECT name, CountStaff, Duration, TotalVisits, TotalRevenue FROM manager_event", nativeQuery = true)
    Collection<Manage_event> getAllManageEvent();

    @Query(value = "SELECT name, CountStaff, Duration, TotalVisits, TotalRevenue FROM manager_event where manager=?1", nativeQuery = true)
    Collection<Manage_event> getManageEventByManager(@Param("manager") String manager);
    
    // need to do test
    @Query(value = "SELECT name, CountStaff, Duration, TotalVisits, TotalRevenue FROM manager_event where (?1 IS NULL OR manager=?1) AND (?2 IS NULL OR Name like CONCAT('%', ?2, '%')) AND (?3 IS NULL OR Description like CONCAT('%', ?3, '%')) AND (?4 IS NULL OR StartDate >= ?4) AND (?5 IS NULL OR StartDate <= ?5) AND (?6 IS NULL OR Duration >= ?6) AND (?7 IS NULL OR Duration <= ?7) AND (?8 IS NULL OR TotalVisits >= ?8) AND (?9 IS NULL OR TotalVisits <= ?9) AND (?10 IS NULL OR TotalRevenue >= ?10) AND (?11 IS NULL OR TotalRevenue <= ?11) Order by name", nativeQuery = true)
    Collection<Manage_event> filter(@Param("manager") String manager, 
                                    @Param("name") String name,
                                    @Param("keyword") String keyword,
                                    @Param("start_date") String start_date,
                                    @Param("end_date") String end_date,
                                    @Param("dur_low") String dur_low,
                                    @Param("dur_high") String dur_high,
                                    @Param("total_visit_low") String total_visit_low,
                                    @Param("total_visit_high") String total_visit_high,
                                    @Param("total_rev_low") String total_rev_low,
                                    @Param("total_rev_high") String total_rev_high);
 
}