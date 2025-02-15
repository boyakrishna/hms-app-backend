package com.hms.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hms.demo.entity.Patient;

import com.hms.demo.services.PatientService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping("/api")
public class PatientController {
	
	private PatientService patientService;
	
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@PostMapping("/addpatients")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        
        
		return new ResponseEntity<Patient>(patientService.savePatient(patient),
				HttpStatus.CREATED);
      
    }
	
	@GetMapping("/patients")
    public List<Patient> getAllpatients()
    {
	
    	return patientService.getAllpatients();
    }
	
	
	@GetMapping("/getpatientsById/{id}")
	public ResponseEntity<Patient> getPatientsById(@PathVariable("id") long id)
	{
	return new ResponseEntity<Patient> (patientService.getPatientById(id),HttpStatus.OK);
		
	}

	 @PutMapping("/{id}/assign-doctor/{doctid}")
	 public ResponseEntity<Patient> assignDoctor(
	            @PathVariable long id,
	            @PathVariable long doctid) {
	       
	        Patient updatedPatient = patientService.assignDoctorToPatient(id, doctid);
	        return ResponseEntity.ok(updatedPatient);
	    }
	
	@PutMapping("/api/updatepatientById/{id}")
	public ResponseEntity<Patient>updatePatient(@PathVariable("id")long id,@RequestBody Patient patient)
	{
		return new ResponseEntity<Patient>(patientService.updatePatient(patient),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/api/deletePatientById/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable("id") long id)
	{
		
	patientService.deletePatientById(id);
	return new ResponseEntity<String>("Patients deleted successfully", HttpStatus.OK);
	}
    
	
    


}
