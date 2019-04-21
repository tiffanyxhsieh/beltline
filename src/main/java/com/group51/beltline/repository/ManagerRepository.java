package com.group51.beltline.repository;

import com.group51.beltline.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ManagerRepository extends JpaRepository<Manager, String> {

    @Query(value = "SELECT * FROM Manager", nativeQuery = true)
    Collection<Manager> getAllManagers();

    @Modifying
    @Query(value = "insert into Manager (Username) VALUES (?1)", nativeQuery=true)
    int addManager(@Param("username") String username);


}
