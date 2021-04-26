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

	@Autowired
	private CommunityQnasDao communityqnasDao;
	
	public int getCcount(Map<String, Object> map) {
		return communityqnasDao.count(map);
	} //게시글의 갯수 카운트해서 row에 담아줌
	
	public CommunityQna getCQna(int boardno) {
		CommunityQna communityqna = communityqnasDao.selectByBoardno(boardno);
		return communityqna;
	} //해당하는 번호의 게시물 가져오기

	public List<CommunityQna> getCListById(Pager pager){
		return communityqnasDao.selectByUserid(pager);
	} //userid에 맞는 게시물 가져오기
	
	public List<CommunityQna> getCList(Pager pager, String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		map.put("startRowNo", pager.getStartRowNo());
		map.put("endRowNo", pager.getEndRowNo());
		List<CommunityQna> list = communityqnasDao.selectByPage(map);
		return list;
	} //keyword와 searchType에 맞는 리스트 뽑아오기
	
	public int Cinsert(CommunityQna communityqna) {
		return communityqnasDao.insert(communityqna);
	} // 게시글 생성
	
	public int Cinsertrepl(CommunityQna communityqna) {
		return communityqnasDao.insertrepl(communityqna);
	} // 게시글 생성
	
	public int Cdelete(int boardno) {
		return communityqnasDao.deleteByBoardno(boardno);
	} // 게시글 삭제
	
	public int Cupdate(CommunityQna communityqna) {
		return communityqnasDao.update(communityqna);
	} // 게시글 수정

	public int addCHitcount(int boardno) {
		return communityqnasDao.updateBcount(boardno);
	} // 조회수 증가

	public int getTotalRow(String userid) {
		int rows = communityqnasDao.countuser(userid);
		return rows;
	}
	
	public int getTotalRows(String searchType, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("keyword", keyword);
		
		int rows = communityqnasDao.count(map);
		return rows;
	}

}
