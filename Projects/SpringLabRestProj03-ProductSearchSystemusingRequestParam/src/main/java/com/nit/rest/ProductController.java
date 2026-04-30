package com.nit.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.model.Product;
import com.nit.service.ProductService;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@GetMapping("/getProductByCategoryAndPrice")
	public List<Product> getProductByCategoryAndPrice(@RequestParam String category,@RequestParam double price){
		
		return ps.getProductsByCategoryAndPrice(category, price);
	}
}
