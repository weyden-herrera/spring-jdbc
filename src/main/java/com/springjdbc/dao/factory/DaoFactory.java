package com.springjdbc.dao.factory;

import com.springjdbc.dao.ProductDao;
import com.springjdbc.dao.impl.ProductDaoImpl;

public abstract class DaoFactory {
	
	private static final DaoFactory INSTANCE = new DAOFactoryJdbcManager();
	
	public static DaoFactory getInstance(){
		return INSTANCE;
	}
	
	public abstract ProductDao getProductDao();

}
