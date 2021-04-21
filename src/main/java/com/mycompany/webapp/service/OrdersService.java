package com.mycompany.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.OrdersDao;
import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.Pager;

@Service
public class OrdersService {
	
	@Autowired
	private OrdersDao ordersDao;

	public Order getOrder(int orderNo) {
		Order order = ordersDao.selectByOrderNo(orderNo);
		return order;
	}
	
	public List<Order> getOrderList(Pager pager, String searchType, String keyword){
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("endRowNo", pager.getEndRowNo());
		map.put("startRowNo", pager.getStartRowNo());
		
		List<Order> orderList = ordersDao.selectByPage(map);
		return orderList;
	}
	
	
	public void updateOrder(Order order) {
		ordersDao.updateOrder(order);
	}
	
	public int getTotalRows(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		int totalRows = ordersDao.count(map);
		return totalRows;
	}
	
}
