package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.ProductImgs;

@Mapper
public interface ProductImgsDao {
	public List<ProductImgs> piSelectAll();
	public int pImgInsert(ProductImgs productimgs);
	public int pImgUpdate(ProductImgs productimgs);
	public int pImgDelete(int imgno);
	public List<ProductImgs> pImgSelectByPno(int productno);
	public ProductImgs pImgSelectByIno(int imageno);	
	public ProductImgs pImgSelectByIno_pri(int productno);
}
