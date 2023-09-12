package com.crudorders.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudorders.orders.model.Product;
import com.crudorders.orders.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping({"/products/"})
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value = "Criação de produto")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Produto criado"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<Product> createUser(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@ApiOperation(value = "Lista de produtos")	
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Lista de produtos"),
	    @ApiResponse(code = 204, message = "Nenhum conteúdo encontrado"),
	    @ApiResponse(code = 400, message = "Requisição mal formatada"),
	    @ApiResponse(code = 404, message = "Usuário não encontrado"),
	    @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
	    @ApiResponse(code = 500, message = "Exceção gerada"),
	})
	@GetMapping(produces="application/json")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
		
}