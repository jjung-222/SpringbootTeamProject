package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Product;

@Mapper
public interface ProductDao {
	public List<Product> pSelectByPage(Pager pager); //상품 전체 조회
	public List<Product> pCategoryByPage(Pager pager); //상품 전체 조회
	
	public void pInsert(Product product); //상품 입력
	public int countAll();
	public int count(int category);
	public void pUpdate(Product product); //상품 업데이트
	public Product pSelectByPno(int productno); //상품인덱스번호 찾기
	public int pDeleteByPno(int productno); //상품 삭제
	public int pUpdateEnable(int productno);
	public List<Product> pSelectBest(); //베스트7 조회
	public List<Product> pSelectDate(); //신상품7 조회
}
