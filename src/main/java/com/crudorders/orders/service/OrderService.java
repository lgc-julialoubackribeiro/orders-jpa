package com.crudorders.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crudorders.orders.model.Order;
import com.crudorders.orders.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	public ResponseEntity<Order> createOrder(Order order) {
		try {
 			Order pedido = repository.save(order);
			return ResponseEntity.ok().body(pedido);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new Order());
		}
	}

	public List<Order> getOrders() {
		List<Order> orders = repository.findAll();
		return orders;
	}
	
	public ResponseEntity<Order> getOrder(int id) {
		return repository.findById(id).map(el -> {
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Order> deleteOrder(int id) {
		return repository.findById(id).map(el -> {
			repository.deleteById(id);
			return ResponseEntity.ok().body(el);
		}).orElse(ResponseEntity.notFound().build());
	}
}