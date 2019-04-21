package com.group51.beltline.repository;

import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository extends JpaRepository<User, String> {
//SELECT User.Username, User.Firstname, User.Lastname, User.Password,
    @Query(value = "SELECT * FROM User", nativeQuery = true)
    Collection<User> getAll();

    @Query(value = "SELECT * FROM User WHERE Username=:username", nativeQuery = true)
    User getOneUser(@Param("username") String username);


    @Query(value = "SELECT exists e.email, u.password FROM Email WHERE Email=?1 AND Password=?2 AND Status='Approved'", nativeQuery = true)
    User checkLogin(@Param("username") String username, @Param("password") String password);


    //adds to "User" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into User (Firstname,Lastname, Username, Status, Password) VALUES (?1,?2,?3, 'Pending' ,?4)", nativeQuery = true)
    int createNewUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("username") String username, @Param("password") String password);



    @Modifying
    @Query(value = "UPDATE User SET Status = 'Approved' WHERE Username=?1")
    int approveUser(@Param("username")String username);


    @Modifying
    @Query(value = "UPDATE User SET status = 'Declined' WHERE Username=?1")
    int declineUser(@Param("username")String username);

    @Query(value="SELECT COUNT(Username) from User where Username=?1")
    int usernameExists(@Param("username") String username);

    @Query(value="SELECT COUNT(Phone) from Employee where Phone=?1")
    int phoneExists(@Param("phone") String phone);



}
