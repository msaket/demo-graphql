package com.saket.demographql.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.saket.demographql.entity.StateMaster;
import com.saket.demographql.entity.StateMasterPK;

public interface StateMasterDao extends CrudRepository<StateMaster, StateMasterPK>{
	
	@Query("select sm from StateMaster sm where sm.id.countryCode = ?1")
	public List<StateMaster> findByCountryCode(String countryCode);
	
    @Override
    List<StateMaster> findAll();

}
