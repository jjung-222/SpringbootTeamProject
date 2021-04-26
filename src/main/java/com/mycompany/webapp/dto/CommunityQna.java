package com.mycompany.webapp.dto;

import java.util.Date;

public class CommunityQna {
	private int boardno;
	private String userid;
	private String btitle;
	private Date bdate;
	private String bcontent;
	private int bcount;
	private int originno;
	private int status;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	private int grouplayer;
	
	public int getOriginno() {
		return originno;
	}
	public void setOriginno(int originno) {
		this.originno = originno;
	}
	public int getGrouplayer() {
		return grouplayer;
	}
	public void setGrouplayer(int grouplayer) {
		this.grouplayer = grouplayer;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	@Override
	public String toString() {
		return "CommunityQna [boardno=" + boardno + ", userid=" + userid + ", btitle=" + btitle + ", bdate=" + bdate
				+ ", bcontent=" + bcontent + ", bcount=" + bcount + ", originno=" + originno + ", groupord=" + status
				+ ", grouplayer=" + grouplayer + "]";
	}
	
}
