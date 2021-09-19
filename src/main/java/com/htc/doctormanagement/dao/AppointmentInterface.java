package com.htc.doctormanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.htc.doctormanagement.entity.Appointment;


@Repository
public interface AppointmentInterface extends JpaRepository<Appointment,Long>{
	
}
