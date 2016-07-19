package com.springjdbc.service.factory;

import com.springjdbc.dao.jdbc.DBConnection;

public abstract class ServiceFactoryJDBC {

	protected void startTransaction() {
		DBConnection.create();
	}
	
	protected void rollbackTransaction() {
		DBConnection.rollback();
	}
	
	protected void commitTransaction() {
		DBConnection.close();
	}
}
