package com.group51.beltline.repository;

import com.group51.beltline.models.DTO.ManageUser;
import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ManageUserRepository extends JpaRepository<ManageUser, String> {

    @Query(value="select * from manage_user where (?1 is NULL OR ?1='' OR username=?1) AND (?2 is null OR ?2='' OR status=?2) and (?3 is null OR ?3='' or usertype=?3)", nativeQuery = true)
    Collection<ManageUser> manageUserFilter(@Param("username") String username, @Param("status") String status, @Param("usertype") String usertype);


}
