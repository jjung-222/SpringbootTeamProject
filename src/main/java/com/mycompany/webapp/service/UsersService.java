package com.mycompany.webapp.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.UsersDao;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.User;

@Service
public class UsersService {
	
	private static final Logger logger =
			LoggerFactory.getLogger(UsersService.class);
	
	@Autowired
	private UsersDao usersDao;

	
	/// 회원가입 시 회원추가
	public void join(User user) {

		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		user.setUpassword(bpe.encode(user.getUpassword()));
		//bpe.encode는 암호화
		user.setUjoindate(new Date());

		user.setUenabled(1);

		user.setUauthority("ROLE_ADMIN");
		
		usersDao.userInsert(user);
	}
	
	public User getuser(String userid) {
		return usersDao.selectbyUserid(userid);
	}

	
	public void disabled(String userid) {
		int result = usersDao.userStatusDisalbed(userid);
		
	}
	
	public void activate(String userid) {
		int result = usersDao.userStatusActivation(userid);
		
	}
	public int getCount() {
		return usersDao.getcount();
	}
	
	public int getSearchuserCount(String search) {
		return usersDao.getsearchusercount(search);
	}
	public int getSearchnameCount(String search) {
		return usersDao.getsearchnamecount(search);
	}
	public int getSearchemailCount(String search) {
		return usersDao.getsearchemailcount(search);
	}
	
	public List<User> userList(Pager pager, int number){
		switch(number) {
		//case에 따라 아이디, 이름, 가입날짜, 이메일 순으로 정렬된 데이터를 가져온다
		case 1 : return usersDao.userList(pager);
		case 2 : return usersDao.nameList(pager);
		case 3 : return usersDao.dateList(pager);
		case 4 : return usersDao.emailList(pager);
		default: return usersDao.userList(pager); 
		}
		
	}
	
	public List<User> searchList(Pager pager, int number){
		
		switch(number) {
		//case에 따라 아이디, 이름, 가입날짜, 이메일 순으로 검색된 데이터를 가져온다
		case 1 : return usersDao.userSearch(pager);
		case 2 : return usersDao.nameSearch(pager);
		case 3 : return usersDao.emailSearch(pager);
		default: return usersDao.userSearch(pager); 
		}
		
	}
	
	public void update (String userid) {
		//logger.info("password : " + user.getUpassword());
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		String password = userid + "team5";
		password = bpe.encode(password);
		usersDao.userpwUpdate(userid, password);
	}
	
	public String duplicateId(String userid) {
		User dbUser=usersDao.selectbyUserid(userid);
		
		 if(dbUser != null) {
			 return "wrongUid";
		 }		 
		 return "success";
	}

	  
	
	


}
