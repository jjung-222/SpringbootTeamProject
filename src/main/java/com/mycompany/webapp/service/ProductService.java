package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Product;
import com.mycompany.webapp.dto.Products;
import com.mycompany.webapp.dto.Product;

@Service
public class ProductService {
   @Autowired
   private ProductDao productDao;
	public List<Product> pSelectByPage(Pager pager){
		return productDao.pSelectByPage(pager);		
	}
	public void pInsert(Product product) {
		productDao.pInsert(product);
	};
	
   public int getCount() {
	   return productDao.count();
   }
	
	public void pUpdate(Product product) {
		productDao.pUpdate(product);
	};
	
	public Product pSelectByPno(int productno){ 
		Product product = productDao.pSelectByPno(productno); 
		return product; 
	};
	 	
	public void pDeleteByPno(int productno) {
		productDao.pDeleteByPno(productno);
	}
	
	public void pUpdateEnable(int productno) {
		productDao.pUpdateEnable(productno);
	}
		
}
