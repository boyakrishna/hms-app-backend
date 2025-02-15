package com.hms.demo.services;

import java.util.List;

import com.hms.demo.entity.Doctor;

public interface DoctorService {
	
	List<Doctor> getAlldoctors();
	 Doctor saveDoctor(Doctor doctor);
	 Doctor getDoctorById(long doctid);
	 Doctor updateDoctor(Doctor doctor);
	 

	 
	 void deleteDoctorById(long doctid);
	
	/* Doctor assignPatientToDoctor(Long patientId, Long doctorId);*/

	 
	 


}
