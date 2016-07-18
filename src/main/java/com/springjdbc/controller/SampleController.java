package com.springjdbc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjdbc.factory.DaoFactory;
import com.springjdbc.model.Product;

@RestController
@RequestMapping(value="/api/sample")
public class SampleController {
	
	@RequestMapping(value="/allproduct")
	public List<Product> allProducts(){
		List<Product> productList = new ArrayList<>();
		
		productList = DaoFactory.getProductDao().getAll();
		System.out.println("Accessing : /allproduct");
		return productList;
	}

}
