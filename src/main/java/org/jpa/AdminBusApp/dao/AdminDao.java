package org.jpa.AdminBusApp.dao;

import java.util.List;
import java.util.Optional;

import org.jpa.AdminBusApp.dto.Admin;
import org.jpa.AdminBusApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepository adminrepository;
	
	public Admin saveAdmin(Admin admin) {
		return adminrepository.save(admin);
	}
	public Optional<Admin> findById(int id){
		return adminrepository.findById(id);
	}
//	public List<Admin> findByTravelName(String travel){
//		return adminrepository.findByTravelName(travel);
//	}
	public Optional<Admin> loginAdmin(String phone, String password) {
		return adminrepository.loginAdmin(phone, password);
	}
	public Optional<Admin> loginAdmin1(String email, String password) {
		// TODO Auto-generated method stub
		return adminrepository.loginAdmin1(email, password);
	}
}
