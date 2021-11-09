package com.saket.demographql.vo;

import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.enumeration.CountryEventType;

public class CountryEvent {
	
	private CountryMaster countryMaster;
	
	private CountryEventType countryEventType;

	public CountryEvent() {
		super();
	}

	public CountryEvent(CountryMaster countryMaster, CountryEventType countryEventType) {
		super();
		this.countryMaster = countryMaster;
		this.countryEventType = countryEventType;
	}

	public CountryMaster getCountryMaster() {
		return countryMaster;
	}

	public void setCountryMaster(CountryMaster countryMaster) {
		this.countryMaster = countryMaster;
	}

	public CountryEventType getCountryEventType() {
		return countryEventType;
	}

	public void setCountryEventType(CountryEventType countryEventType) {
		this.countryEventType = countryEventType;
	}

}
