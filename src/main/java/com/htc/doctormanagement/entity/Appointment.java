package com.htc.doctormanagement.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
	
	public Appointment(long appointmentId, LocalDate appointmentDate, long doctorId) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.doctorId = doctorId;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private long appointmentId;
	private LocalDate appointmentDate;
	private long doctorId;

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate + ", doctorId="
				+ doctorId + "]";
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	

}
