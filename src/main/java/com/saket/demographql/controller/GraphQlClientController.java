package com.saket.demographql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saket.demographql.entity.CountryMaster;
import com.saket.demographql.service.GraphQlClientService;

@RestController
@RequestMapping("/graphql-client")
public class GraphQlClientController {
	
	@Autowired
	GraphQlClientService graphQlClientService;
	
	@GetMapping("/getAllCountries")
	public Iterable<CountryMaster> getAllCountries() {
		return graphQlClientService.getAllCountries();
	}

	@GetMapping("/country-by-code/{countryCode}")
	public CountryMaster getCountryByCode(@PathVariable String countryCode) {
		return graphQlClientService.findCountryByCode(countryCode);
	}

	@PostMapping("/add-country")
	public CountryMaster addCountry(@RequestBody CountryMaster countryMaster) {
		return graphQlClientService.addCountry(countryMaster);
	}

}
