package com.saket.demographql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COUNTRY_MASTER")
public class CountryMaster {
	
	@Id
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	@Column(name = "COUNTRY_NAME")
	private String countryName;

	public CountryMaster() {
		
	}

	public CountryMaster(String countryCode, String countryName) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	

}
