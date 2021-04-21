package com.mycompany.webapp.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Likes;

import com.mycompany.webapp.dto.User;

@Mapper
public interface LikesDao {
	public List<Likes> likeSelectAll(); //좋아요 전체선택
	public int lInsert(Likes likes);
	public int lUpdate(Likes likes);
	public int LDelete(Likes likes);
	public int allDelete(@Param("userid")String userid);
	public Likes getProducts();
	public List<Likes> SelectById(@Param("userid")String userid);
	public Likes SelectByIdandPno(@Param("userid")String userid,@Param("productno") int productno);
	
}
