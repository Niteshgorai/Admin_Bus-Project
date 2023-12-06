package org.jpa.AdminBusApp.repository;

import java.util.List;
import java.util.Optional;

import org.jpa.AdminBusApp.dto.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BusRepository extends JpaRepository<Bus, Integer>{

	@Query("select l from Bus l where l.date_of_departure=?1 and l.from_location=?2 and l.to_location=?3" )
	Optional<Bus> findByloc(String date_of_departure, String from_location, String  to_location);
	
	@Query("select b from Bus b where b.bus_number=?1")
	Optional<Bus> findBusBybusNo(String bus_number);
	@Query("select i from Bus i where i.admin.id=?1")
	List<Bus> findBusByAdminid(int admin_id);
	@Query("select t from Bus t where t.admin.travels_name=?1")
	List<Bus> findBusByTravelName(String travels_name);
	@Query("select d from Bus d where d.date_of_departure=?1")
	List<Bus> findBusdate(String date_of_departure);
}
