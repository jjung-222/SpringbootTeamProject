package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("")
	public Map<String, Object> list(@RequestParam(defaultValue = "1") int pageNo,
									@RequestParam(defaultValue = "") String searchType,
									@RequestParam(defaultValue = "") String keyword) {

		int totalRows = ordersService.getTotalRows(searchType, keyword);
		Pager pager = new Pager(10, 5, totalRows, pageNo);
		List<Order> orderList = ordersService.getOrderList(pager,searchType, keyword);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("orders", orderList);
		return map;
	}
	
	@GetMapping("/{orderno}")
	public Order getOrder(@PathVariable int orderno) {
		Order order = ordersService.getOrder(orderno);
		return order;
	}
	
	@PutMapping("")
	public Order updateStatus(@RequestBody Order order) {
		Order newOrder = ordersService.updateOrder(order);
		
		return newOrder;
		
	}
}
