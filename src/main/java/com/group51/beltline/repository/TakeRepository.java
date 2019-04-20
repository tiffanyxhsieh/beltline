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

    //adds to "Take" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Take (Username, Type, Route, Date) VALUES (?1,?2,?3,?4)", nativeQuery = true)
    int createNewTake(@Param("username") String Username, @Param("type") String Type, @Param("route") String Route, @Param("date") String Date);

    // //edit a "Take"
    // @Modifying //current default for Status is 'Pending'
    // @Query(value = "update Take set Username=?1, Type=?2, Route=?3, Date=?4 Where Name=?1", nativeQuery = true)
    // int updateNewSite(@Param("Username") String Username, @Param("Type") String Type, @Param("Route") String Route, @Param("Date") String Date);

    // //delete a "Take"
    // @Modifying //current default for Status is 'Pending'
    // @Query(value = "delete from Site Where Name=?1", nativeQuery = true)
    // int deleteSite(@Param("Name") String Name);
}