package com.hospital.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Patients implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date birthDate;
	private String city;
	private String provinceCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="province_id")
	private Province province;
	private String allergies;
	private int height;
	private int weight;
	//@OneToMany(mappedBy = "patients")
	//private List<Admissions> admissions= new ArrayList<>();
	
}
