package com.test.assignment.controller;

import com.test.assignment.service.CountryLookupService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CountryLookupControllerTest {

    private final String ipAddress = "anyIpAddress";

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private CountryLookupService countryLookupService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(new CountryLookupController(countryLookupService)).build();
    }

    @Test
    public void getCountryNameByIp() throws Exception {

        when(countryLookupService.getCountryNameByIp(ipAddress)).thenReturn("anyCountryName");

        MvcResult mvcResult = mockMvc.perform(get("/countryName/{ipAddress}", ipAddress))
                .andExpect(status().isOk()).andReturn();

        verify(countryLookupService).getCountryNameByIp(ipAddress);
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("anyCountryName");
    }

    @Test
    public void getCountryCodeByIp() throws Exception {

        when(countryLookupService.getCountryCodeByIp(ipAddress)).thenReturn("anyCountryCode");

        MvcResult mvcResult = mockMvc.perform(get("/countryCode/{ipAddress}", ipAddress))
                .andExpect(status().isOk()).andReturn();

        verify(countryLookupService).getCountryCodeByIp(ipAddress);
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("anyCountryCode");
    }
}