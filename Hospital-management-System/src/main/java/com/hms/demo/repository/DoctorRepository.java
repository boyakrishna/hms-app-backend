package com.hms.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hms.demo.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
  /* @Query("select d from Doctor d where d.Dr_Name=?1")	
   Doctor findByName(String Dr_Name);*/




}
