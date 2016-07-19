package com.springjdbc.dao.factory;

import com.springjdbc.dao.ProductDao;
import com.springjdbc.dao.impl.ProductDaoImpl;

public class DAOFactoryJdbcManager extends DaoFactory{
	
	private ProductDao productDao;

	@Override
	public ProductDao getProductDao() {
		if(productDao == null){
			productDao = new ProductDaoImpl();
		}
		return productDao;
	}

	
	
}
