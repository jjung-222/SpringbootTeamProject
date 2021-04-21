package com.mycompany.webapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.NoticesDao;
import com.mycompany.webapp.dto.Notice;
import com.mycompany.webapp.dto.Pager;

@Service
public class NoticesService {
	private static final Logger logger = 
			LoggerFactory.getLogger(NoticesService.class);
	@Autowired
	private NoticesDao noticesDao;
	
	public List<Notice> getBoardList() {
		List<Notice> list = noticesDao.selectAll();
		return list;
	}
	
	public List<Notice> getBoardList(Pager pager) {
		List<Notice> list = noticesDao.selectByPage(pager);
		return list;
	}	
	
	public void saveBoard(Notice notice) {
		logger.info("저장전 bno:"+ notice.getBoardno());
		noticesDao.insert(notice);
		logger.info("저장 후 bno:" + notice.getBoardno());
	}

	public Notice getBoard(int boardno) {
		Notice notice = noticesDao.selectByBoardno(boardno);
		return notice;
	}
	
	public void updateBoard(Notice notice) {
		noticesDao.update(notice);
	}
	
	public void deleteBoard(int boardno) {
		noticesDao.deleteByBoardno(boardno);
	}
	
	public void addHitcount(int boardno) {
		noticesDao.updateBcount(boardno);
	}

	public int getTotalRows() {
		int rows = noticesDao.count();
		return rows;
	}
}
