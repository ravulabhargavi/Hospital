package com.htc.doctormanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.doctormanagement.dao.AppointmentInterface;
import com.htc.doctormanagement.dao.DoctorInterface;
import com.htc.doctormanagement.entity.Appointment;
import com.htc.doctormanagement.entity.Doctor;
import com.htc.doctormanagement.service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorCotroller {
	
		@Autowired
		private DoctorInterface doctorInterface;
		@Autowired
		private AppointmentInterface appointmentInterface;
		@Autowired
		private DoctorService doctorService;
		
		public DoctorCotroller(DoctorInterface doctorInterface, AppointmentInterface appointmentInterface,
				DoctorService doctorService) {
			super();
			this.doctorInterface = doctorInterface;
			this.appointmentInterface = appointmentInterface;
			this.doctorService = doctorService;
		}


		@PostMapping("/doctors")
		ResponseEntity<Object> createDoctordetails(@RequestBody Doctor doctor)
		{
			return doctorService.createDoctordetails(doctor);
			
		}

		
		 @GetMapping("/doctors")
		  public List<Doctor> getAllDoctordetails() {
		   
		    List<Doctor> list = new ArrayList<>();
		    Iterable<Doctor> customers = doctorInterface.findAll();
		 
		    customers.forEach(list::add);
		    return list;
		  }
		 
		
		@GetMapping("/doctors/doctorId")
		Doctor getDoctorbyId(@RequestParam("doctorId") Long doctorId)
		{
			Doctor doctor=null;
			doctor=doctorInterface.findById(doctorId).get();
			return doctor;
			
		}

		
		 @GetMapping("/doctors/{specialization}")
			public Doctor findByspecialization(@RequestParam String specialization) {

				return doctorInterface.findByDoctorspecialization(specialization);
			}
		
		
		
	

	}


