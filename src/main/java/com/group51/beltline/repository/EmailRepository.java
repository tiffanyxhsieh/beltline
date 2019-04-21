package com.group51.beltline.repository;

import com.group51.beltline.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface EmailRepository extends JpaRepository<Email, String> {
    @Query(value="SELECT distinct * FROM Email", nativeQuery=true)
    Collection<Email> getAllEmails();

    @Query(value="SELECT * FROM Email where Username=?1", nativeQuery = true)
    Collection<Email> getAllUserEmails(@RequestParam("username") String username);
}
