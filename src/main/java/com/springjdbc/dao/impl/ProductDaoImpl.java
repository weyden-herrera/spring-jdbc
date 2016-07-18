package com.springjdbc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.springjdbc.connection.ConnectionFactory;
import com.springjdbc.connection.DBUtil;
import com.springjdbc.dao.ProductDao;
import com.springjdbc.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	Connection connection;
	Statement statement;

	@Override
	public List<Product> getAll() {
		String query = "SELECT * from product";
		ResultSet rs = null;
		List<Product> productList = new ArrayList<>();
		
		//connection to database
		try{
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				productList.add(product);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}finally {
			DBUtil.close(rs);
		    DBUtil.close(statement);
		    DBUtil.close(connection);
		}
		
		return productList;
	}

}
