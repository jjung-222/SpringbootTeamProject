package com.mycompany.webapp.service;

import java.util.List;

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
	
	public List<Order> getOrderList(Pager pager){
		List<Order> orderList = ordersDao.selectByUserId(pager);
		return orderList;
	}
	
	public void createOrder(Order order) {
		ordersDao.insert(order);
	}
	
	public void updateOrder(Order order) {
		ordersDao.updateOrder(order);
	}
	
	
	public int getTotalRows(String orderid) {
		int totalRows = ordersDao.count(orderid);
		return totalRows;
	}
	
}
