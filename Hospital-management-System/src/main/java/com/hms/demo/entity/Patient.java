package com.hms.demo.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;*/
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "Patient Name")
	@JsonProperty("Name")
	private String Name;
	
	@Column(name = "Age")
	@JsonProperty("Age")
	private int Age;
	
	@Column(name = "Healthproblem")
	@JsonProperty("Healthproblem")
	private String Healthproblem;
	
	@Column(name = "Amount")
	@JsonProperty("Amount")
	private Double Amount;
	
	@Column(name = "Date_of_admitted")
	@JsonProperty("Date_of_admitted")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date Date_of_admitted;
	
	public Patient() {
		
	}

	public Patient(Long id, String name, int age, String healthproblem, Double amount, Date date_of_admitted) {
		super();
		this.id = id;
		Name = name;
		Age = age;
		Healthproblem = healthproblem;
		Amount = amount;
		this.Date_of_admitted = date_of_admitted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getHealthproblem() {
		return Healthproblem;
	}

	public void setHealthproblem(String healthproblem) {
		Healthproblem = healthproblem;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public Date getDate_of_admitted() {
		return Date_of_admitted;
	}

	public void setDate_of_admitted(Date date_of_admitted) {
		this.Date_of_admitted = date_of_admitted;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", Name=" + Name + ", Age=" + Age + ", Healthproblem=" + Healthproblem
				+ ", Amount=" + Amount + ", date_of_admitted=" + Date_of_admitted + "]";
	}

	
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	@JsonIgnoreProperties("Patient")
	private Doctor doctor;

	public void setDoctor(Doctor doctor2) {
		// TODO Auto-generated method stub
		
	}

	
	/*public Object getDoctor() {
	// TODO Auto-generated method stub
	return null;
}

public void setDoctor(Doctor doctor) {
	// TODO Auto-generated method stub
	
}
	public Object getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDoctor(Doctor doctor2) {
		// TODO Auto-generated method stub
		
	}*/


  


}
