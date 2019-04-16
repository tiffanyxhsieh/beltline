package com.group51.beltline.repository;

import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    Collection<User> getAllUsers();

    @Query(value = "SELECT * FROM User WHERE Username=:username", nativeQuery = true)
    User getOneUser(@Param("username") String username);


    @Query(value = "SELECT * FROM User WHERE Username=?1 AND Password=?2 AND Status='Approved'", nativeQuery = true)
    User checkLogin(@Param("username") String username, @Param("password") String password);





}
