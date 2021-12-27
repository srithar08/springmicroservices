package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.login.pojo.LoginProductPojo;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/logcheck", method=RequestMethod.GET)
	public LoginProductPojo loginPage()
	{
		//LoginProductPojo loginProductPojo = new LoginProductPojo();
		LoginProductPojo loginProductPojo = restTemplate.getForObject("http://PRODUCTS-SERVICES/product/getproduct",
				LoginProductPojo.class);
		return loginProductPojo;
	}
	
}
