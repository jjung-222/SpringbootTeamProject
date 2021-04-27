package com.mycompany.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductReviewsDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductReviews;

@Service
public class ProductReviewsService {
	@Autowired ProductReviewsDao productReviewsDao;
	
	public List<ProductReviews> getProductReviews(Pager pager, String searchType, String keyword, String sort){
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("sort", sort);
		map.put("endRowNo", pager.getEndRowNo());
		map.put("startRowNo", pager.getStartRowNo());
		
		List<ProductReviews> list = productReviewsDao.selectByPage(map);
		return list;
	}
	
	public List<ProductReviews> getBestReview(){
		List<ProductReviews> list = productReviewsDao.selectByBest();
		return list;
	}
	
	

	public ProductReviews getReview(int boardno) {
		ProductReviews productreviews = productReviewsDao.selectByBno(boardno);
		return productreviews;
	}
	
	public void addHitCount(int boardno) {
		productReviewsDao.updateHitCount(boardno);
	}

	public int getTotalRows(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		int totalRows = productReviewsDao.count(map);
		return totalRows;
	}
	
	public void removeReview(int boardno) {
		productReviewsDao.deleteReview(boardno);
	}
	
	
}
