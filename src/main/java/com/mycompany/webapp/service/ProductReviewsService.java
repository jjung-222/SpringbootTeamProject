package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductReviewsDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductReviews;

@Service
public class ProductReviewsService {
	@Autowired ProductReviewsDao productReviewsDao;
	public List<ProductReviews> prSelectAll(){
		List<ProductReviews> list = productReviewsDao.prSelectAll();
		return list;
	}
	
	public List<ProductReviews> prSelectByPno(Pager pager){
		List<ProductReviews> list = productReviewsDao.prSelectByPno(pager);
		return list;
	}
	
	public List<ProductReviews> prSelectByUserId(Pager pager){
		List<ProductReviews> list = productReviewsDao.prSelectByUserId(pager);
		return list;
	}
	
	public ProductReviews prSelectByBno(int boardno) {
		ProductReviews productreviews = productReviewsDao.prSelectByBno(boardno);
		return productreviews;
	}
	
	public void prUpdateCount(int boardno) {
		productReviewsDao.prUpdateCount(boardno);
	}
	
	public int getTotalRows(int productno) {
		int rows = productReviewsDao.count(productno);
		return rows;
	}
	
	public int getTotalRows(String userid) {
		int rows = productReviewsDao.countByUserId(userid);
		return rows;
	}
	
	public void prInsert(ProductReviews productrivews) {
		productReviewsDao.prInsert(productrivews);
	}
	
	public void prUpdate(ProductReviews productrivews) {
		productReviewsDao.prUpdate(productrivews);
	}
	
	public void prDelete(int boardno) {
		productReviewsDao.prDelete(boardno);
	}
	
	public List<ProductReviews> prUser(int productno) {
		List<ProductReviews> list = productReviewsDao.prUser(productno);
		return list;
	}
}
