package com.springjdbc.service.impl;

import java.util.List;

import com.springjdbc.dao.ProductDao;
import com.springjdbc.model.Product;
import com.springjdbc.service.ProductService;
import com.springjdbc.service.factory.ServiceFactoryJDBC;

public class ProductServiceImpl extends ServiceFactoryJDBC implements ProductService {

	private final ProductDao productDao;
	public ProductServiceImpl(ProductDao productDao){
		this.productDao = productDao;
	}
	
	@Override
	public List<Product> findAll() {
		startTransaction();
		List<Product> returnList = productDao.getAll();
		commitTransaction();
		return returnList;
	}

}
