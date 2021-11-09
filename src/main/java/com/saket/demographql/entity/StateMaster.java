package com.saket.demographql.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="STATE_MASTER")
public class StateMaster {
	
	@EmbeddedId
	private StateMasterPK id;
	
	@Column(name = "STATE_NAME")
	private String stateName;
	
	public StateMasterPK getId() {
		return id;
	}

	public void setId(StateMasterPK id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
}
