package com.hms.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.demo.entity.Doctor;
import com.hms.demo.entity.Patient;
import com.hms.demo.repository.DoctorRepository;
import com.hms.demo.repository.PatientRepository;
import com.hms.demo.services.PatientService;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	@Autowired
	private final PatientRepository patientRepository;
	
    private final  DoctorRepository doctorRepository;
	

	

   public PatientServiceImpl(PatientRepository patientRepository, DoctorRepository doctorRepository) {
		super();
		this.patientRepository = patientRepository;
		this.doctorRepository = doctorRepository;
	}
@Override
    public Patient assignDoctorToPatient(long id, long doctid) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepository.findById(doctid)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        patient.setDoctor(doctor);
        return patientRepository.save(patient);
    }
	@Override
	public List<Patient> getAllpatients() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public Patient getPatientById(long id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public void deletePatientById(long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
		
	}




}
