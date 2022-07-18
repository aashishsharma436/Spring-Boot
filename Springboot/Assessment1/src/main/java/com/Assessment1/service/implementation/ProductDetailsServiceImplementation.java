package com.springbootTrendNext.Assessment1.service.implementation;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.springbootTrendNext.Assessment1.repository.ProductDetailsRepository;
import com.springbootTrendNext.Assessment1.entity.ProductDetailsEntity;
import com.springbootTrendNext.Assessment1.model.ProductDetails;
import com.springbootTrendNext.Assessment1.service.ProductDetailsService;

@Service
@Configuration
public class ProductDetailsServiceImplementation implements ProductDetailsService{
	@Autowired
	ProductDetailsRepository productDetailsRepository;
	
	
	@Override
	public ProductDetails getProductDetails(int id) {
		Optional<ProductDetailsEntity> optional = productDetailsRepository.findById(id);
		ProductDetails productDetails = new ProductDetails();
		if (!optional.isEmpty()) {
			productDetails.setId(id);
			productDetails.setDescription(optional.get().getDescription());
			productDetails.setPrice(optional.get().getPrice());
		}
		return productDetails;
 	}

	@Override
	public String addProduct(ProductDetails submitProductDetails) {
		ProductDetailsEntity productDetailsEntity = new ProductDetailsEntity();
		productDetailsEntity.setDescription(submitProductDetails.getDescription());
		productDetailsEntity.setPrice(submitProductDetails.getPrice());
		productDetailsRepository.save(productDetailsEntity);
		return "Record Save Successfully";
	}

	@Override
	public String deleteProduct(int id) {
		productDetailsRepository.deleteById(id);
		return "Product Delete Successfully";
	}

}
