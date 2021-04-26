package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.User;

@Mapper
public interface UsersDao {
	
	//관리자
	// 관리자가 모든 유저 검색
	public List<User> selectAll ();
	//관리자가 특정 유저 검색
	public User selectbyUserid(String userid);
	//email을 통한 유저 검색
	public User selectbyUemail(String uemail);
	
	//회원가입 (추가)
	public int userInsert(User user);
	
	
	
	public int userpwUpdate (@Param("userid")String userid,@Param("upassword") String upassword);
	
	//회원탈퇴 (status를 수정하는 형태로)
	public int userStatusDisalbed(String Uid);
	
	public int userStatusActivation(String Uid);
	
	public int getcount();
	public int getusercount();
	public List<User> adminlist();
	public int getsearchusercount(@Param("search")String search);
	public int getsearchnamecount(@Param("search")String search);
	public int getsearchemailcount(@Param("search")String search);
	
	public List<User> userList(Pager pager);
	public List<User> dateList(Pager pager);
	public List<User> nameList(Pager pager);
	public List<User> emailList(Pager pager);
	
	public List<User> userSearch(Pager pager);
	public List<User> nameSearch(Pager pager);
	public List<User> emailSearch(Pager pager);
	
}
