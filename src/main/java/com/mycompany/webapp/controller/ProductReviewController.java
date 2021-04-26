package com.mycompany.webapp.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private static final Logger logger = LoggerFactory.getLogger(ProductReviewController.class);
	
	@Autowired
	private ProductReviewsService productReviewsService;
	
	@GetMapping("")
	public Map<String, Object> list(@RequestParam(defaultValue = "1") int pageNo,
			String searchType, String keyword) {
			int totalRows = productReviewsService.getTotalRows(searchType, keyword);
			Pager pager = new Pager(5, 5, totalRows, pageNo);
			List<ProductReviews> productReviewList = productReviewsService.getProductReviews(pager,searchType, keyword);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pager", pager);
			map.put("reviews", productReviewList);
			return map;
	}
	
	
	@GetMapping("{boardno}")
	public ProductReviews getReview(@PathVariable int boardno) {
		ProductReviews review = productReviewsService.getReview(boardno);
		return review;
	}
	
	@DeleteMapping("{boardno}")
	public void deleteReview(@PathVariable int boardno) {
		productReviewsService.removeReview(boardno);
	}
	
   @GetMapping("/battach/{boardno}")
   public void download(@PathVariable int boardno, HttpServletResponse response) {
	   logger.info(boardno+"");
      try {
    	 ProductReviews review = productReviewsService.getReview(boardno);
         String battachoname = review.getBorgimg();
         logger.info(battachoname);
         if(battachoname == null) return;
         battachoname = new String(battachoname.getBytes("UTF-8"),"ISO-8859-1");
         String battachsname = review.getBsaveimg();      
//	         String battachspath = "D:/Study/Users/MyProjects/uploadfiles/" + battachsname;
         String battachspath = "F:/uploadfiles/" + battachsname;
         String battachtype = review.getBimgtype();
         
         response.setHeader("Content-Disposition", "attachment; filename=\""+battachoname+"\";");
         response.setContentType(battachtype);

         InputStream is = new FileInputStream(battachspath);
         OutputStream os = response.getOutputStream();
         FileCopyUtils.copy(is, os);
         is.close();
         os.flush();
         os.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   
   @GetMapping("/bsetReview")
   public List<ProductReviews> bestList() {
	   
	   List<ProductReviews> list = productReviewsService.getBestReview();
	   
	   return list;
   }
	
}
