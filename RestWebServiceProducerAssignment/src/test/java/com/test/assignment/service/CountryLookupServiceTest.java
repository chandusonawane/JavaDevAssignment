package com.test.assignment.service;

import com.maxmind.geoip.Country;
import com.maxmind.geoip.LookupService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CountryLookupServiceTest {

    private final String ipAddress = "anyIpAddress";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private LookupService lookupService;

    @Mock
    private Country country;

    private CountryLookupService countryLookupService;

    @Before
    public void setUp() {
        countryLookupService = new CountryLookupService(lookupService);

    }


    @Test
    public void getCountryNameByIp() {

        when(lookupService.getCountry(ipAddress)).thenReturn(country);
        when(country.getName()).thenReturn("anyCountryName");

        String actualCountryName = countryLookupService.getCountryNameByIp(ipAddress);

        verify(lookupService).getCountry(ipAddress);
        verify(country).getName();
        assertThat(actualCountryName).isEqualTo("anyCountryName");

    }

    @Test
    public void getCountryCodeByIp() {
        when(lookupService.getCountry(ipAddress)).thenReturn(country);
        when(country.getCode()).thenReturn("anyCountryCode");
        String actualCountryCode = countryLookupService.getCountryCodeByIp(ipAddress);
        verify(lookupService).getCountry(ipAddress);
        verify(country).getCode();
        assertThat(actualCountryCode).isEqualTo("anyCountryCode");

    }
}