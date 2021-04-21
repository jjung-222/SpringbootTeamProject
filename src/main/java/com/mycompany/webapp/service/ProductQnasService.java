package com.mycompany.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.ProductQnasDao;
import com.mycompany.webapp.dto.CommunityQna;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductQnas;

@Service
public class ProductQnasService {
	@Autowired ProductQnasDao productQnasDao;
	public List<ProductQnas> SelectByProductno(Pager pager){
		List<ProductQnas> list = productQnasDao.SelectByProductno(pager);
		return list;
	}
	
	public List<ProductQnas> getBoardListById(Pager pager){
		List<ProductQnas> list = productQnasDao.selectByUserid(pager);
		return list;
	} //userid에 맞는 게시물 가져오기
	
	public void pqnaInsert(ProductQnas productqna) {
		productQnasDao.pqnaInsert(productqna);
	}
	
	public void pqnaUpdate(ProductQnas productqna) {
		productQnasDao.pqnaUpdate(productqna);
	}
	
	public void pqnaDelete(int boardno) {
		productQnasDao.pqnaDelete(boardno);
	}
	
	public int getTotalRows(int productno) {
		int rows = productQnasDao.pqnacount(productno);
		return rows;
	} 
	
	public int getTotalRow(String userid) {
		int rows = productQnasDao.pqnacountuser(userid);
		return rows;
	} 
	
	public void paddBcount(int boardno) {
		productQnasDao.pupdateBcount(boardno);
	} // 조회수 증가
	
	public ProductQnas getBoard(int boardno) {
		ProductQnas productqna = productQnasDao.selectByBoardno(boardno);
		return productqna;
	} //해당하는 번호의 게시물 가져오기
}
