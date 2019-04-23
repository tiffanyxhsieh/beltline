package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import com.group51.beltline.models.StaffName;
import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

// DELIMITER $$
// USE `beltline`$$
// CREATE DEFINER=`root`@`localhost` PROCEDURE `av_staff`($startdate date,
// 						  $enddate date)
// BEGIN
// 	select distinct Concat(firstname, ' ', lastname) as available_staff from user where username not in 
// (select distinct username from assign_to as a join event as e on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename
// where e.startdate between $startdate and $enddate 
// or e.enddate between $startdate and $enddate );
// END$$

public interface StaffNameRepository extends JpaRepository<StaffName, String> {
    // @Query(value = "SELECT distinct Concat(firstname, ' ', lastname) as name FROM user where username not in (select distinct username from assign_to as a join event as e on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename where ((?1 is NULL OR e.startdate >= ?1) AND (?2 is NULL OR e.startdate <= ?2)) OR ((?1 is null OR e.enddate >= ?1) AND (?2 is NULL OR e.enddate <= ?2)))", nativeQuery = true)
    // Collection<StaffName> getAvStaff(@Param("start_date") String start_date, @Param("end_date") String end_date);

    @Query(value = "SELECT distinct Concat(firstname, ' ', lastname) as name FROM user where username not in (select distinct username from assign_to as a join event as e on e.name = a.name and e.startdate = a.startdate and e.sitename = a.sitename where e.startdate between ?1 and ?2 or e.enddate between ?1 and ?2)", nativeQuery = true)
    Collection<StaffName> getAvStaff(@Param("start_date") String start_date, @Param("end_date") String end_date);

       // get staffs who are assigned to an event
    // SELECT DISTINCT u.firstname,u.lastname FROM assign_to AS a JOIN user AS u ON a.username = u.username 
    // WHERE name = $eventname AND sitename =$sitename AND startdate = $startdate;
    @Query(value = "SELECT distinct Concat(firstname, ' ', lastname) FROM assign_to AS a JOIN user AS u ON a.username = u.username where (?1 IS NULL OR Name like CONCAT('%',?1,'%')) AND (?2 IS NULL OR Sitename like CONCAT('%',?2,'%')) AND (?1 IS NULL OR startdate like CONCAT('%',?3,'%'))", nativeQuery = true)
    Collection<StaffName> getAssignedStaff(@Param("eventname") String eventname, @Param("sitename") String sitename, @Param("startdate") String startdate);

}