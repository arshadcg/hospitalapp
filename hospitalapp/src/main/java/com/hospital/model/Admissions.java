package com.hospital.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

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
//@Embeddable

@Entity
public class Admissions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int admissionId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	
	private Patients patients;
	
	private Date admissionDate;
	private Date dischargeDate;
	private String diagnosis;
	
	@ManyToOne
	@JoinColumn(name="attending_doctor_id")
	private Doctors doctors;
	
	
	
	
}
