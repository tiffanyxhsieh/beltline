package com.group51.beltline.repository;

import com.group51.beltline.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.Collection;

public interface EmailRepository extends JpaRepository<Email, String> {
    @Query(value="SELECT * FROM Email", nativeQuery=true)
    Collection<Email> getAllEmails();

    @Query(value="SELECT * FROM Email where Username=?1", nativeQuery = true)
    Collection<Email> getAllUserEmails(@RequestParam("username") String Username);

    @Modifying
    @Query(value="INSERT Email(Username, EmailAddress) VALUES(?1,?2)", nativeQuery = true)
    int addNewEmail(@Param("username")String username, @Param("email") String email);
}
