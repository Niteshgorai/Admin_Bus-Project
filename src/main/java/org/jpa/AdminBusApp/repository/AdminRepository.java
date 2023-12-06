package org.jpa.AdminBusApp.repository;

import java.util.List;
import java.util.Optional;

import org.jpa.AdminBusApp.dto.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.phone=?1 and a.password=?2")
	Optional<Admin> loginAdmin(String phone, String password);
//	@Query("select t from admin_bus t where t.travel=?1")
//	public List<Admin> findByTravelName(String travel);
	@Query("select v from Admin v where v.email=?1 and v.password=?2")
	Optional<Admin> loginAdmin1(String email, String password);

}
