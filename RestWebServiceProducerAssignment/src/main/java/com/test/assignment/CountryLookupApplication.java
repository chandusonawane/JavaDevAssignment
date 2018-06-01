package com.test.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is main application class which start the application on embedded tomcat
 * server.
 * 
 * @author Chandu Sonawane
 *
 */
@SpringBootApplication
public class CountryLookupApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryLookupApplication.class, args);
	}

}
