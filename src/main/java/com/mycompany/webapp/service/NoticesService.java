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
	@Autowired
	private NoticesDao noticesDao;
	
	public List<Notice> getList(Pager pager) {	
		return noticesDao.selectByPage(pager);
	}	
	
	public int getCount() {
		return noticesDao.count();
	}

	public Notice getNotice(int boardno) {
		Notice notice = noticesDao.selectByBoardno(boardno);
		return notice;
	}
	
	public int insert(Notice notice) {
		return noticesDao.insert(notice);
	}

	public int delete(int boardno) {
		return noticesDao.deleteByBoardno(boardno);
	}
	
	public int update(Notice notice) {
		return noticesDao.update(notice);
	}
	
	public int addHitcount(int boardno) {
		return noticesDao.updateBcount(boardno);
	}

	
}
