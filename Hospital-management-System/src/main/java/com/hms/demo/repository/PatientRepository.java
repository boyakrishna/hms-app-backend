package com.hms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.demo.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
