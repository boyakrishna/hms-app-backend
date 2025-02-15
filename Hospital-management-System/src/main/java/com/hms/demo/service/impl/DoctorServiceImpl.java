package com.hms.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hms.demo.entity.Doctor;
import com.hms.demo.repository.DoctorRepository;
import com.hms.demo.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	private DoctorRepository doctorRepository;
	/*private PatientRepository patientRepository;*/
	
  
	


	

	public DoctorServiceImpl(DoctorRepository doctorRepository) {
		super();
		this.doctorRepository = doctorRepository;
		
	}

	@Override
	public List<Doctor> getAlldoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor getDoctorById(long doctid) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctid).get();
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return  doctorRepository.save(doctor);
	}

	

	@Override
	public void deleteDoctorById(long doctid) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(doctid);
		
	}

	
/*	@Override
    public Doctor assignPatientToDoctor(Long patientId, Long doctorId) {
        // Fetch doctor
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();

        // Fetch patient
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();

        // Assign doctor to patient
        patient.setDoctor(doctor);

        // Save updated patient
        patientRepository.save(patient);

        return doctor;
	}*/

	
	 
	 }

	

	

