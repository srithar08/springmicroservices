package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.pojo.ProductPojo;
import com.product.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ProductPojo saveProData(ProductPojo productPojo)
	{
		productPojo = productService.saveProduct(productPojo);
		return productPojo;
	}
	
	@RequestMapping(value = "/getproduct", method = RequestMethod.GET)
	public ProductPojo getProduct() {
		
		ProductPojo proPojo = new ProductPojo();
		proPojo.setProdId(2);
		proPojo.setProdName("RollsRoyce");
		proPojo.setProdDesc("this is care");
		
		return proPojo;
		
	}

}
