package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductImgsDao;
import com.mycompany.webapp.dto.ProductImgs;

@Service
public class ProductImgsService {
	@Autowired ProductImgsDao productImgsDao;
	public List<ProductImgs> piSelectAll(){
		List<ProductImgs> list = productImgsDao.piSelectAll();
		return list;
	}
	
	public void pImgInsert(ProductImgs productimgs) {
		productImgsDao.pImgInsert(productimgs);
	}
	
	public void pImgUpdate(ProductImgs productimgs) {
		productImgsDao.pImgUpdate(productimgs);
	}
	
	public void pImgDelete(int imgno) {
		productImgsDao.pImgDelete(imgno);
	}
	public List<ProductImgs> pImgSelectByPno(int productno) {
		List<ProductImgs> productImgs = productImgsDao.pImgSelectByPno(productno);
		return productImgs;
	}
	
	public ProductImgs pImgSelectByIno(int imageno) {
		ProductImgs productImg = productImgsDao.pImgSelectByIno(imageno);
		return productImg;
	}
	

	
	
}
