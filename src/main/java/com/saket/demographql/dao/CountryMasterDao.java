package com.saket.demographql.dao;

import org.springframework.data.repository.CrudRepository;

import com.saket.demographql.entity.CountryMaster;

public interface CountryMasterDao extends CrudRepository<CountryMaster, String>{
	
	public CountryMaster findCountryMasterByCountryCode(String code);

}
