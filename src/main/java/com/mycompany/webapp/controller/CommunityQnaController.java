package com.mycompany.webapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.webapp.dto.CommunityQna;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.CommunityQnasService;

@RestController
@RequestMapping("/community/communityqna") //view의 요청 경로 지정
public class CommunityQnaController {
	private static final Logger logger = LoggerFactory.getLogger(CommunityQnaController.class);

	@Autowired
	private CommunityQnasService communityQnasService;

	@GetMapping("/search") //view의 요청 경로 지정
	public Map<String, Object> communitylist(@RequestParam(defaultValue="1") int pageNo, String searchType, String keyword) {
	//pageNo: 현재 페이지 번호
		logger.info("" + pageNo);
		logger.info(searchType);
		logger.info(keyword);

		int totalRows = communityQnasService.getTotalRows(searchType, keyword);
		Pager pager = new Pager(5, 5, totalRows, pageNo);
		List<CommunityQna> list = communityQnasService.getCList(pager, searchType, keyword);
		
		Map<String, Object> map = new HashMap<>();  //맵 객체
		map.put("pager", pager);
		map.put("communityqnas", list);
		return map;

	}  //페이징 처리된 리스트 목록 가져오기
	
	@PostMapping("")  //막기
	public CommunityQna communitycreate(@RequestBody CommunityQna communityqna) {
		communityQnasService.Cinsert(communityqna);
		
		return communityqna;
	}
	
	@PostMapping("/repl")  //막기
	public CommunityQna communitycreaterepl(@RequestBody CommunityQna communityqna) {
		communityqna.setBcount(0);
		communityqna.setGrouplayer(1);
		communityQnasService.Cinsertrepl(communityqna);
		
		return communityqna;
	}
	
	@GetMapping("/{boardno}")
	public CommunityQna communityview(@PathVariable int boardno) {
		communityQnasService.addCHitcount(boardno);
		CommunityQna communityqna = communityQnasService.getCQna(boardno);
		return communityqna;
	}

	@PutMapping("")  
	public CommunityQna communityupdate(@RequestBody CommunityQna communityqna) {
		communityQnasService.Cupdate(communityqna);
		
		return communityqna;
	}

	@DeleteMapping("/{boardno}")
	public void communitydelete(@PathVariable int boardno) {
		communityQnasService.Cdelete(boardno);		
	}

}