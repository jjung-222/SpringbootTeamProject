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

import com.mycompany.webapp.dto.Notice;
import com.mycompany.webapp.dto.Pager;
import com.mycompany.webapp.service.NoticesService;

@RestController
@RequestMapping("/community/notice")
public class NoticeController {
	private static final Logger logger =
			LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticesService noticesService;
	
	@GetMapping("")
	public Map<String, Object> noticelist(@RequestParam(defaultValue="1") int pageNo) {
		int totalRows = noticesService.getCount();
		Pager pager = new Pager(5, 5, totalRows, pageNo);
		List<Notice> list = noticesService.getList(pager);
		Map<String, Object> map = new HashMap<>();  //맵 객체
		map.put("pager", pager);
		map.put("notices", list);
		return map; //그냥은 view이름이지만 rest일경우 json의 데이터가 리턴된다.
	}
	
	@PostMapping("") //------------------------>막아줘
	public Notice noticecreate(@RequestBody Notice notice) {
		noticesService.insert(notice);
	
		return notice;
	}
	
	@GetMapping("/{boardno}") //------------------------>막아줘
	public Notice noticeview(@PathVariable int boardno) {
		noticesService.addHitcount(boardno);
		Notice notice = noticesService.getNotice(boardno);
		return notice;
	}
	
	@PutMapping("") //------------------------>막아줘
	public Notice noticeupdate(@RequestBody Notice notice) {
		noticesService.update(notice);
		return notice;
	}
	
	@DeleteMapping("/{boardno}") //------------------------>막아줘
	public void noticedelete(@PathVariable int boardno) {
		noticesService.delete(boardno);
	}
	
}
