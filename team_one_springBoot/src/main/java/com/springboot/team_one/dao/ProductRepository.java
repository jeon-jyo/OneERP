package com.springboot.team_one.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.team_one.dto.Product;


// extends JpaRepository<voType, id Type>
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
