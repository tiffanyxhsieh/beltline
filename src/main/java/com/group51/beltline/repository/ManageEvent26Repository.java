package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.ManageEvent26;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ManageEvent26Repository extends JpaRepository<ManageEvent26, String> {

    @Query(value = "SELECT * FROM manage_event where (?1 is null or name = ?1) AND (?2 is null or StartDate = ?2) AND (?3 is null or SiteName = ?3) AND daily_visits between ?4 and ?5 AND daily_revenue between ?6 and ?7", nativeQuery = true)
    Collection<ManageEvent26> filter(@Param("Name") String name, @Param("StartDate") String startdate, @Param("SiteName") String sitename, @Param("lowdailyvisits") String lowdailyvisits, @Param("highdailyvisits") String highdailyvisits,@Param("lowdailyrevenue") String lowdailyrevenue,@Param("highdailyrevenue") String highdailyrevenue);
 
}