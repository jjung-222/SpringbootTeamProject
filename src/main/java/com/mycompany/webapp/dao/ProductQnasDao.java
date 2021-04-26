package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.ProductQnas;

@Mapper
public interface ProductQnasDao {
	
	public List<ProductQnas>pqnabnoList(Pager pager);
	public List<ProductQnas>pqnabtitleList(Pager pager);
	public List<ProductQnas>pqnauserList(Pager pager);
	public List<ProductQnas>pqnadateList(Pager pager);
	public List<ProductQnas>pqnapnameList(Pager pager);
	public int getList();
	public int getPnameKeywordList(@Param("keyword") String keyword);
	public int getTitleKeywordList(@Param("keyword") String keyword);
	public int getUserKeywordList(@Param("keyword") String keyword);
	public List<ProductQnas> pqnaPnameList(Pager pager);
	public List<ProductQnas> pqnaTitleList(Pager pager);
	public List<ProductQnas> pqnaUserList(Pager pager);
	public ProductQnas getBoardPage(@Param("boardno") int boardno);
	public int getReviewCount(@Param("boardno") int boardno);
	public List<ProductQnas> getReviewList(Pager pager);
	public void deleteBoardList(@Param("boardno") int boardno);
	public int insert(ProductQnas pqnas);
	public ProductQnas readReview(@Param("boardno") int boardno);
	public void updateReview(ProductQnas readreview);
	public void deleteReview(@Param("boardno") int boardno);
	
}
