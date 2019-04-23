package com.group51.beltline.repository;

import com.group51.beltline.models.Manager;
import com.group51.beltline.models.StaffName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ManagerRepository extends JpaRepository<Manager, String> {

    @Query(value = "SELECT * FROM Manager", nativeQuery = true)
    Collection<Manager> getAllManagers();

    // return name of all managers
    @Query(value = "SELECT distinct Concat(firstname, ' ', lastname) as name FROM user where username in (select username from manager)", nativeQuery = true)
    Collection<StaffName> getAllManagersName();

    @Modifying
    @Query(value = "insert into Manager (Username) VALUES (?1)", nativeQuery=true)
    int addManager(@Param("username") String username);


}
