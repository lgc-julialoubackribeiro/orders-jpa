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
	
	public ResponseEntity<Product> getProduct(int id) {
		return repository.findById(id).map(el -> {
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Product> deleteProduct(int id) {
		return repository.findById(id).map(el -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Product> updateProduct(int id, Product product) {
		return repository.findById(id).map(el -> {
			el.setName(product.getName());
			el.setUnitPrice(product.getUnitPrice());
			el.setMeasures(product.getMeasures());
			el.setCategory(product.getCategory());

			Product updated = repository.save(el);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
}