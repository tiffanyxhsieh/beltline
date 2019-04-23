package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, String> {

    @Query(value="select u.Firstname, u.Lastname, e.username, employeeid, phone, CONCAT(e.address,', ', e.city,', ', e.state, ' ',e.zipcode) as Address, site.name " +
            "from employee e " +
            "join user u on e.username = u.username " +
            "left join site on e.username = site.manager " +
            "where e.username = ?1", nativeQuery = true )
    EmployeeProfile getEmployeeProfile(@Param("username") String username);


}
