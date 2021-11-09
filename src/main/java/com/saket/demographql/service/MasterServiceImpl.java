package com.saket.demographql.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.saket.demographql.dao.CountryMasterDao;
import com.saket.demographql.dao.StateMasterDao;
import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.vo.StateMasterVO;

@Service("masterService")
public class MasterServiceImpl implements MasterService{
	
	@Resource CountryMasterDao countryMasterDao;
	@Resource StateMasterDao stateMasterDao;
	
	public Iterable<CountryMaster> getCountryMasterList() {
		return countryMasterDao.findAll();
	}

	public List<StateMasterVO> getStateMasterList(String countryCode) {
		if(countryCode == null || countryCode.isEmpty()) {
			return stateMasterDao.findAll()
					.stream().map(sm -> {
									return new StateMasterVO(sm); 
								}).collect(Collectors.toList());
		}
		else {
			return stateMasterDao.findByCountryCode(countryCode)
					.stream().map(sm -> {
									return new StateMasterVO(sm); 
								}).collect(Collectors.toList());
		}
	}
	
	public CountryMaster findCountryByCode(String countryCode) {
		return countryMasterDao.findById(countryCode).get();
	}
	
	public CountryMaster addCustomer(String countryCode, String countryName) {
		return countryMasterDao.save(new CountryMaster(countryCode, countryName));
	}
}
