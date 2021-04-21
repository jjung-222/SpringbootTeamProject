package com.mycompany.webapp.dto;

public class ProductImgs {
	private int imgno;
	private int productno;
	private String ioriginalname;
	private String isavename;
	private String imgtype;
	private int ipriority;

	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
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
	public int getIpriority() {
		return ipriority;
	}
	public void setIpriority(int ipriority) {
		this.ipriority = ipriority;
	}
}
