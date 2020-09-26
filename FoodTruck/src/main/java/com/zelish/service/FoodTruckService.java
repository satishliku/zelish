package com.zelish.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.zelish.entity.FoodTruckEntity;

public interface FoodTruckService {
	
	Optional<String> saveFoodTruckDetails(MultipartFile file) throws Exception;
	
	List<FoodTruckEntity> getAllFoodTrucks();
	
	String updateFoodTruck(FoodTruckEntity entity);
	
	String delete(Long id);
	
	List<FoodTruckEntity> findByExpirationDate();
	
	List<FoodTruckEntity> findByApplicantFacilityTypeStatus(String applicant,String facilityType,String status);
	
	
}
