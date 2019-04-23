package com.group51.beltline.repository;

import com.group51.beltline.models.Site;
import com.group51.beltline.models.StaffName;
import com.group51.beltline.models.User;
import com.group51.beltline.models.views.Screen33view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface Screen33viewRepository extends JpaRepository<Screen33view, String> {

    // @Query(value = "select t1.name,t1.sitename, t1.price, t1.ticket_rem, t1.total_visits, t2.my_visits from (select distinct (e.capacity - count(*)) as ticket_rem, count(*) as total_visits, e.capacity, e.name,e.sitename, e.price, e.startdate from event as e join visit_event as v on e.name=v.name and e.sitename=v.sitename and e.startdate=v.startdate group by e.name, e.sitename, e.price,e.capacity, e.startdate) as t1, (select distinct count(*) as my_visits, e.capacity, e.name,e.sitename, e.price, e.startdate from event as e join visit_event as v on e.name=v.name and e.sitename=v.sitename and e.startdate=v.startdate where v.username=?1 AND (?2 is NULL or e.name like concat('%', ?2,'%')) AND (?3 is NULL or e.description like concat('%', ?3,'%')) AND (?4 is NULL or e.sitename like concat('%', ?4,'%')) AND (e.startdate between ?5 and ?6) AND (e.enddate between ?5 and ?6) group by e.name, e.sitename, e.price, e.capacity, e.startdate) as t2 where t1.name=t2.name AND t1.sitename=t2.sitename AND (?7 is NULL or (?7=0) or (?7=1 AND t2.my_visits != 0)) AND (?8 is NULL or (?8=0 AND t1.ticket_rem != 0) or (?8=1))", nativeQuery = true)
    // Collection<Screen33view> filter(@Param("username") String username, @Param("name") String name, @Param("keyword") String keyword, @Param("sitename") String sitename, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("visited") Integer visited, @Param("soldout") Integer soldout);

    @Query(value = "select name, sitename, price, TicketsRem, TotalVisits, MyVisits from explore_event where username=?1 AND (?2 is NULL or name like concat('%', ?2,'%')) AND (?3 is NULL or description like concat('%', ?3,'%')) AND (?4 is NULL or sitename like concat('%', ?4,'%')) AND (startdate between ?5 and ?6) AND (enddate between ?5 and ?6) AND (?7 is NULL or (?7=0) or (?7=1 AND MyVisits != 0)) AND (?8 is NULL or (?8=0 AND TicketsRem != 0) or (?8=1))", nativeQuery = true)
    Collection<Screen33view> filter(@Param("username") String username, @Param("name") String name, @Param("keyword") String keyword, @Param("sitename") String sitename, @Param("startdate") String startdate, @Param("enddate") String enddate, @Param("visited") Integer visited, @Param("soldout") Integer soldout);


}