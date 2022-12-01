package com.hospital.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Admissions;


@Repository
public interface AdmissionRepository extends JpaRepository<Admissions, Integer> {

}
