package com.crudorders.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudorders.orders.model.Order;
import com.crudorders.orders.service.OrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({"/orders/"})
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@ApiOperation(value = "Criação de pedido")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Pedido criado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}
	
	@ApiOperation(value = "Lista de pedidos")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Lista de pedidos"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@GetMapping(produces="application/json")
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	@ApiOperation(value = "Buscar pedido por Id")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Pedido encontrado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@GetMapping(path = {"/{id}"}, produces="application/json")
	public ResponseEntity<Order> getOrder(@PathVariable int id) {
		return orderService.getOrder(id);
	}
	
	@ApiOperation(value = "Exclusão de pedido")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Pedido deletado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@DeleteMapping(path ={"/{id}"}, produces="application/json")
	public ResponseEntity<Order> deleteOrder(@PathVariable int id) {
		return orderService.deleteOrder(id);
	}
}