package com.group51.beltline.repository;

import com.group51.beltline.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM Event", nativeQuery = true)
    Collection<Event> getAllEvents();
}