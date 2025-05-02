package com.iorta.sboot.serviceImpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iorta.sboot.dto.Product;
import com.iorta.sboot.exception.ProductNotFoundException;
import com.iorta.sboot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private List<Product> products = Arrays.asList(
			new Product(1, "Laptop", 1000.0),
			new Product(2, "Smartphone", 500.0),
			new Product(3, "Tablet", 300.0));
	
	public Product getProductById(int id) {
		try {
			return products.stream()
					.filter(product -> product.getId() == id)
					.findFirst()
					.orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found")); 
		} catch (ProductNotFoundException e) {
			System.err.println("Exception caught in Service Layer: " + e.getMessage());
			throw e;
		}
	}

}
