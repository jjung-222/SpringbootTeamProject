package com.mycompany.webapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.webapp.dto.Notice;
import com.mycompany.webapp.dto.Pager;

@Mapper
public interface NoticesDao {
	public List<Notice> selectAll();
	public List<Notice> selectByPage(Pager pager);
	public int insert(Notice notice); //안에 board는 board service
	public Notice selectByBoardno(int boardno);
	public int update(Notice notice);
	public int deleteByBoardno(int boardno);
	public int updateBcount(int boardno);
	public int count();
}
