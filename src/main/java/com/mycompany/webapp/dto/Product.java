package com.mycompany.webapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	private int productno;
	private int pcategory;
	private String pname;
	private int pprice;
	private Date pregisterdate;
	private int psalescount;
	private int pstock;
	private String penable;
	private MultipartFile pattach1;
	private MultipartFile pattach2;
	private MultipartFile pattach3;
	private MultipartFile pattach4;
	private MultipartFile pattach5;
	private String detailimgoname;
	private String detailimgsname;
	private String detailimgtype;
	private int imgno;
	private int imgno1;
	private int imgno2;
	private int imgno3;
	private int imgno4;	
	private String ioriginalname;
	private String isavename;
	private String imgtype;
	private String ipriority;
	
	
	public int getImgno1() {
		return imgno1;
	}
	public void setImgno1(int imgno1) {
		this.imgno1 = imgno1;
	}
	public int getImgno2() {
		return imgno2;
	}
	public void setImgno2(int imgno2) {
		this.imgno2 = imgno2;
	}
	public int getImgno3() {
		return imgno3;
	}
	public void setImgno3(int imgno3) {
		this.imgno3 = imgno3;
	}
	public int getImgno4() {
		return imgno4;
	}
	public void setImgno4(int imgno4) {
		this.imgno4 = imgno4;
	}
	public MultipartFile getPattach1() {
		return pattach1;
	}
	public void setPattach1(MultipartFile pattach1) {
		this.pattach1 = pattach1;
	}
	public MultipartFile getPattach2() {
		return pattach2;
	}
	public void setPattach2(MultipartFile pattach2) {
		this.pattach2 = pattach2;
	}
	public MultipartFile getPattach3() {
		return pattach3;
	}
	public void setPattach3(MultipartFile pattach3) {
		this.pattach3 = pattach3;
	}
	public MultipartFile getPattach4() {
		return pattach4;
	}
	public void setPattach4(MultipartFile pattach4) {
		this.pattach4 = pattach4;
	}
	public MultipartFile getPattach5() {
		return pattach5;
	}
	public void setPattach5(MultipartFile pattach5) {
		this.pattach5 = pattach5;
	}
	public int getImgno() {
		return imgno;
	}
	public void setImgno(int imgno) {
		this.imgno = imgno;
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
	public String getIpriority() {
		return ipriority;
	}
	public void setIpriority(String ipriority) {
		this.ipriority = ipriority;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getPcategory() {
		return pcategory;
	}
	public void setPcategory(int pcategory) {
		this.pcategory = pcategory;
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
	public Date getPregisterdate() {
		return pregisterdate;
	}
	public void setPregisterdate(Date pregisterdate) {
		this.pregisterdate = pregisterdate;
	}
	public int getPsalescount() {
		return psalescount;
	}
	public void setPsalescount(int psalescount) {
		this.psalescount = psalescount;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public String getPenable() {
		return penable;
	}
	public void setPenable(String penable) {
		this.penable = penable;
	}
	public String getDetailimgoname() {
		return detailimgoname;
	}
	public void setDetailimgoname(String detailimgoname) {
		this.detailimgoname = detailimgoname;
	}
	public String getDetailimgsname() {
		return detailimgsname;
	}
	public void setDetailimgsname(String detailimgsname) {
		this.detailimgsname = detailimgsname;
	}
	public String getDetailimgtype() {
		return detailimgtype;
	}
	public void setDetailimgtype(String detailimgtype) {
		this.detailimgtype = detailimgtype;
	}
	@Override
	public String toString() {
		return "Product [productno=" + productno + ", pcategory=" + pcategory + ", pname=" + pname + ", pprice="
				+ pprice + ", pregisterdate=" + pregisterdate + ", psalescount=" + psalescount + ", pstock=" + pstock
				+ ", penable=" + penable + ", pattach1=" + pattach1 + ", pattach2=" + pattach2 + ", pattach3="
				+ pattach3 + ", pattach4=" + pattach4 + ", pattach5=" + pattach5 + ", detailimgoname=" + detailimgoname
				+ ", detailimgsname=" + detailimgsname + ", detailimgtype=" + detailimgtype + ", imgno=" + imgno
				+ ", ioriginalname=" + ioriginalname + ", isavename=" + isavename + ", imgtype=" + imgtype
				+ ", ipriority=" + ipriority + "]";
	}
	
	
}
