package com.mycompany.webapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.OrderProduct;
import com.mycompany.webapp.dto.Pager;

@Mapper
public interface OrdersDao {
	
	public List<Order> selectByPage(Map<String, Object> map);
	
	public List<OrderProduct> getOrderProduct(int orderno);
	
	public int count(Map<String, Object> map);
	
	//주문 정보 변경
	public int updateOrder(Order order);
	
	//주문번호로 주문 조회
	public Order selectByOrderNo(int orderno);
	
	//주문 생성
	public int insert(Order order);
	
}
