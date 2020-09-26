package com.zelish.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.entity.FoodTruckEntity;
import com.zelish.repository.FoodTruckRepository;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {
 
	@Autowired
	FoodTruckRepository repo;
	
	/* Upload csv to DB */
	@Override
	public Optional<String> saveFoodTruckDetails(MultipartFile file) throws Exception {
		
		List<FoodTruckEntity> entity=csvParser(file);
		repo.saveAll(entity);
		return Optional.of(entity.size()+" -Record Inserted Successfully");
	}
	
	/* Csv Parsing */
	private List<FoodTruckEntity> csvParser(MultipartFile file) throws Exception{
		
		List<FoodTruckEntity> entityList=new ArrayList<>();
		String line=null;
		
		try {
			try(BufferedReader reader=new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				int counter = 0;
				while((line=reader.readLine())!=null) {
					if(counter > 0) {
						FoodTruckEntity entity=new FoodTruckEntity();
						 String[] data=line.split(",");
						 
						 Date expDate=new SimpleDateFormat("yyyy-mm-dd").parse(data[3]); 
						  
						 entity.setApplicant(data[0]); 
						 entity.setFacilityType(data[1]);
						 entity.setStatus(data[2]);
						 entity.setExpirationDate(expDate);
						 
						 entityList.add(entity);
						//entityList.forEach(System.out::println);
					}
					counter++;
				}
				
			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return entityList;
 	}

	/* Fetch All Food Facility Trucks */
	@Override
	public List<FoodTruckEntity> getAllFoodTrucks() {
		
		//modelmapper.addConverter(converter);
		List<FoodTruckEntity> list=repo.findAll();
		return list;
	}

	/*find By ExpirationDate Food Facility Trucks */
	@Override
	public List<FoodTruckEntity> findByExpirationDate() {
		Date date=new Date();
		List<FoodTruckEntity> list=repo.findByExpirationDateGreaterThanEqual(date);
		return list;
	}

	/* Update Food Facility Trucks */
	@Override
	public String updateFoodTruck(FoodTruckEntity data) {
		Optional<FoodTruckEntity> result= repo.findById(data.getId());
		
		  if(result.isPresent()) { 
			  repo.save(data); 
		  return "Update Successfully for Id - "+data.getId();
		   
		  } 
		  else {
		  
		  return "Id -"+data.getId()+" is not pressent"; 
		  }
		 
	}
	
	/* Delete By Id Food Facility Trucks */
	@Override
	public String delete(Long id) {
		Optional<FoodTruckEntity> result=repo.findById(id);
		if(result.isPresent()) { 
			  repo.deleteById(id);
			  return "Id " +id +"data deleted Succesfully";
		   } 
		  else {
		  
			  return "id "+id+"is not pressent"; 
		  }
		
	}
	
	/* Fetch By Applicant Or FacilityType Or Status of Food Facility Trucks */
	@Override
	public List<FoodTruckEntity> findByApplicantFacilityTypeStatus(String applicant, String facilityType,
			String status) {
		List<FoodTruckEntity> list=repo.findByApplicantOrFacilityTypeOrStatus(applicant, facilityType, status);
		
		return list;
	}
	
	

}
