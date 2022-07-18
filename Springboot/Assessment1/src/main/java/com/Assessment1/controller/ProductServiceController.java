package com.springbootTrendNext.Assessment1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.springbootTrendNext.Assessment1.model.ProductDetails;
import com.springbootTrendNext.Assessment1.service.ProductDetailsService;

@RestController
public class ProductServiceController {
	@Autowired
	ProductDetailsService productDetailsService;
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody  ProductDetails submitProductDetails) {
			return new ResponseEntity<>(productDetailsService.addProduct(submitProductDetails), HttpStatus.CREATED);
	   } 
	
	@RequestMapping(value = "/get/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<ProductDetails> getProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productDetailsService.getProductDetails(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {
		return new ResponseEntity<>(productDetailsService.deleteProduct(id), HttpStatus.OK);
	}
}
