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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iorta.sboot.dto.Product;
import com.iorta.sboot.exception.ProductNameEmptyException;
import com.iorta.sboot.exception.ProductNotFoundException;
import com.iorta.sboot.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
	
	
	
	
	//	//Search products by category (@RequestParam)
	//	@GetMapping
	//	public String getProducts(@RequestParam(required = false) String category) {
	//		if (category != null) {
	//			return "Fetching products in category: " + category;
	//		}
	//		return "Fetching all products";
	//	}
	//If no category is provides -> Fetches all products
	//If category is provides (?category=electronics) -> Fetches electronics
	//http://localhost:1900/products
	//http://localhost:1900/products?category=electronics
	
	//Get product by ID(@PathVariable)
	@GetMapping("/info/{id}")
	public String getProductById(@PathVariable int id) {
		return "Fetching product with ID: " + id;
	}
	//(/products/10) -> Fetches product with ID
	
	//Add a new product(@RequestBody)
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		if (product.getName().isEmpty()) {
			throw new ProductNameEmptyException("Product name cannot be empty");
		}
		return "Product added: " + product.getName() + ", Price: $" + product.getPrice();
	}
	
	@ExceptionHandler(ProductNameEmptyException.class)
	@ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
	public String handleProductNameEmptyException(ProductNameEmptyException ex) {
		return "Error: " + ex.getMessage();
	}
	
	
	
	
	
	
	
	
	
	
}
