package com.crudorders.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudorders.orders.model.OrderProduct;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer>{

}