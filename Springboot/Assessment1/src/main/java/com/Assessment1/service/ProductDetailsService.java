package com.springbootTrendNext.Assessment1.service;

import com.springbootTrendNext.Assessment1.model.ProductDetails;

public interface ProductDetailsService {
	public ProductDetails getProductDetails(int id);
	public String addProduct(ProductDetails submitProductDetails);
	public String deleteProduct(int id);
}
