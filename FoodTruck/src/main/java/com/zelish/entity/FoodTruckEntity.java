package com.zelish.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FOOD_TRUCKS")
public class FoodTruckEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String applicant; 
	private String facilityType; 
	private String status;
	private Date expirationDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "FoodTruckEntity [id=" + id + ", applicant=" + applicant + ", facilityType=" + facilityType + ", status="
				+ status + ", expirationDate=" + expirationDate + ", getId()=" + getId() + ", getApplicant()="
				+ getApplicant() + ", getFacilityType()=" + getFacilityType() + ", getStatus()=" + getStatus()
				+ ", getExpirationDate()=" + getExpirationDate() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
		
}
