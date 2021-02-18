package com.springjdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost:3306/sample_db";
	public static final String STR_URL = "http://uAdfDFADF:@!#FADF#FAAAFD@example.com"
	public static final String USER = "uAdfDFADF";
	public static final String PASSWORD = "!#FADF#FAAAFD";
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	//private constructor
    /*private ConnectionFactory() {
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
	
	private DataSource ds;
	private ConnectionFactory() {
        try {
        	Context ctx = new InitialContext();
        	ds = (DataSource)ctx.lookup("java:comp/env/jdbc/sampledb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }   
     
    public static Connection getConnection() {
        return instance.createConnection();
    }

}
