package com.iorta.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.Order;
import com.iorta.sboot.dto.OrderDTO;
import com.iorta.sboot.exception.InvalidOrderException;
import com.iorta.sboot.service.RestTemplateService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	RestTemplateService restTemplateService;

	//	Place an order (@RequestBody)
	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody Order order) {
		try {
			if (order.getQuantity() <= 0) {
				throw new IllegalArgumentException("Order must contain at least one item.");
			}
			return ResponseEntity.ok("Order placed: Product - " + order.getProductName() + ", Quantity: " + order.getQuantity());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
		}
	}

	//	public String placeOrder(@RequestBody Order order) {
	//		if (order.getQuantity() <= 0) {
	//			throw new InvalidOrderException("Order must contain at least one item.");
	//		}
	//		return "Order placed: Product - " + order.getProductName() + ", Quantity: " + order.getQuantity();
	//	}

	//Local Exception Handler
	@ExceptionHandler(InvalidOrderException.class)
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	public String handleInvalidOrderException(InvalidOrderException ex) {
		return "Invalid Order: " + ex.getMessage();
	}

	//Get Order Details
	@GetMapping("/{id}")
	public String getOrderById(@PathVariable int id) {
		return "Fetched order with ID: " + id;
	}

	//Filter order by status (@RequestParam)
	@GetMapping
	public String getOrders(@RequestParam(required = false) String status) {
		if(status != null) {
			return "Fetching orders with status: " + status;
		}
		return "Fetching all orders";
	}

	@GetMapping("/place/{userId}")
	public OrderDTO placeOrder(@PathVariable int userId, @RequestParam String productName) {
		return restTemplateService.placeOrder(userId, productName);
	}
}
