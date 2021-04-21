package com.mycompany.webapp.service;

import java.util.Date;

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

		user.setUjoindate(new Date());

		user.setUenabled(1);

		user.setUauthority("ROLE_USER");
		
		usersDao.userInsert(user);
	}
	/// 아이디가 존재하는지 아닌지 여부를 확인하기 위한 절차
	public String duplicateId(String userid) {
		User dbUser=usersDao.selectbyUserid(userid);
		
		 if(dbUser != null) {
			 return "wrongUid";
		 }		 
		 return "success";
	}

	
	public String duplicateEmail(String useremail) {
		User dbUser = usersDao.selectbyUemail(useremail);
		logger.info(useremail);
		if(dbUser != null) {
			return "existemail";
		}
		
		return "success";
	}
	
	public String finduser(String uemail, String uname) {
		
		User dbUser = usersDao.selectbyemailandname(uemail,uname);
		if(dbUser != null) {
		
			return dbUser.getUserid();
		}else {
			
			return "fail";
		}
	}
	
	public String finduser(String uemail, String uname, String userid ) {
		User dbUser = usersDao.duplicateMaNald(uemail, uname, userid);
		if(dbUser == null) {
			return "fail";
		}else {
			return "success";
		}
	}
	
	public User finduser(String userid) {
		User dbUser = usersDao.selectbyUserid(userid);
		if(dbUser == null) {
			logger.info("null");
			return null;
		}else {
			logger.info("dbuser");
			return dbUser;
		}
	}
	
	public int updateuser(String userid, String userpassword) {
		BCryptPasswordEncoder bpe = new BCryptPasswordEncoder();
		
		int result = usersDao.userpwUpdate(userid, bpe.encode(userpassword));
		
		return result;
	}
	
	public String updateInfo(User user) {
		int result = usersDao.userUpdate(user);
		logger.info(String.valueOf(result));
		if(result == 1) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	public String deleteuser(String userid) {
		int result = usersDao.userStatusUpdate(userid);
		if(result == 1) {
			return "success";
		}else {
			return "fail";
		}
		
	}

	
	


}
