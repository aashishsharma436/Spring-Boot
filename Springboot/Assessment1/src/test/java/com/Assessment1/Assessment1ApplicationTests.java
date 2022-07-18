package com.springbootTrendNext.Assessment1;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springbootTrendNext.Assessment1.service.ProductDetailsService;



@SpringBootTest
public class Assessment1ApplicationTests {
	@MockBean
	ProductDetailsService productDetailsService;

	@Test
	void contextLoads() {
		Mockito.when(productDetailsService.deleteProduct(1)).thenReturn("Delete successfull");
		String testName = productDetailsService.deleteProduct(1);
	    Assert.assertEquals("Delete successfull", testName); 
	}

}
