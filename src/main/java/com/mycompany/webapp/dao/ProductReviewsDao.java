package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductReviews;

@Mapper
public interface ProductReviewsDao {
	public List<ProductReviews> prSelectAll();
	public List<ProductReviews> prSelectByPno(Pager pager);
	public List<ProductReviews> prSelectByUserId(Pager pager);
	public ProductReviews prSelectByBno(int boardno);
	public void prUpdateCount(int boardno);
	public int count(int productno);
	public int countByUserId(String userid);
	public int prInsert(ProductReviews productrivews);
	public int prUpdate(ProductReviews productrivews);
	public int prDelete(int boardno);
	public List<ProductReviews> prUser(int productno);
}
