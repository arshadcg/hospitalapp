package com.hospital.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.model.Province;


@Repository
public interface ProvinceRepository extends JpaRepository<Province, String> {

}
