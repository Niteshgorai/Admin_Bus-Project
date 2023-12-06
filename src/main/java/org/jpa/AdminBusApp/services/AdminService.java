package org.jpa.AdminBusApp.services;

import java.util.Optional;

import org.jpa.AdminBusApp.dao.AdminDao;
import org.jpa.AdminBusApp.dto.Admin;
import org.jpa.AdminBusApp.dto.ResponseStructure;
import org.jpa.AdminBusApp.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
		ResponseStructure<Admin> structure= new ResponseStructure<>();
		structure.setData(adminDao.saveAdmin(admin));
		structure.setMessage("Admin save");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(String phone, String password){
		Optional<Admin> db= adminDao.loginAdmin(phone, password);
		ResponseStructure<Admin> structure= new ResponseStructure<>();
		if(db.isPresent()) {
			structure.setData(db.get());
			structure.setMessage("Login  seccess");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException();
	}
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin1(String email, String password){
		Optional<Admin> db=adminDao.loginAdmin1(email, password);
		ResponseStructure<Admin> structure= new ResponseStructure<>();
		if(db.isPresent()) {
			structure.setData(db.get());
			structure.setMessage("Login Successfull");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.OK);
		}
		throw new AdminNotFoundException();
		
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin){
		ResponseStructure<Admin> structure= new ResponseStructure<>();
		Optional<Admin> db=adminDao.findById(admin.getId());
		if(db.isPresent()) {
			Admin dbAdmin=db.get();
			dbAdmin.setEmail(admin.getEmail());
			dbAdmin.setName(admin.getName());
			dbAdmin.setBus(admin.getBus());
			dbAdmin.setGst(admin.getGst());
			dbAdmin.setPhone(admin.getPhone());
			dbAdmin.setPassword(admin.getPassword());
			dbAdmin.setTravels_name(admin.getTravels_name());
			structure.setData(adminDao.saveAdmin(admin));
			structure.setMessage("Update Successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
		}
		return null;
	}
	public ResponseEntity<ResponseStructure<Admin>> findById(int id){
		ResponseStructure<Admin> structure=new ResponseStructure<>();
		Optional<Admin> dbOptinal= adminDao.findById(id);
		if(dbOptinal.isPresent()) {
			structure.setData(dbOptinal.get());
			structure.setMessage("Success");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.ACCEPTED);
		}
		throw new AdminNotFoundException();
	}
}
