package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.CartsDao;
import com.mycompany.webapp.dto.Cart;

@Service
public class CartsService {
	@Autowired
	private CartsDao cartsDao;
	
	public void createCart(Cart cart) {
		cartsDao.insert(cart);
	}
	
	public List<Cart> getCartList(String userid) {
		List<Cart> list = cartsDao.selectByUserId(userid);
		return list;
	}
	
	public Cart getCart(Cart cart) {
		Cart tempCart = cartsDao.select(cart);
		return tempCart;
	}
	
	//체크 표시된 카트 삭제
	public void removeSelectCart(List<Cart> cartList) {
		cartsDao.deleteSelectCart(cartList);
	}
	
	//카트 전체 삭제
	public void removeCartAll(String userid) {
		cartsDao.deleteAllByUserId(userid);
	}
	
	//카트 개수 업데이트
	public void updateCartQuantity(Cart cart) {
		cartsDao.updateCartQuantity(cart);
	}
	
	//카트 하나 삭제
	public void removeCartOne(Cart cart) {
		cartsDao.deleteByCart(cart);
	}
	
	
}
