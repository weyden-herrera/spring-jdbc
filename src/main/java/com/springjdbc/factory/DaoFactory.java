package com.springjdbc.factory;

import com.springjdbc.dao.ProductDao;
import com.springjdbc.dao.impl.ProductDaoImpl;

public class DaoFactory {
	
	private static ProductDao productDao;
	
	public static ProductDao getProductDao(){
		if (productDao == null){
			productDao = new ProductDaoImpl();
		}
		return productDao;
	}

}
