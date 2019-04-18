package com.group51.beltline.repository;

import com.group51.beltline.models.Take;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface TakeRepository extends JpaRepository<Take, String> {

    @Query(value = "SELECT * FROM Take", nativeQuery = true)
    Collection<Take> getAllTakes();
}