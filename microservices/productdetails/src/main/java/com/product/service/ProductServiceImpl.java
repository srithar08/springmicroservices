package com.product.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProductEntity;
import com.product.pojo.ProductPojo;
import com.product.repository.ProductRepository;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepo;

	@Override
	public ProductPojo saveProduct(ProductPojo productPojo) {
		
		ProductEntity proEntity = new ProductEntity();
		proEntity.setProdName(productPojo.getProdName());
		proEntity.setProdDesc(productPojo.getProdDesc());
		
		productRepo.save(proEntity);
		
		productPojo.setProdId(proEntity.getProdId());
		productPojo.setProdName(proEntity.getProdName());
		productPojo.setProdDesc(proEntity.getProdDesc());
		return productPojo;
	}
	
	

}
