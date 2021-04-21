package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductQnas;

@Mapper
public interface ProductQnasDao {
	public List<ProductQnas> SelectByProductno(Pager pager); //게시판 목록 전체
	public ProductQnas selectByBoardno(int boardno); //번호에 해당하는 board를 가져옴
	public List<ProductQnas> selectByUserid(Pager pager);
	public int pqnaInsert(ProductQnas productqnas); //게시판 입력
	public int pqnaUpdate(ProductQnas productqnas); //게시판 업데이트
	public int pqnaDelete(int boardno); //게시판 삭제
	public int pqnacount(int productno);
	public int pqnacountuser(String userid);
	public int pupdateBcount(int boardno);
	
}
