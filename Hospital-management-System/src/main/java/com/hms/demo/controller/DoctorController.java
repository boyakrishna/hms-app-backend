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

import com.hms.demo.entity.Doctor;
import com.hms.demo.services.DoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@Controller
public class DoctorController {
	
	private DoctorService doctorService;
	

	
	public DoctorController(DoctorService doctorService) {
		super();
		this.doctorService = doctorService;
	}
	@PostMapping("/adddoctors")
	public ResponseEntity<Doctor> savedoctors(@RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),
				HttpStatus.CREATED);
	}
	

	
	@GetMapping("/doctors")
    public List<Doctor> getAlldoctors()
    {
	
    	return doctorService.getAlldoctors();
    }
	@GetMapping("/getdoctorsById/{doctid}")
	public ResponseEntity<Doctor> getDoctorsById(@PathVariable("doctid") long doctid)
	{
	return new ResponseEntity<Doctor> (doctorService.getDoctorById(doctid),HttpStatus.OK);
		
	}
	@PutMapping("/api/updatedoctorById/{doctid}")
	public ResponseEntity<Doctor>updateDoctors(@PathVariable("doctid")long doctid,@RequestBody Doctor doctor)
	{
		return new ResponseEntity<Doctor>(doctorService.updateDoctor(doctor),HttpStatus.OK);
	}
	@DeleteMapping("/api/deletedoctorById/{doctid}")
	public ResponseEntity<String> deleteDoctors(@PathVariable("doctid") long doctid)
	{
		
		doctorService.deleteDoctorById(doctid);
	return new ResponseEntity<String>("Doctors deleted successfully", HttpStatus.OK);
	}
    
	
    
	/* @PutMapping("/{doctorId}/assignPatient/{patientId}")
	    public ResponseEntity<Doctor> assignPatientToDoctor(
	            @PathVariable Long doctorId, 
	            @PathVariable Long patientId) {
	        
	        Doctor doctor = doctorService.assignPatientToDoctor(patientId, doctorId);
	        return ResponseEntity.ok(doctor);
	    }
*/
	

}
