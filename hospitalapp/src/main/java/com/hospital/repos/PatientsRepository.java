package com.hospital.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Patients;

@Repository
public interface PatientsRepository extends JpaRepository<Patients,Integer>{
									
}
