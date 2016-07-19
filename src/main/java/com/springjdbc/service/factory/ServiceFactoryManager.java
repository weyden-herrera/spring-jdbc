package com.springjdbc.service.factory;

import com.springjdbc.dao.factory.DaoFactory;
import com.springjdbc.service.ProductService;
import com.springjdbc.service.impl.ProductServiceImpl;

public class ServiceFactoryManager extends ServiceFactory {

	private DaoFactory daoFactory;
	public ServiceFactoryManager(){
		this.daoFactory = DaoFactory.getInstance();
	}
	
	private ProductService productService;
	@Override
	public ProductService getProductService() {
		if(productService == null){
			productService = new ProductServiceImpl(daoFactory.getProductDao());
		}
		return productService;
	}
	
	
	
}
