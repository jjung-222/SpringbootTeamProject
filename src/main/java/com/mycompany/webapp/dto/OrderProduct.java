package com.mycompany.webapp.dto;

import java.util.Date;


public class OrderProduct {
	private int productno;
	private int orderno;
	private int oquantity;
	private String pname;
	private int pprice;
	private String ioriginalname;
	private String isavename;
	private String imgtype;
	
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getOquantity() {
		return oquantity;
	}
	public void setOquantity(int oquantity) {
		this.oquantity = oquantity;
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
	@Override
	public String toString() {
		return "OrderProduct [productno=" + productno + ", orderno=" + orderno + ", oquantity=" + oquantity + ", pname="
				+ pname + ", pprice=" + pprice + ", ioriginalname=" + ioriginalname + ", isavename=" + isavename
				+ ", imgtype=" + imgtype + "]";
	}	
	
	
	
}
	