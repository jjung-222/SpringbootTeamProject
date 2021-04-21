package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.OrderProductsDao;
import com.mycompany.webapp.dto.OrderProduct;

@Service
public class OrderProductsService {
	
	
	@Autowired
	private OrderProductsDao orderProductsDao;
	
	public void createOrderProduct(OrderProduct orderProduct) {
		orderProductsDao.insert(orderProduct);
	}
	
	public void createOrderProductByList(List<OrderProduct> orderProductList) {
		orderProductsDao.insertByList(orderProductList);
	}
	

}
