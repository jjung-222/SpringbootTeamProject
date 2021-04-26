package com.mycompany.webapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductReviews;

@Mapper
public interface ProductReviewsDao {
	public List<ProductReviews> selectByPage(Map<String, Object> map);
	
	public List<ProductReviews> selectByBest();
	
	
	public ProductReviews selectByBno(int boardno);
	
	public void updateHitCount(int boardno);

	public int count(Map<String, Object> map);
	
	public void deleteReview(int boardno);

}
