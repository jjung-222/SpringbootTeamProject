package com.mycompany.webapp.dto;

public class Cart {
	private String userid;
	private int productno;
	private String pname;
	private int pprice;
	private String ioriginalname;
	private String isavename;
	private String imgtype;
	private int cartquantity;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getIoriginalname() {
		return ioriginalname;
	}
	public void setIoriginalname(String ioriginalname) {
		this.ioriginalname = ioriginalname;
	}
	public String getIsavename() {
		return isavename;
	}
	public void setIsavename(String isavename) {
		this.isavename = isavename;
	}
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	public int getCartquantity() {
		return cartquantity;
	}
	public void setCartquantity(int cartquantity) {
		this.cartquantity = cartquantity;
	}
	@Override
	public String toString() {
		return "Cart [userid=" + userid + ", productno=" + productno + ", pname=" + pname + ", pprice=" + pprice
				+ ", ioriginalname=" + ioriginalname + ", isavename=" + isavename + ", imgtype=" + imgtype
				+ ", cartquantity=" + cartquantity + "]";
	}
	
	

	
}
