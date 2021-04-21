package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.OrderProduct;

@Mapper
public interface OrderProductsDao {
	
	//주문 물품 생성
	public int insert(OrderProduct orderproduct);
	
	//특정 유저에 주문 물품 리스트
	public List<OrderProduct> selectByUserId(String userid);
	
	public int insertByList(List<OrderProduct> orderProductList);
	
}
