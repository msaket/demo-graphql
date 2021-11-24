package com.saket.demographql.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saket.demographql.entity.CountryMaster;

import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;

@Service("graphQlClientService")
public class GraphQlClientServiceImpl implements GraphQlClientService{
	
	@Autowired
	GraphQLWebClient graphQLWebClient;
	
	public Iterable<CountryMaster> getAllCountries() {
		String qry = "query {\r\n"
				+ "  countries {\r\n"
				+ "    countryCode\r\n"
				+ "    countryName\r\n"
				+ "    states{\r\n"
				+ "      stateCode\r\n"
				+ "      stateName\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		GraphQLRequest request = GraphQLRequest.builder().query(qry).build();		
		GraphQLResponse response = graphQLWebClient.post(request).block();
		List<CountryMaster> cmList = response.getList("countries", CountryMaster.class);
		return cmList;
	}
	
	public CountryMaster findCountryByCode(String countryCode) {
		Map<String, String> variable = new HashMap<>();
		variable.put("countryCode", countryCode);
		String qry = "query countryByCode ($countryCode: String) {\r\n"
				+ "  countryByCode(countryCode: $countryCode) {\r\n"
				+ "    countryCode,\r\n"
				+ "    countryName,\r\n"
				+ "    states {\r\n"
				+ "      stateCode,\r\n"
				+ "      stateName\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		GraphQLRequest request = GraphQLRequest.builder().query(qry).variables(variable).build();		
		GraphQLResponse response = graphQLWebClient.post(request).block();
		CountryMaster cm = response.get("countryByCode", CountryMaster.class);
		return cm;
	}
	
	public CountryMaster addCountry(CountryMaster countryMaster) {
		Map<String, String> variable = new HashMap<>();
		variable.put("countryCode", countryMaster.getCountryCode());
		variable.put("countryName", countryMaster.getCountryName());
		String qry = "mutation countryByCode ($countryCode : String, $countryName : String) {\r\n"
				+ "  addCountry(countryCode: $countryCode, countryName: $countryName) {\r\n"
				+ "    countryCode,\r\n"
				+ "    countryName\r\n"
				+ "  }\r\n"
				+ "}";
		GraphQLRequest request = GraphQLRequest.builder().query(qry).variables(variable).build();		
		GraphQLResponse response = graphQLWebClient.post(request).block();
		CountryMaster cm = response.get("addCountry", CountryMaster.class);
		return cm;
	}


}
