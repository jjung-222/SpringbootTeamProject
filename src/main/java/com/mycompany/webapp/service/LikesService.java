package com.mycompany.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.LikesDao;
import com.mycompany.webapp.dao.ProductsDao;
import com.mycompany.webapp.dto.Likes;
import com.mycompany.webapp.dto.Products;

@Service
public class LikesService {
	@Autowired
	private LikesDao likesDao;
	@Autowired
	private ProductsDao productsDao;
	
	private static final Logger logger = LoggerFactory.getLogger(LikesService.class);
	
	public List<Likes> likeSelectAll(){
		List<Likes> list = likesDao.likeSelectAll();
		return list;
	}
	
	public List<Products>  likelist(String userid, int startrowindex, int endrowindex ) {
		List<Likes> info = likesDao.SelectById(userid);
		List<Products> products = new ArrayList();
		
		if(endrowindex >= info.size()) {
			endrowindex = info.size()-1;
		}
		for(int i=startrowindex; i<=endrowindex; i++) {
			
			products.add(productsDao.likelistbylike(info.get(i).getProductno()));
		}
		return products;		
	}
	
	public int totalLikelist(String userid) {
		List<Likes> info = likesDao.SelectById(userid);
		int totalrow = info.size();
		return totalrow;
	}
	
	public Likes SelectByIdandPno(String userid, int productNo) {
		Likes likes = likesDao.SelectByIdandPno(userid,productNo);
		
		return likes;
	}
	
	public int lInsert(String userid, int productNo) {
		Likes likes = new Likes();
		likes.setProductno(productNo);
		likes.setUserid(userid);
		int result = likesDao.lInsert(likes);
		return result;
	}
	
	public void lUpdate(Likes likes) {
		likesDao.lUpdate(likes);
	}
	
	public int LDelete(String userid, int pno) {
		Likes likes = new Likes();
		likes.setProductno(pno);
		likes.setUserid(userid);
		int result = likesDao.LDelete(likes);
		return result;
	}
	
	public int allDelete(String userid) {
		int result = likesDao.allDelete(userid);
		
		return result;
	}
}
