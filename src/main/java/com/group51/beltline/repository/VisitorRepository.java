package com.group51.beltline.repository;

import com.group51.beltline.models.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface VisitorRepository extends JpaRepository<Visitor, String> {

    @Query(value = "SELECT * FROM Visitor", nativeQuery = true)
    Collection<Visitor> getAllVisitors();
}
