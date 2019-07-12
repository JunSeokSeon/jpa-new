package com.jpa.repository.custom;

import java.util.List;

import com.jpa.domain.Order;
import com.jpa.domain.OrderSearch;

public interface CustomOrderRepository {
	
	public List<Order> search(OrderSearch orderSearch);
	
}
