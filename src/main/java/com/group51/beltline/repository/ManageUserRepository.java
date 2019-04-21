package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.ManageUser;
import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ManageUserRepository extends JpaRepository<ManageUser, String> {

    @Query(value="select * from manage_user " +
            "where ?1 IS NULL OR username like CONCAT(?1,'%') " +
            "AND ?2 IS NULL OR usertype = ?2 " +
            "AND ?3 IS NULL OR status = ?3", nativeQuery = true)
    Collection<ManageUser> adminManageUserFilter(@Param("username") String username, @Param("status") String status, @Param("type") String type);

}
