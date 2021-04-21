package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.OrdersService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrdersService ordersService;
	
	@GetMapping("")
	public Map<String, Object> list(@RequestParam(defaultValue = "1") int pageNo,
									@RequestParam(defaultValue = "") String searchType,
									@RequestParam(defaultValue = "") String keyword) {

		int totalRows = ordersService.getTotalRows(searchType, keyword);
		Pager pager = new Pager(5, 5, totalRows, pageNo);
		System.out.println(keyword+ " " + searchType);
		List<Order> orderList = ordersService.getOrderList(pager,searchType, keyword);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		map.put("orders", orderList);
		return map;
	}
	
	@GetMapping("/test")
	public int test (@RequestParam(defaultValue = "1") int pageNo,
					@RequestParam(defaultValue = "") String searchType,
					@RequestParam(defaultValue = "") String keyword
	) {
		System.out.println(searchType+ " " +keyword);
		int totalRows = ordersService.getTotalRows(searchType, keyword);
		return totalRows;
	}
}
