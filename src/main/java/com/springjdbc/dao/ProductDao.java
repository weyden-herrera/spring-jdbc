package com.springjdbc.dao;


import java.util.List;

import com.springjdbc.model.Product;

public interface ProductDao {
	public List<Product> getAll();
}
