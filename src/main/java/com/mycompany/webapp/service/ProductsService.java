package com.mycompany.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductsDao;
import com.mycompany.webapp.dto.OrderProduct;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Products;

@Service
public class ProductsService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductsService.class);
	@Autowired ProductsDao productsDao;
	public List<Products> pSelectAll(){
		List<Products> list = productsDao.pSelectAll();
		return list;
	}	
	
	public List<Products> pSelectBest() {
		List<Products> list = productsDao.pSelectBest();
		return list;
	}
	
	public List<Products> pSelectDate() {
		List<Products> list = productsDao.pSelectDate();
		return list;
	}
	
	public List<Products> pSelectBestPager(Pager pager){
		List<Products> list = productsDao.pSelectBestPager(pager);
		return list;
	}
	
	public List<Products> pSelectDatePager(Pager pager){
		List<Products> list = productsDao.pSelectDatePager(pager);
		return list;
	}
	
	public List<Products> pSelectAll(Pager pager){
		List<Products> list = productsDao.pSelectByPage(pager);
		return list;
	}	
	
	public int getTotalRows(int pcategory) {
		int rows = productsDao.count(pcategory);
		return rows;
	}
	public int getTotalRowsAll() {
		int rows = productsDao.countAll();
		return rows;
	}

	
	public List<Products> getTotalDate(Pager pager) {
		List<Products> rows = productsDao.countDate(pager);
		return rows; 
	}
	public List<Products> getTotalName(Pager pager) {
		List<Products> rows = productsDao.countName(pager);
		return rows; 
	}

	public List<Products> getTotalLow(Pager pager) {
		List<Products> rows = productsDao.countLow(pager);
		return rows; 
	}

	public List<Products> getTotalHigh(Pager pager) {
		List<Products> rows = productsDao.countHigh(pager);
		return rows; 
	}

	public void pInsert(Products products) {
		productsDao.pInsert(products);
	};
	
	public void pUpdate(Products products) {
		logger.info(products.getPname());
		productsDao.pUpdate(products);
	};
	
	public Products pSelectByPno(int productno){ 
		Products products = productsDao.pSelectByPno(productno); 
		return products; 
	};
	 	
	public void pDeleteByPno(int productno) {
		productsDao.pDeleteByPno(productno);
	}
	
	
	
	//연정 검색
	public List<Products> pSelectBySearchword(Pager pager, String searchword){
		Map<String, Object> map = new HashMap<>();
		map.put("searchword", searchword);
		map.put("startRowNo", pager.getStartRowNo());
		map.put("endRowNo", pager.getEndRowNo());
		List<Products> list = productsDao.pSelectBySearchword(map);

		return list;
	}	
	public int getTotalRowsSearchword(String searchword) {
		int rows = productsDao.countsearchword(searchword);
		return rows;
	}
	
	

}
