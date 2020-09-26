package com.zelish.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zelish.entity.FoodTruckEntity;

public interface FoodTruckRepository extends JpaRepository<FoodTruckEntity, Long>{

	List<FoodTruckEntity> findByExpirationDate(String expirationDate);
	
	List<FoodTruckEntity> findByApplicantOrFacilityTypeOrStatus(String applicant,String facilityType,String status);
	
	List<FoodTruckEntity> findByExpirationDateGreaterThanEqual(Date expirationDate);
	
}
