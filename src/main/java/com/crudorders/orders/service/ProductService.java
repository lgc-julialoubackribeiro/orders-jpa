package com.crudorders.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudorders.orders.model.Product;
import com.crudorders.orders.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	public ResponseEntity<Product> createProduct(Product product) {
		try {
 			Product produto = repository.save(product);
			return ResponseEntity.ok().body(produto);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Product());
		}
	}

	public List<Product> getProducts() {
		List<Product> products = repository.findAll();
		return products;
	}
}