package com.test.assignment.service;/* CountryLookupService.java */

/* Only works with GeoIP Country Edition */
/* For Geoip City Edition, use CityLookupTest.java */

import com.maxmind.geoip.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is service class of the application.
 * 
 * @author Chandu Sonawane
 *
 */
@Service
public class CountryLookupService {

	private final LookupService lookupService;

	/**
	 * This method is constructor injection
	 * 
	 * @param lookupService
	 */
	@Autowired
	public CountryLookupService(LookupService lookupService) {
		this.lookupService = lookupService;
	}

	/**
	 * This method returns country Name
	 * 
	 * @param ipAddress
	 * @return
	 */
	public String getCountryNameByIp(String ipAddress) {

		return lookupService.getCountry(ipAddress).getName();
	}

	/**
	 * This method returns country code.
	 * 
	 * @param ipAddress
	 * @return
	 */
	public String getCountryCodeByIp(String ipAddress) {

		return lookupService.getCountry(ipAddress).getCode();

	}
}
