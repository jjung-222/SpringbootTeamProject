package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductQnas;
import com.mycompany.webapp.dto.User;
import com.mycompany.webapp.service.ProductQnasService;
;

@RestController
@RequestMapping("/pqnaBoard")
public class ProductQnaBoard {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductQnaBoard.class);
	
	@Autowired
	ProductQnasService pqnaService;
	
	@GetMapping("boardlist")
	 public Map<String,Object> pqnaboardnolist(@RequestParam(defaultValue="1") int pageNo) {
	      int totalRows = pqnaService.getCount();
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<ProductQnas> list = pqnaService.pqnaList(pager,1);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("productname")
	 public Map<String,Object> pqnaboardpnamelist(@RequestParam(defaultValue="1") int pageNo) {
	      int totalRows = pqnaService.getCount();
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<ProductQnas> list = pqnaService.pqnaList(pager,2);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("btitle")
	 public Map<String,Object> pqnaboardbtitlelist(@RequestParam(defaultValue="1") int pageNo) {
	      int totalRows = pqnaService.getCount();
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<ProductQnas> list = pqnaService.pqnaList(pager,3);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("userid")
	 public Map<String,Object> pqnaboarduseridlist(@RequestParam(defaultValue="1") int pageNo) {
	      int totalRows = pqnaService.getCount();
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<ProductQnas> list = pqnaService.pqnaList(pager,4);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("bdate")
	 public Map<String,Object> pqnaboardbdatelist(@RequestParam(defaultValue="1") int pageNo) {
	      int totalRows = pqnaService.getCount();
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<ProductQnas> list = pqnaService.pqnaList(pager,5);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	
	/// 검색
	@GetMapping("searchproductname")
	 public Map<String,Object>  searchproductname(@RequestParam(defaultValue="1") int pageNo,String keyword) {
	      int totalRows = pqnaService.getPnameCount(keyword);
	      logger.info(""+totalRows);
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      pager.setKeyword(keyword);
	      List<ProductQnas> list = pqnaService.pqnaSearchList(pager,1);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("searchbtitle")
	 public Map<String,Object>  searchbtitle(@RequestParam(defaultValue="1") int pageNo,String keyword) {
	      int totalRows = pqnaService.getTitleCount(keyword);
	      logger.info(""+totalRows);
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      pager.setKeyword(keyword);
	      List<ProductQnas> list = pqnaService.pqnaSearchList(pager,2);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	@GetMapping("searchuserid")
	 public Map<String,Object>  searchuserid(@RequestParam(defaultValue="1") int pageNo,String keyword) {
	      int totalRows = pqnaService.getUserCount(keyword);
	      logger.info(""+totalRows);
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      pager.setKeyword(keyword);
	      List<ProductQnas> list = pqnaService.pqnaSearchList(pager,3);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("pqnaboardlist", list);
	      return map;
	   }
	
	@GetMapping("boardread")
	public Map<String,Object> boardread(@RequestParam(defaultValue="1") int pageNo, int boardno){
		
		//댓글수
		int reviewCount = pqnaService.getReviewCount(boardno);
	
		ProductQnas pqnas = pqnaService.readBoard(boardno);
		logger.info("" + pqnas);
		 Pager pager = new Pager(5, 5, reviewCount, pageNo);
		List<ProductQnas> reviewlist = pqnaService.getReviewList(pager,boardno);
 		Map<String,Object> map = new HashMap<>();
		map.put("boardpage", pqnas);
		map.put("reviewlist", reviewlist);
		map.put("pager", pager);
		return map;
	}
	
	@GetMapping("rivewread")
	public ProductQnas rivewread (@RequestParam int boardno) {
		ProductQnas pqnas = pqnaService.readReview(boardno);
		return pqnas;
	}
	
	@PutMapping("rivewupdate")
	public void rivewupdate(@RequestBody ProductQnas readreview) {
		logger.info("readreview" + readreview );
		pqnaService.updateReview(readreview);
	}
	
	 @DeleteMapping("boarddelete/{boardno}")
	   public void boarddelete(@PathVariable int boardno) {
		   logger.info("boardno : " + boardno);
		   pqnaService.deleteBoardList(boardno);
	   }
	 
	 @DeleteMapping("reviewdelete/{boardno}")
	   public void reviewdelete(@PathVariable int boardno) {
		   pqnaService.deleteReview(boardno);
	   }
	 
	 @PostMapping("insert")
	 public void reviewInsert(@RequestBody ProductQnas reviewpage) {
		 logger.info("data : "+reviewpage);
		 pqnaService.insert(reviewpage);
	 }

}
