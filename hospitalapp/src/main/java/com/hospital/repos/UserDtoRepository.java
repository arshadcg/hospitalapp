package com.hospital.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.dto.UserDto;

public interface UserDtoRepository extends JpaRepository<UserDto, Integer> {

	Optional<UserDto> findByUserName(String userName);
}
