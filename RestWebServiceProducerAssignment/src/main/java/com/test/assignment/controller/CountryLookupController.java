package com.test.assignment.controller;

import com.test.assignment.service.CountryLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is controller class which servers all request for the rest web service.
 * 
 * @author Chandu Sonawane
 *
 */
@RestController
public class CountryLookupController {

	private final CountryLookupService countryLookupService;

	/**
	 * This method is constructor injection
	 * 
	 * @param countryLookupService
	 */
	@Autowired
	public CountryLookupController(CountryLookupService countryLookupService) {
		this.countryLookupService = countryLookupService;
	}

	/**
	 * This method returns country name for input IP address.
	 * 
	 * @param ipAddress
	 * @return String (countryName)
	 */
	@GetMapping("/countryName/{ipAddress}")
	public String getCountryNameByIp(@PathVariable("ipAddress") String ipAddress) {

		return countryLookupService.getCountryNameByIp(ipAddress);

	}

	/**
	 * This method returns country code for input IP address.
	 * 
	 * @param ipAddress
	 * @return String (countryCode)
	 */
	@GetMapping("/countryCode/{ipAddress}")
	public String getCountryCodeByIp(@PathVariable("ipAddress") String ipAddress) {

		return countryLookupService.getCountryCodeByIp(ipAddress);

	}
}
