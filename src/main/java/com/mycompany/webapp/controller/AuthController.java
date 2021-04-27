package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.dto.User;
import com.mycompany.webapp.security.JwtUtil;
import com.mycompany.webapp.service.UsersService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UsersService usersService;
		
	
		//// 회원리스트 - userid로 정렬
		@GetMapping("/userList")
	   public Map<String,Object> list(@RequestParam(defaultValue="1") int pageNo) {
			
	      int totalRows = usersService.getCount();
	      if(totalRows == 0) {
	    	  totalRows = 1;
	      }
	      Pager pager = new Pager(5, 5, totalRows, pageNo);
	      List<User> list = usersService.userList(pager,1);
	      Map<String,Object> map = new HashMap<>();
	      map.put("pager", pager);
	      map.put("userlist", list);
	      return map;
	   }
	//// 회원리스트 - 가입날짜로 정렬
		@GetMapping("joindate")
		 public Map<String,Object> joindatelist(@RequestParam(defaultValue="1") int pageNo) {
		      int totalRows = usersService.getCount();
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      List<User> list = usersService.userList(pager,3);
		      Map<String,Object> map = new HashMap<>();
		      map.put("pager", pager);
		      map.put("userlist", list);
		      return map;
		   }
	//// 회원리스트 - 이메일로 정렬
		@GetMapping("email")
		 public Map<String,Object> emaillist(@RequestParam(defaultValue="1") int pageNo) {
		      int totalRows = usersService.getCount();
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      List<User> list = usersService.userList(pager,4);
		      Map<String,Object> map = new HashMap<>();
		      map.put("pager", pager);
		      map.put("userlist", list);
		      return map;
		   }
		
		//// 회원리스트 - 이름으로 정렬
		@GetMapping("name")
		 public Map<String,Object> namelist(@RequestParam(defaultValue="1") int pageNo) {
		      int totalRows = usersService.getCount();
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      List<User> list = usersService.userList(pager,2);
		      Map<String,Object> map = new HashMap<>();
		      map.put("pager", pager);
		      map.put("userlist", list);
		      return map;
		   }
		
		//-------------------아래 내용은 검색어를 통해 검색된 검색어 리스트이다
		// user 검색어
		@GetMapping("searchuser")
		 public Map<String,Object> searchuser(@RequestParam(defaultValue="1") int pageNo, String search) {
			
		      logger.info("searchuser : " + search);
		      int totalRows = usersService.getSearchuserCount(search);
		     
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      logger.info("serarchuser : " + totalRows);
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      pager.setKeyword(search);
		      List<User> list = usersService.searchList(pager,1);
		      logger.info("pager : " + pager.getKeyword());
		      Map<String,Object> map = new HashMap<>();
		      map.put("pager", pager);
		      map.put("userlist", list);
		      logger.info("serarchuser : " + list.get(0).getUname());
		      return map;
		   }
		
		// 이름 검색어
		@GetMapping("searchname")
		 public Map<String,Object> searchname(@RequestParam(defaultValue="1") int pageNo, String search ) {
			logger.info("searchname : " + search);
			  Map<String,Object> map = new HashMap<>();
		      int totalRows = usersService.getSearchnameCount(search);
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      pager.setKeyword(search);
		      List<User> list = usersService.searchList(pager,2);
		      map.put("pager", pager);
		      map.put("userlist", list);
		      return map;
		  
		   }
		@GetMapping("searchemail")
		 public Map<String,Object> searchemail(@RequestParam(defaultValue="1") int pageNo,String search) {
			logger.info("searchemail : " + search);
		      int totalRows = usersService.getSearchemailCount(search);
		      if(totalRows == 0) {
		    	  totalRows = 1;
		      }
		      Pager pager = new Pager(5, 5, totalRows, pageNo);
		      pager.setKeyword(search);
		      List<User> list = usersService.searchList(pager,3);
		      Map<String,Object> map = new HashMap<>();
		      map.put("pager", pager);
		      map.put("userlist", list);
		      return map;
		   }
		
		// 로그인
		@PostMapping("/login")
		// json이 {"uid":"user1", "upassword":"12345"} 이런식으로 넘어 왔을때
		public Map<String, String> login(@RequestBody Map<String, String> user) { //데이터 넘기는 세가지 방법 xww form json-requestbody로 받아야함
			//인증 데이터 얻기
			String uid = user.get("userid"); //홈페이지 입력값 받아온것
			String upassword = user.get("upassword");
			
			//User useremail = new User(); //받아오기 위해 껍데기를 만들어줌
			//useremail = usersService.getuser(uid); //껍데기에 내용을 채워넣어줌
			//String email =useremail.getUemail(); //그 내용에서 이메일만 가져옴
			User user1 = usersService.getuser(uid);
		
			String email = user1.getUemail();
			String uname = user1.getUname();
			
			//사용자 인증
			UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(uid, upassword);
			Authentication authentication = authenticationManager.authenticate(upat); //인증이 성공하면 authentiaction을 리턴
			//세션에 저장
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			//jwt 생성
			String jwt = JwtUtil.createToken(uid);
			
			Map<String, String> map = new HashMap<>(); //data.uid
			map.put("uid", uid);
			map.put("authToken", jwt);
			map.put("email", email);
			map.put("uname", uname);
			
			return map;
		}
		
		
	
		
		/// 회원 비활성화 -> 활성화
	   @PutMapping("activate/{userid}")
	   public void activate(@PathVariable String userid) {
		   usersService.activate(userid);
	   }
	   // 회원 활성화 -> 비활성화
	   @PutMapping("disabled/{userid}")
	   public void disabled(@PathVariable String userid) {
		   usersService.disabled(userid);
	   }
	   // 회원 비밀번호 초기화
	   @PutMapping("update/{userid}")
	   public void update(@PathVariable String userid) {
		   logger.info("userid : " + userid);
		   usersService.update(userid);
	   }

	   @PostMapping("/join")
	   public Map<String, String>join(@RequestBody User user) {

	      logger.info(user.getUname());
	      logger.info(user.getUauthority());
	      //회원가입 처리
	      String idresult = usersService.duplicateId(user.getUserid());
	      Map<String,String> map = new HashMap<>();
	      if(idresult.equals("success")) {            
	      usersService.join(user);
	     map.put("result", "success");
	      } else {
	          map.put("result", "fail");
	      }
	      
	      return map;

	   }
	   
	   @GetMapping("/count")
	   public int userCount() {
		  int usercount = usersService.getUserCount();
		   return usercount;
	   }
	   
	   @GetMapping("/list")
	   public List<User> getlist() {
		   List<User> user=usersService.adminlist();
		   return user;

	   }
}


