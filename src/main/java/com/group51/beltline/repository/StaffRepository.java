package com.group51.beltline.repository;

import com.group51.beltline.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface StaffRepository extends JpaRepository<Staff, String> {
    @Query(value = "SELECT * FROM Staff", nativeQuery = true)
    Collection<Staff> getAllStaff();

}
