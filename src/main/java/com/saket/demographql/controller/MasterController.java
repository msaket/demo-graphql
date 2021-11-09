package com.saket.demographql.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.service.MasterService;
import com.saket.demographql.vo.StateMasterVO;

@RestController()
@RequestMapping({"/master"})
public class MasterController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource MasterService masterService;
	
	@GetMapping("/country-list")
	public Iterable<CountryMaster> getCountryList() {
		logger.info("###getCountryList###");		
		return masterService.getCountryMasterList();			
	}	

	@GetMapping("/state-list")
	public List<StateMasterVO> getStateList() {
		logger.info("###getStateList###");		
		return masterService.getStateMasterList(null);
	}	

	@GetMapping("/state-list/{countryCode}")
	public List<StateMasterVO> getStateList(@PathVariable String countryCode) {
		logger.info("###getStateList###");			
		return masterService.getStateMasterList(countryCode);
	}	

}
