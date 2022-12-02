package com.hospital.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.model.Admissions;
import com.hospital.model.Doctors;
import com.hospital.model.Patients;
import com.hospital.model.Province;
import com.hospital.repos.AdmissionRepository;
import com.hospital.repos.DoctorsRepository;
import com.hospital.repos.PatientsRepository;
import com.hospital.repos.ProvinceRepository;

@Controller
@RequestMapping("/super")
public class SuperController {

	
	@Autowired private PatientsRepository patientsRepository;
	@Autowired private AdmissionRepository admissionRepository;
	@Autowired private DoctorsRepository doctorsRepository;
	@Autowired private ProvinceRepository provinceRepository;
	/*
	@Autowired private Admissions admissions;
	@Autowired private Doctors doctors;
	@Autowired private Patients patients;
	@Autowired private Province province;*/
	
	
	@GetMapping("/superpage")
	public String superPage()
	{
		
		return "superpage";
	}
	//get all patients
	@GetMapping("/patients")
	public String getlAllPatients(Model model)
	{
		List<Patients> patients = patientsRepository.findAll();
		model.addAttribute("patients", patients); 
		return "patients";
	}
	
	//get all admissions
	@GetMapping("/admissions")
	public String getAllAdmissions(Model model)
	{
		List<Admissions> admissions = admissionRepository.findAll();
		model.addAttribute("admissions", admissions);
		return "admissions";
	}
	
	//get all doctors list
	@GetMapping("/doctors")
	public String getAllDoctors(Model model)
	{
		List<Doctors> doctors= doctorsRepository.findAll();
		model.addAttribute("doctors", doctors);
		return "doctors";	
	}
	
	//get all province names
	
	@RequestMapping("/privinceNames")
	public String getAllProvinceNames(Model model)
	{
		List<Province> provinceNames=provinceRepository.findAll();
		model.addAttribute("provinceNames", provinceNames);
		return "privinceNames";
	}
	
	
	
	// custom analytics or fetch custom data for super
	
	//*************PATIENTS FUNCTIONALITIES START FROM HERE
	// get all patients from given city
	
	@RequestMapping("/patients/byCity")
	public String getPatientsFromCity(Model model, @RequestParam("cityName") String cityName)
	{
		String message = "Details of patients for given city: "+cityName;
		List<Patients> patientsByCity = patientsRepository.findAll()
				.stream()
				.filter(p->p.getCity().equalsIgnoreCase(cityName))
				.collect(Collectors.toList());
		model.addAttribute("message", message);
		model.addAttribute("patients", patientsByCity);
		return "patients";
	}
	
	// get count of patients from given city
	
	@RequestMapping("/patients/count/city")
	public String countPatientsByCity(Model model, @RequestParam("city") String cityName)
	{
		Long patientsCountByCity =patientsRepository.findAll().stream().filter(p->p.getCity().equalsIgnoreCase(cityName)).count();
		
		String message ="No of patients from given city: "+cityName+" ="+" "+patientsCountByCity;
		model.addAttribute("message", message);
		return "superpage";
	}
	
	// updating province_id in db for given province_code.
	/*
	@PatchMapping("/province/update")
	public String provinceUpdateRealtime(Model model)
	{
		List<Patients> patientslist = patientsRepository.findAll();
		List<Province> provincelist = provinceRepository.findAll();
		
		List<String> pc= provinceRepository.findAll().stream().sorted(Comparator.comparing(Province::getProvinceId)).map(p->p.getProvinceCode()).collect(Collectors.toList());
		
		List<Integer> pi =provinceRepository.findAll().stream().sorted().map(p->p.getProvinceId()).collect(Collectors.toList());
		
		for(int i=1;i<=pc.size();i++)
		{
			
			patientsRepository.save(null)
		}
		
		
		
		return "superpage";
	}
	*/
	//****************ADMISSIONS FUNCTIONALITIES START FROM HERE
	
	
	
	
	
	
	
	
}
