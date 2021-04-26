package com.mycompany.webapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class ProductImgs {
	private int imgno;
	private int productno;
	private MultipartFile pattach;
	private String ioriginalname;
	private String isavename;
	private String imgtype;
	private int ipriority;

	public ProductImgs() {
		
	}
	
	public ProductImgs(String ioriginalname, String isavename, String imgtype, int ipriority) {
		this.ioriginalname = ioriginalname;
		this.isavename = isavename;
		this.imgtype = imgtype;
		this.ipriority = ipriority;
	}
	
	public ProductImgs(MultipartFile pattach) {
		this.pattach = pattach;
	}
	
	public MultipartFile getPattach() {
		return pattach;
	}
	public void setPattach(MultipartFile pattach) {
		this.pattach = pattach;
	}
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
