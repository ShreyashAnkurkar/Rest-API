package com.nit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.model.Order;

@Service
public class OrderService {

	public String getStatus(int id) {
		 List<Order> orderList = new ArrayList<>();

	        orderList.add(new Order(1, "Rahul", "Laptop", "Delivered"));
	        orderList.add(new Order(2, "Sneha", "Mobile", "Pending"));
	        orderList.add(new Order(3, "Amit", "Chair", "Shipped"));
	        orderList.add(new Order(4, "Priya", "Table", "Delivered"));
	        orderList.add(new Order(5, "Karan", "Shoes", "Cancelled"));
	        
	        String result = orderList.stream()
	                .filter(o -> o.getOrderId() == id)
	                .map(Order::getStatus)
	                .findFirst()
	                .orElse("Not Found");
	        
	        return result;
	}
}
