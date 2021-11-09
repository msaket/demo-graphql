package com.saket.demographql.service;

import java.util.List;

import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.vo.StateMasterVO;


public interface MasterService {
	
	public Iterable<CountryMaster> getCountryMasterList();

	public List<StateMasterVO> getStateMasterList(String countryCode);
	
	public CountryMaster findCountryByCode(String countryCode);
	
	public CountryMaster addCustomer(String countryCode, String countryName);

}
