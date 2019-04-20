package com.group51.beltline.repository;

import com.group51.beltline.models.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface AdministratorRepository extends JpaRepository<Administrator, String> {
    @Query(value="SELECT * FROM Administrator", nativeQuery=true)
    Collection<Administrator> getAllAdministrators();

    @Query(value = "SELECT * FROM Administrator WHERE Username=?1", nativeQuery = true)
    Administrator getOneUser(@Param("username") String username);


}
