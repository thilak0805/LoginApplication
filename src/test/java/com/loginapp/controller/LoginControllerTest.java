package com.loginapp.controller;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import junit.framework.Assert;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:dispatcher-servlet-test.xml"})
public class LoginControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private LoginController loginController;
	
	@Before
	public void setup(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>setup");
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
	}
	
	@Test
	public void testshowForm() throws Exception{
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<method");
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/loginform"))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.view().name("/loginform"))
						.andExpect(MockMvcResultMatchers.forwardedUrl("/loginform"))
						.andReturn();
		Assert.assertNotNull(result.getModelAndView());
		
	}
	
	
	
}
