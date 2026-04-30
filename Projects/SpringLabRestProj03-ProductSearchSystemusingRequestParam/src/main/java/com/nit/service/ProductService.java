package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Product;

@Service
public class ProductService {

	public List<Product> getProductsByCategoryAndPrice(String category, double price) {

	    List<Product> productList = new ArrayList<>();
	    productList.add(new Product(101, "Laptop", "Electronics", 75000.0));
	    productList.add(new Product(102, "Mobile", "Electronics", 25000.0));
	    productList.add(new Product(103, "Chair", "Furniture", 3000.0));
	    productList.add(new Product(104, "Table", "Furniture", 7000.0));
	    productList.add(new Product(105, "Shoes", "Fashion", 2000.0));

	    List<Product> result = productList.stream()
	            .filter(p -> p.getCategory().equalsIgnoreCase(category)
	                    && Double.compare(p.getPrice(), price) == 0)
	            .toList();

	    return result;
	}
}
