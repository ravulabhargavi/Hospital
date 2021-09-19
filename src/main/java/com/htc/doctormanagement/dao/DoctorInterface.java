package com.htc.doctormanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.htc.doctormanagement.entity.Doctor;

@Repository
public interface DoctorInterface extends JpaRepository<Doctor,Long> {
	@Query(value = "SELECT * FROM doctor WHERE specialization=?1",nativeQuery = true)
	public Doctor findByDoctorspecialization(String specialization);

}
