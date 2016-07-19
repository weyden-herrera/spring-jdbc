package com.springjdbc.service.factory;

import com.springjdbc.service.ProductService;

public abstract class ServiceFactory {
	private final static ServiceFactory INSTANCE = new ServiceFactoryManager();
	
	public static ServiceFactory getInstance(){
		return INSTANCE;
	}
	
	public abstract ProductService getProductService();
	
}
