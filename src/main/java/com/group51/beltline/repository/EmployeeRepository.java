package com.group51.beltline.repository;

import com.group51.beltline.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value="SELECT * FROM Employee", nativeQuery=true)
    Collection<Employee> getAllEmployees();



    @Modifying
    @Query(value="update User set Firstname=?1 where Username=?2", nativeQuery = true)
    int updateEmployeeFirstName(@Param("firstName") String firstName,
                                @Param("username") String username
    );

    @Modifying
    @Query(value="update User set Lastname=?1 where Username=?2", nativeQuery = true)
    int updateEmployeeLastName(@Param("lastName") String lastName,
                               @Param("username") String username);

    @Modifying
    @Query(value="update Employee set Phone=?1 where Username=?2", nativeQuery = true)
    int updateEmployeePhone(@Param("phone") String lastName,
                            @Param("username") String username);

    @Modifying
    @Query(value="insert into Employee (Username,EmployeeID, Phone, Address, City, State, Zipcode) VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    int createNewEmployee(@Param("username") String username,
                          @Param("employeeId") int employeeid,
                          @Param("phone") long phone,
                          @Param("address") String address,
                          @Param("city") String city,
                          @Param("state") String state,
                          @Param("zipcode") int zipcode
                          );




}
