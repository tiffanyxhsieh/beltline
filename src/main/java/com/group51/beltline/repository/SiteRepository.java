package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SiteRepository extends JpaRepository<Site, String> {

    @Query(value = "SELECT Name FROM Site", nativeQuery = true)
    Collection<Site> getAllSites();

    // @Query(value = "SELECT * FROM User WHERE Username=:username", nativeQuery = true)
    // User getOneUser(@Param("username") String username);


    // @Query(value = "SELECT * FROM User WHERE Username=?1 AND Password=?2 AND Status='Approved'", nativeQuery = true)
    // User checkLogin(@Param("username") String username, @Param("password") String password);

    // //adds to "User" table
    // @Modifying //current default for Status is 'Pending'
    // @Query(value = "insert into User (Firstname,Lastname, Username, Status, Password) VALUES (?1,?2,?3, 'Pending' ,?4)", nativeQuery = true)
    // int createNewUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username, @Param("password") String password);

}