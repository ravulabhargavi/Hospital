package com.htc.doctormanagement.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.htc.doctormanagement.dao.AppointmentInterface;
import com.htc.doctormanagement.dao.DoctorInterface;
import com.htc.doctormanagement.entity.Doctor;


@Service
public class DoctorService {
	        @Autowired
			private DoctorInterface doctorInterface;
			@Autowired
			private AppointmentInterface appointmentInterface;

			@Transactional
	public ResponseEntity<Object> createDoctordetails(Doctor doctor)
	{
		Doctor newDoctor = new Doctor();
		
		        newDoctor.setDoctorId(doctor.getDoctorId());
		
		        newDoctor.setDoctorName(doctor.getDoctorName());
		
		        newDoctor.setSpecialization(doctor.getSpecialization());
//		        for(int i=0; i< doctor.getAppointment().size(); i++){
//		        	Appointment appointment = appointmentInterface.save(doctor.getAppointment().get(i));
//		        	            }

		        newDoctor.setAppointment(doctor.getAppointment());
		
		        Doctor savedDoctor = doctorInterface.save(newDoctor);
				return ResponseEntity.accepted().body(savedDoctor);
		       
		
	}

	
	
	  public List<Doctor> getAllDoctordetails() {
	   
	    List<Doctor> list = new ArrayList<>();
	    Iterable<Doctor> customers = doctorInterface.findAll();
	 
	    customers.forEach(list::add);
	    return list;
	  }
	 
	

	Doctor getDoctorbyId(Long doctorId)
	{
		Doctor doctor=null;
		doctor=doctorInterface.findById(doctorId).get();
		return doctor;
		
	}
	
//	@GetMapping("/doctors/{appointmentId}")
//	Doctor getByappointmentId(@PathVariable Long appointmentId)
//	{
//		Doctor doctor=null;
//		doctor=repo.findById(appointmentId).get();
//		return doctor;
//		
//	}
	
	
		public Doctor findByspecialization( String specialization) {

			return doctorInterface.findByDoctorspecialization(specialization);
		}
	
	
}
