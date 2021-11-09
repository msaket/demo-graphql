package com.saket.demographql.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StateMasterPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "STATE_CODE")
	private String stateCode;

	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
