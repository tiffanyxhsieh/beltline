package com.group51.beltline.repository;

import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {

    @Query(value = "SELECT * FROM User", nativeQuery = true)
    Collection<User> getAllUsers();

    //TODO:fix this b/c it doesn't recognize usernames w/ dots
    @Query(value = "SELECT * FROM User WHERE Username=:username", nativeQuery = true)
    User getOneUser(@Param("username") String username);




}
