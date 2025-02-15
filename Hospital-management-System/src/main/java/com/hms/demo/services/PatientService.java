package com.hms.demo.services;

import java.util.List;


import com.hms.demo.entity.Patient;


public interface PatientService {
	
	List<Patient> getAllpatients();
	 Patient savePatient(Patient patient);
	 
	 Patient getPatientById(long id);
	 Patient updatePatient(Patient patient);
	 
	 void deletePatientById(long id);
	Patient assignDoctorToPatient(long id, long doctid);
	

}
