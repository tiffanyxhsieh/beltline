package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.take_transit;
import com.group51.beltline.models.Take;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface Take_TransitRepository extends JpaRepository<take_transit, String> {
    @Query(value = "SELECT * FROM take_transit", nativeQuery = true)
    Collection<take_transit> getAlltake_transit();

}
