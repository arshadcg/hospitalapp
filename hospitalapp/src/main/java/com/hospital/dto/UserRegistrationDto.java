package com.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private String addressLine;
	private String cityName;
	private String contactNumber;
	
}
