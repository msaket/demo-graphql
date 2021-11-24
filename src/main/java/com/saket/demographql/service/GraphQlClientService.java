package com.saket.demographql.service;

import com.saket.demographql.entity.CountryMaster;

public interface GraphQlClientService {
	
	public Iterable<CountryMaster> getAllCountries();
	
	public CountryMaster findCountryByCode(String countryCode);

	public CountryMaster addCountry(CountryMaster countryMaster);

}
