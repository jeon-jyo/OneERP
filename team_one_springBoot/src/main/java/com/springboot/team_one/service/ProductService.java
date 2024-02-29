package com.springboot.team_one.service;

import java.util.List;

import com.springboot.team_one.dto.Product;


public interface ProductService {

	public List<Product> listAll(); //list
	public void save(Product product); //insert
	public Product get(int id); //1건 select
	public void delete(int id);
}
