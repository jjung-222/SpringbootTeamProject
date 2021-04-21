package com.mycompany.webapp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.OrderProduct;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.Products;

@Mapper
public interface ProductsDao {
	public List<Products> pSelectAll(); //상품 전체 조회
	public List<Products> pSelectBest(); //베스트5 조회
	public List<Products> pSelectDate(); //신상품5 조회
	
	public List<Products> pSelectByPage(Pager pager);//페이징 처리	
	public int count(int pcategory); //상품 전체 행수
	public int countAll();
	
	public List<Products> pSelectBestPager(Pager pager);
	public List<Products> pSelectDatePager(Pager pager);	
	public List<Products> countDate(Pager pager); //날짜순 정렬
	public List<Products> countName(Pager pager); //이름순 정렬
	public List<Products> countLow(Pager pager); //가격순 정렬
	public List<Products> countHigh(Pager pager); //가격순 정렬
	
	public int pInsert(Products products); //상품 입력
	public int pUpdate(Products products); //상품 업데이트
	public Products pSelectByPno(int productno); //상품인덱스번호 찾기
	public int pDeleteByPno(int productno); //상품 삭제

	
	
	//연정 검색
	public List<Products> pSelectBySearchword(Map<String, Object> map);
	public int countsearchword(String searchword);
	//연정 검색
	
	
	public Products likelistbylike(@Param("productno") int productno);
}
