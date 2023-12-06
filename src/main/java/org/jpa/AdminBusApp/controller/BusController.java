package org.jpa.AdminBusApp.controller;

import java.util.List;

import org.jpa.AdminBusApp.dto.Bus;
import org.jpa.AdminBusApp.dto.ResponseStructure;
import org.jpa.AdminBusApp.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buses")
public class BusController {

	@Autowired
	private BusService busService;
	
	@PostMapping("/{admin_id}")
	public ResponseEntity<ResponseStructure<Bus>> saveBus(@RequestBody Bus bus,@PathVariable int admin_id){
		return busService.saveBus(bus,admin_id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Bus>> updateBus(@RequestBody Bus bus ){
		return busService.updateBus(bus);
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Bus>> findByloc(@RequestParam String to_location, @RequestParam String date_of_departure, @RequestParam String from_location ){
		return busService.findByloc(date_of_departure, from_location, to_location);
	}
	@GetMapping("/{bus_number}")
	public ResponseEntity<ResponseStructure<Bus>> findBusBybusNo(@PathVariable String bus_number ){
		return busService.findBusBybusNo(bus_number);
	}
	@GetMapping("/bus")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByAdminid(@RequestParam int admin_id){
		return busService.findBusByAdminid(admin_id);
	}
	@GetMapping("/travel")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusByTravelName(@RequestParam String travels_name){
		return busService.findBusByTravelName(travels_name);
	}
	@GetMapping("/date")
	public ResponseEntity<ResponseStructure<List<Bus>>> findBusdate(@RequestParam String date_of_departure){
		return busService.findBusdate( date_of_departure);
	}
}
