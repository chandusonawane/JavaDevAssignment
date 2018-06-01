package com.test.assignment.config;

import com.maxmind.geoip.LookupService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

/**
 * This is configuration class for the application.
 * 
 * @author Chandu Sonawane
 *
 */
@Configuration
public class CountryLookupConfig {

	@Bean
	public LookupService lookupService() throws IOException {
		File file = new ClassPathResource("GeoIPLite.dat").getFile();
		return new LookupService(file, LookupService.GEOIP_MEMORY_CACHE);
	}
}