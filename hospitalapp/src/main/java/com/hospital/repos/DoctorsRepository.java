package com.hospital.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Doctors;

public interface DoctorsRepository extends JpaRepository<Doctors, Integer> {

}
