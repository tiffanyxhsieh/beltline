package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import com.group51.beltline.models.views.Manage_transit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Manage_transitRepository extends JpaRepository<Manage_transit, String> {

    @Query(value = "SELECT * FROM manage_transit", nativeQuery = true)
    Collection<Manage_transit> getAllManageTransit();
 
}