package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.TransitDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Collection;

public interface TransitDetailRepository extends JpaRepository<TransitDetail, String> {

    @Transactional
    @Modifying
    @Query(value="drop view transit_detail", nativeQuery = true)
    void dropOldtransit_detailView();

    @Transactional
    @Modifying
    @Query(value="create view transit_detail as " +
            "select route,type,price,connected_sites(route,type) as " +
            "'connected_sites' from transit where sitename=?1", nativeQuery = true)
    void loadTransitDetail(@Param("sitename") String sitename);
}
