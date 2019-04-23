package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import com.group51.beltline.models.StaffName;
import com.group51.beltline.models.User;
import com.group51.beltline.models.views.Screen29view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Screen29viewRepository extends JpaRepository<Screen29view, String> {
    @Query(value = "Select date, EventCount, NumEvents, TotalVisits, Revenue from site_report where manager=?1 AND date between ?2 and ?3 AND ((?4 is NULL or ?4 <= EventCount) AND (?5 is null or ?5 >= EventCount)) AND ((?6 is NULL or ?6 <= NumEvents) AND (?7 is null or ?7 >= NumEvents)) AND ((?8 is null or ?8 <= TotalVisits) AND (?9 is null or ?9 >= TotalVisits)) AND ((?10 is null or ?10 <= Revenue) AND (?11 is null or ?11 >= Revenue))", nativeQuery = true)
    Collection<Screen29view> filter(@Param("manager") String manager, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("eve_count_low") String eve_count_low, @Param("eve_count_high") String eve_count_high, @Param("staff_count_low") String staff_count_low, @Param("staff_count_high") String staff_count_high, @Param("total_visit_low") String total_visit_low, @Param("total_visit_high") String total_visit_high, @Param("total_rev_low") String total_rev_low, @Param("total_rev_high") String total_rev_high);

    // @Query(value = "Select date, EventCount, NumEvents, TotalVisits, Revenue from site_report where manager=?1", nativeQuery = true)
    // Collection<Screen29view> filter(@Param("manager") String manager);
}