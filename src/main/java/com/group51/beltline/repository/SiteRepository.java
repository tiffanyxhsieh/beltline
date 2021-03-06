package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import com.group51.beltline.models.StaffName;
import com.group51.beltline.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SiteRepository extends JpaRepository<Site, String> {

    @Query(value = "SELECT * FROM Site", nativeQuery = true)
    Collection<Site> getAllSites();

    //selects all sites for a manayer
    @Query(value = "SELECT * FROM Site where manager=?1", nativeQuery = true)
    Collection<Site> getAllSitesByManager(@Param("manager") String manager);

    //select all unassigned managers for sites
    // Select distinct Concat(firstname, ' ', lastname) from user where username in (SELECT distinct username from manager where username not in (SELECT distinct name FROM Manager as m JOIN site AS s ON m.username = s.manager))
    @Query(value = "Select distinct Concat(firstname, ' ', lastname) from user where username in (SELECT distinct username from manager where username not in (SELECT distinct username FROM Manager as m JOIN site AS s ON m.username = s.manager)) ", nativeQuery = true)
    Collection<StaffName> getUnassignedManagers();

    @Query(value="SELECT * FROM Site where Manager=?1", nativeQuery = true)
    Site getSiteOfManager(@Param("username")String username);


    // filtering a site
    // double check name!
    @Query(value = 
            "SELECT * FROM Site where (?1 IS NULL OR Name like CONCAT('%',?1,'%')) AND (?2 IS NULL OR Zipcode=?2) AND (?3 IS NULL OR Address like CONCAT('%',?3,'%')) AND (?4 IS NULL OR OpenEveryday like CONCAT('%',?4,'%')) AND (?5 IS NULL OR Manager like CONCAT('%',?5,'%')) Order by Name"
            // "SELECT * FROM Site" + 
            // "where (?1 IS NULL OR Name = ?1)\n" +
            // "AND (?2 IS NULL OR Zipcode =?2)\n" +
            // "AND (?3 IS NULL OR Address =?3)\n" +
            // "AND (?4 IS NULL OR OpenEveryday =?4)\n" +
            // "AND (?5 IS NULL OR Manager=?5)"
            ,nativeQuery = true)
    Collection<Site> filter(@Param("Name") String Name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openEveryday, @Param("Manager") String manager);

    // select site by name
    @Query(value = "SELECT * FROM Site WHERE Name=:name", nativeQuery = true)
    Site getSiteByName(@Param("name") String name);

    //adds to "Site" table
    @Modifying //current default for Status is 'Pending'
    @Query(value = "insert into Site (Name, Zipcode, Address, OpenEveryday, Manager) VALUES (?1,?2,?3, ?4, ?5)", nativeQuery = true)
    int createNewSite(@Param("Name") String Name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openEveryday, @Param("Manager") String manager);

    //edit a "Site"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "update Site set Name=?1, Zipcode=?2, Address=?3, OpenEveryday=?4, Manager=?5 Where Name=?1", nativeQuery = true)
    int updateNewSite(@Param("Name") String Name, @Param("Zipcode") String zipcode, @Param("Address") String address, @Param("OpenEveryday") String openEveryday, @Param("Manager") String manager);

    //delete a "Site"
    @Modifying //current default for Status is 'Pending'
    @Query(value = "delete from Site Where Name=?1", nativeQuery = true)
    int deleteSite(@Param("Name") String Name);

    @Query(value = "Select Name from Site", nativeQuery = true)
    Collection<String> getSiteNames();
}