package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.OrderProduct;
import com.mycompany.webapp.dto.Pager;

@Mapper
public interface OrdersDao {
	//주문번호로 주문 조회
	public Order selectByOrderNo(int orderno);
	
	//주문 생성
	public int insert(Order order);
	
	//주문 정보 변경
	public int updateOrder(Order order);
	
	public List<OrderProduct> getOrderProduct(int orderno);
	
	public List<Order> selectByUserId(Pager pager);
	
	public int count(String userid);
}
