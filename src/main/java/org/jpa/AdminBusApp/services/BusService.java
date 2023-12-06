package org.jpa.AdminBusApp.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.jpa.AdminBusApp.dao.AdminDao;
import org.jpa.AdminBusApp.dao.BusDao;
import org.jpa.AdminBusApp.dto.Admin;
import org.jpa.AdminBusApp.dto.Bus;
import org.jpa.AdminBusApp.dto.ResponseStructure;
import org.jpa.AdminBusApp.exception.BusNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {

	@Autowired
	private BusDao busDao;
	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Bus>> saveBus(Bus bus,int admin_id){
		ResponseStructure<Bus> structure=new ResponseStructure<>();
		Optional<Admin> dbOptional=adminDao.findById(admin_id);
		if(dbOptional.isPresent()) {
			Admin admin=dbOptional.get();
			admin.getBus().add(bus);
			bus.setAdmin(admin);
			adminDao.saveAdmin(admin);
		structure.setData(busDao.saveBus(bus));
		structure.setMessage("Bus save");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.CREATED);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure< Bus>> updateBus(Bus bus){
		Optional<Bus> dbOptional=busDao.findById(bus.getId());
		ResponseStructure<Bus> structure= new ResponseStructure<>();
		if(dbOptional.isPresent()) {
			Bus buss= dbOptional.get();
			buss.setBus_number(bus.getBus_number());
			buss.setCost_per_seat(bus.getCost_per_seat());
			buss.setDate_of_departure(bus.getDate_of_departure());
			buss.setFrom_location(bus.getFrom_location());
			buss.setTo_location(bus.getTo_location());
			buss.setImage_url(bus.getImage_url());
			buss.setNo_of_seats(buss.getNo_of_seats());
			structure.setData(busDao.saveBus(bus));
			structure.setMessage("Update successful");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Bus>> findByloc(String date_of_departure, String from_location, String  to_location){
		Optional<Bus> dbOptional=busDao.findByloc(date_of_departure, from_location, to_location);
		ResponseStructure<Bus> structure= new ResponseStructure<>();
		if(dbOptional.isPresent()) {
			structure.setData(dbOptional.get());
			structure.setMessage("Find success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
		
	}
	public ResponseEntity<ResponseStructure<Bus>> findBusBybusNo(String bus_number){
		Optional<Bus> dbOptional=busDao.findBusBybusNo(bus_number);
		ResponseStructure<Bus> structure= new ResponseStructure<>();
		if(dbOptional.isPresent()) {
			structure.setData(dbOptional.get());
			structure.setMessage("Find success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Bus>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
		
	}

	public ResponseEntity<ResponseStructure <List<Bus>>> findBusByAdminid(int admin_id){
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		List<Bus> db= busDao.findBusByAdminid(admin_id);
		if(db.size()>0) {
			structure.setData(db);
			structure.setMessage("Find Success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
	}
	public ResponseEntity<ResponseStructure <List<Bus>>> findBusByTravelName(String travels_name){
		ResponseStructure<List<Bus>> structure=new ResponseStructure<>();
		List<Bus> db=busDao.findBusByTravelName(travels_name);
		if(db.size()>0) {
			structure.setData(db);
			structure.setMessage("Find Success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<List<Bus>>>(structure, HttpStatus.ACCEPTED);
			
		}
		throw new BusNotFoundException();
		
	}

	
	public ResponseEntity<ResponseStructure <List<Bus>>> findBusdate(String date_of_departure){
		List<Bus> dbOptional=busDao.findBusdate(date_of_departure);
		ResponseStructure <List<Bus>> structure= new ResponseStructure<>();
		if(dbOptional.size()>0) {
			structure.setData(dbOptional);
			structure.setMessage("Find success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure <List<Bus>>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BusNotFoundException();
		
	}
	
}
