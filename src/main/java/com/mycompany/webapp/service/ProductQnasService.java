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
	
	public List<ProductQnas> pqnaList(Pager pager, int number){
		switch(number) {
		case 1 : return productQnasDao.pqnabnoList(pager);
		case 2 : return productQnasDao.pqnapnameList(pager);
		case 3 : return productQnasDao.pqnabtitleList(pager);
		case 4 : return productQnasDao.pqnauserList(pager);
		case 5 : return productQnasDao.pqnadateList(pager);
		default : return productQnasDao.pqnabnoList(pager);
		}
	}
	
	public List<ProductQnas> pqnaSearchList(Pager pager, int number){
		switch(number) {
		case 1 : return productQnasDao.pqnaPnameList(pager);
		case 2 : return productQnasDao.pqnaTitleList(pager);
		case 3 : return productQnasDao.pqnaUserList(pager);
		default : return productQnasDao.pqnaPnameList(pager);
		}
	}
	
	public int getCount() {
		return productQnasDao.getList();
	}
	public int getPnameCount(String keyword) {
		return productQnasDao.getPnameKeywordList(keyword);
	}
	public int getTitleCount(String keyword) {
		return productQnasDao.getTitleKeywordList(keyword);
	}
	public int getUserCount(String keyword) {
		return productQnasDao.getUserKeywordList(keyword);
	}

	public ProductQnas readBoard(int boardno) {
		return productQnasDao.getBoardPage(boardno);
	}

	public int getReviewCount(int boardno) {
		return productQnasDao.getReviewCount(boardno);
	}

	public List<ProductQnas> getReviewList(Pager pager,int boardno) {
		pager.setBoardno(boardno);
		return productQnasDao.getReviewList(pager);
	}

	public void deleteBoardList(int boardno) {
		productQnasDao.deleteBoardList(boardno);
	}

	public void insert(ProductQnas pqnas) {
		productQnasDao.insert(pqnas);
	}

	public ProductQnas readReview(int boardno) {
		return productQnasDao.readReview(boardno);
		
	}

	public void updateReview(ProductQnas readreview) {
		productQnasDao.updateReview(readreview);
	}

	public void deleteReview(int boardno) {
		productQnasDao.deleteReview(boardno);
		
	}
	
}
