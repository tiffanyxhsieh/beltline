package com.group51.beltline.repository;

import com.group51.beltline.models.Visit_Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface VisitSiteRepository extends JpaRepository<Visit_Site, String> {

    @Query(value = "SELECT * FROM Visit_Site", nativeQuery = true)
    Collection<Visit_Site> getAllVisitSites();
}