package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.Daily_detail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Daily_detailRepository extends JpaRepository<Daily_detail, String> {
    // query daily_detail by user name
    @Query(value="SELECT * from daily_detail where username=?1", nativeQuery = true)
    Collection<Daily_detail> getDailyDetails(@Param("username") String username);
}