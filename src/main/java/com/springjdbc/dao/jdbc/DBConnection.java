package com.springjdbc.dao.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private final static ThreadLocal<DBConnection> threadLocal = new ThreadLocal<DBConnection>();
	
	private Connection connection;
	private static DataSource dataSource;
	
	static {
		 try {
	        	Context ctx = new InitialContext();
	        	dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/sampledb");
	        } catch (NamingException e) {
	            e.printStackTrace();
	        }
	}
	
	private DBConnection(Connection connection){
		this.connection = connection;
	}
	
	public static void create() {
		try {
			//DataSource dataSource = JdbcUtil.getDataSource();
			Connection connection = dataSource.getConnection();
			DBConnection dbConnection = new DBConnection(connection);
			threadLocal.set(dbConnection);
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection current() {
		try {
			DBConnection dbConnection = threadLocal.get();
			Connection connection = dbConnection.connection;
			return connection;
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void rollback() {
		try {
			DBConnection dbConnection = threadLocal.get();
			Connection connection = dbConnection.connection;
			connection.rollback();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		try {
			DBConnection dbConnection = threadLocal.get();
			Connection connection = dbConnection.connection;
			connection.commit();
			connection.close();
			
			threadLocal.remove();
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	
}
