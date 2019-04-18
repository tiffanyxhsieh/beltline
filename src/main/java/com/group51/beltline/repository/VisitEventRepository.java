package com.group51.beltline.repository;

import com.group51.beltline.models.Visit_Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface VisitEventRepository extends JpaRepository<Visit_Event, String> {

    @Query(value = "SELECT * FROM Visit_Event", nativeQuery = true)
    Collection<Visit_Event> getAllVisitEvents();
}