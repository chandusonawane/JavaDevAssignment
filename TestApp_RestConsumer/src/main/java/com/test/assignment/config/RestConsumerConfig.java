package com.test.assignment.config;

import com.test.assignment.SortByCountryNameApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This is configuration class for the application.s
 * 
 * @author Chandu
 *
 */
@Configuration
public class RestConsumerConfig {

	@Bean
	public SortByCountryNameApp sortByCountryNameApp() {

		return new SortByCountryNameApp();
	}
}
