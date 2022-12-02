package com.hospital.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.dto.UserRegistrationDto;


@Repository

public interface UserRegistrationDtoRepository extends JpaRepository<UserRegistrationDto, Integer> {

	public boolean existsByUserName(String userName);
	
}
