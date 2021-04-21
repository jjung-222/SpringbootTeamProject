package com.mycompany.webapp.dto;

import java.util.List;

public class Likes {
	private int productno;
	private String userid;
	
	private List<Products> productlist;
	
	
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<Products> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Products> productlist) {
		this.productlist = productlist;
	}
}
