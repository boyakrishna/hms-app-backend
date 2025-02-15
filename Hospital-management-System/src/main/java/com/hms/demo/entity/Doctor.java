package com.hms.demo.entity;



import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("doctid")
	private Long doctid;
	
	@Column(name = "Dr_Name")
	@JsonProperty("Dr_Name")
	private String Dr_Name;
	
	@Column(name = "Specialist")
	@JsonProperty("Specialist")
	private String Specialist;
	
	@Column(name = "Date_of_visited")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonProperty("Date_of_visited")
	private Date Date_of_visited;
	
	public Doctor() {
		
	}

	
	
	public Long getDoctid() {
		return doctid;
	}



	public void setDoctid(Long doctid) {
		this.doctid = doctid;
	}



	public String getDr_Name() {
		return Dr_Name;
	}



	public void setDr_Name(String dr_Name) {
		Dr_Name = dr_Name;
	}



	public String getSpecialist() {
		return Specialist;
	}



	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}



	public Date getDate_of_visited() {
		return Date_of_visited;
	}



	public void setDate_of_visited(Date date_of_visited) {
		Date_of_visited = date_of_visited;
	}
    
	


	public Doctor(Long doctid, String dr_Name, String specialist, Date date_of_visited) {
		super();
		this.doctid = doctid;
		Dr_Name = dr_Name;
		Specialist = specialist;
		Date_of_visited = date_of_visited;
	}

    


	@Override
	public String toString() {
		return "Doctor [doctid=" + doctid + ", Dr_Name=" + Dr_Name + ", Specialist=" + Specialist + ", Date_of_visited="
				+ Date_of_visited + "]";
	}




	@OneToMany(mappedBy = "doctor",cascade=CascadeType.ALL)
	@JsonIgnoreProperties("Doctor")
	private List<Patient> patient;
	

	

	

}
