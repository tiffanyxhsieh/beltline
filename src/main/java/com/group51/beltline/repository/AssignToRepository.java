package com.group51.beltline.repository;

import com.group51.beltline.models.AssignTo;
import com.group51.beltline.models.Visit_Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AssignToRepository extends JpaRepository<AssignTo, String> {

    @Query(value = "SELECT * FROM Assign_to", nativeQuery = true)
    Collection<AssignTo> getAllAssignTos();
}