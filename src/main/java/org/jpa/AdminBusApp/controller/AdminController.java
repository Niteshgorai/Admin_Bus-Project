package org.jpa.AdminBusApp.controller;

import org.jpa.AdminBusApp.dto.Admin;
import org.jpa.AdminBusApp.dto.ResponseStructure;
import org.jpa.AdminBusApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admins")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin){
		return adminService.saveAdmin(admin);
	}
	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestParam String phone, @RequestParam String password){
		return adminService.loginAdmin(phone, password);
	}
	@GetMapping("/admin1")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin1(@RequestParam String email, @RequestParam String password){
		return adminService.loginAdmin1(email, password);
	}
	@PutMapping("/admin")
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin){
		return adminService.updateAdmin(admin);
	}
	@GetMapping("/admin/getByid")
	public ResponseEntity<ResponseStructure<Admin>> findById(@RequestParam int id){
		return adminService.findById(id);
	}
}
