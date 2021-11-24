package com.saket.demographql.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.enumeration.CountryEventType;
import com.saket.demographql.service.MasterService;
import com.saket.demographql.vo.CountryEvent;
import com.saket.demographql.vo.StateMasterVO;

@Controller
public class GraphQlController {
	
	@Resource MasterService masterService;
	
	//@SchemaMapping(typeName = "Query", field = "countries")
	@QueryMapping   //This is same as above line because typeName is Query and filedName comes from method name
	Iterable<CountryMaster> countries() {
		return masterService.getCountryMasterList();
	}
	
	@QueryMapping
	CountryMaster countryByCode(@Argument String countryCode) {
		return masterService.findCountryByCode(countryCode);
	}
	
	@SchemaMapping(typeName = "Country")
	List<StateMasterVO> states(CountryMaster country) {
		return masterService.getStateMasterList(country.getCountryCode());
	}
	
	//@SchemaMapping(typeName = "Mutation", field = "addCountry")
	@MutationMapping   //This is same as above line because typeName is Mutation and fieldName comes from method name
	CountryMaster addCountry(@Argument String countryCode, @Argument String countryName) {
		return masterService.addCustomer(countryCode, countryName);
	}
	
	@SubscriptionMapping
	List<CountryEvent> countryEvents(@Argument String countryCode) {
		Integer i = 0;
		List<CountryEvent> lst = new ArrayList<CountryEvent>();
		CountryEvent ce = null;
		
		CountryMaster country = masterService.findCountryByCode(countryCode);
		while(i < 10) {
			ce = new CountryEvent(country, Math.random() > .5 ? CountryEventType.UPDATED : CountryEventType.DELETED);
			lst.add(ce);
			i++;
		}
		return lst;
	}
}
