package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Order;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductReviews;
import com.mycompany.webapp.service.ProductReviewsService;

@RestController
@RequestMapping("/productReview")
public class ProductReviewController {
	
	@Autowired
	private ProductReviewsService productReviewsService;
	
//	@GetMapping("")
//	public Map<String, Object> list(@RequestParam(defaultValue = "1") int pageNo,
//			@RequestParam(defaultValue = "") String searchType,
//			@RequestParam(defaultValue = "") String keyword) {
//
//			int totalRows = productReviewsService.getTotalRows(searchType, keyword);
//			Pager pager = new Pager(10, 5, totalRows, pageNo);
//			List<Order> productReviewList = productReviewsService.getProductReviews(pager,searchType, keyword);
//			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("pager", pager);
//			map.put("productReviews", productReviewList);
//			return map;
//	}
}
