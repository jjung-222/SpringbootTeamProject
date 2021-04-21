package com.mycompany.webapp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.CommunityQnasDao;
import com.mycompany.webapp.dto.CommunityQna;
import com.mycompany.webapp.dto.Pager;

@Service
public class CommunityQnasService {
	private static final Logger logger = 
			LoggerFactory.getLogger(CommunityQnasService.class);
	
	@Autowired
	private CommunityQnasDao communityqnasDao;
	
	public List<CommunityQna> getBoardList(Pager pager) {
		List<CommunityQna> list = communityqnasDao.selectByPage(pager);
		return list;
	} //페이징 처리해서 리스트 불러오기
	
	public CommunityQna getBoard(int boardno) {
		CommunityQna communityqna = communityqnasDao.selectByBoardno(boardno);
		return communityqna;
	} //해당하는 번호의 게시물 가져오기

	public List<CommunityQna> getBoardListById(Pager pager){
		List<CommunityQna> list = communityqnasDao.selectByUserid(pager);
		return list;
	} //userid에 맞는 게시물 가져오기
	
	public List<CommunityQna> getBoardListByKeyword(Pager pager, String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("startRowNo", pager.getStartRowNo());
		map.put("endRowNo", pager.getEndRowNo());
		List<CommunityQna> list = communityqnasDao.selectByKeyword(map);
		return list;
	} //keyword와 searchType에 맞는 리스트 뽑아오기
	
	public void saveBoard(CommunityQna communityqna) {
		logger.info("저장전 bno:"+ communityqna.getBoardno());
		communityqnasDao.insert(communityqna);
		logger.info("저장 후 bno:" + communityqna.getBoardno());
	} // 게시글 생성
	
	public void saveRepl(CommunityQna communityqna) {
		logger.info("저장전 bno:"+ communityqna.getBoardno());
		communityqnasDao.insertrepl(communityqna);
		logger.info("저장 후 bno:" + communityqna.getBoardno());
	}
	
	public void updateBoard(CommunityQna communityqna) {
		communityqnasDao.update(communityqna);
	} // 게시글 수정
	
	public void deleteBoard(int boardno) {
		communityqnasDao.deleteByBoardno(boardno);
	} // 게시글 삭제
	
	public void addBcount(int boardno) {
		communityqnasDao.updateBcount(boardno);
	} // 조회수 증가

	public int getTotalRows() {
		int rows = communityqnasDao.count();
		return rows;
	} //게시글의 갯수 카운트해서 row에 담아줌
	
	public int getTotalRow(String userid) {
		int rows = communityqnasDao.countuser(userid);
		return rows;
	}
	
	public int getTotalRows(String searchType, String keyword) {
		Map<String, String> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		int rows = communityqnasDao.countkeyword(map);
		return rows;
	}

}
