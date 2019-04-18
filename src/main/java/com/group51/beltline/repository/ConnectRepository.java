package com.group51.beltline.repository;

import com.group51.beltline.models.Connect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ConnectRepository extends JpaRepository<Connect, String> {

    @Query(value = "SELECT * FROM Connect", nativeQuery = true)
    Collection<Connect> getAllConnects();
}