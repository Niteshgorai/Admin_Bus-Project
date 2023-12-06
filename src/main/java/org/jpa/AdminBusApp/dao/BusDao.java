package org.jpa.AdminBusApp.dao;

import java.util.List;
import java.util.Optional;

import org.jpa.AdminBusApp.dto.Bus;
import org.jpa.AdminBusApp.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDao {

	@Autowired
	private BusRepository busrepository;
	
	public Bus saveBus(Bus bus) {
		return busrepository.save(bus);
	}
	
	public Optional<Bus> findById(int id) {
		return busrepository.findById(id);
	}
	
	public Optional<Bus> findByloc(String date_of_departure, String from_location, String to_location){
		return busrepository.findByloc(date_of_departure, from_location, to_location);
	}

	public Optional<Bus> findBusBybusNo(String bus_number) {
		return busrepository.findBusBybusNo(bus_number);
	}

	public List<Bus> findBusByAdminid(int admin_id) {
		return busrepository.findBusByAdminid(admin_id);
	}

	public List<Bus> findBusByTravelName(String travels_name) {
		return busrepository.findBusByTravelName(travels_name);
	}

	public List<Bus> findBusdate(String date_of_departure) {
		return busrepository.findBusdate(date_of_departure);
	}


	
	
//	public Bus updateBus(Bus bus) {
//		return busrepository.save(bus);
//	}
	
}
