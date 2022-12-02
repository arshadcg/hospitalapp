package com.hospital.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@Id
	private int id;
	private String userName;
	private String password;
	private boolean active;
	private String roles;
}
