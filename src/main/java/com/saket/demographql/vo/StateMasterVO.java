package com.saket.demographql.vo;

import com.saket.demographql.entity.StateMaster;

public class StateMasterVO {
	
	private String stateCode;

	private String countryCode;
	
	private String stateName;

	public StateMasterVO() {
		
	}
	
	public StateMasterVO(StateMaster sm) {
		this.stateCode = sm.getId().getStateCode();
		this.countryCode = sm.getId().getCountryCode();
		this.stateName = sm.getStateName();
	}
	
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

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
