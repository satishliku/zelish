package com.zelish.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.entity.FoodTruckEntity;
import com.zelish.service.FoodTruckService;

@RestController
public class FoodTruckController {
	
	@Autowired
	FoodTruckService service;
	
	@PostMapping(value = "/foodtruck", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
	public ResponseEntity<?> saveFoodTruckDetails(@RequestParam(value = "file") MultipartFile file) throws Exception{
		
		Optional<String> response=service.saveFoodTruckDetails(file);
		
		return response.isPresent()? ResponseEntity.status(HttpStatus.CREATED).build():ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).build();
	}
	
	@GetMapping("/fetchAll")
	public List<FoodTruckEntity> fetchAll(){
		
		return service.getAllFoodTrucks();
	}
	
	@PostMapping("/update")
	public String updateFoodTruck(@RequestBody FoodTruckEntity entity){
		
		return service.updateFoodTruck(entity);
	}
	
	@GetMapping("/delete/{id}")
	
	public String deleteFoodTruck(@PathVariable Long id) {
		
		return service.delete(id);
	}
	
	
	@GetMapping("/expdate")
	public List<FoodTruckEntity> findByExpirationDate(){
		return service.findByExpirationDate();
	}
	
	@GetMapping("/{applicant}/{facilityType}/{status}")
	public List<FoodTruckEntity> findByApplicantFacilityTypeStatus(@PathVariable String applicant,@PathVariable String facilityType,@PathVariable String status){
		return service.findByApplicantFacilityTypeStatus(applicant, facilityType, status);
	}
	
	
}
