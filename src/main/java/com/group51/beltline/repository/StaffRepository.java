package com.group51.beltline.repository;

import com.group51.beltline.models.Staff;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query(value = "SELECT * FROM Staff", nativeQuery = true)
    Collection<Staff> getAllStaff();


    // @Modifying
    // @Query(value = "insert into Staff (Username) VALUES (?1)", nativeQuery=true)
    // int addStaff(@Param("username") String username);
    //delete a "Staff"
    // @Modifying
    // @Query(value = "delete from Staff Where Username=?1", nativeQuery = true)
    // int deleteStaff(@Param("Username") String username);

}
