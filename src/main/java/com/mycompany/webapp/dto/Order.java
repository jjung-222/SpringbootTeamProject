package com.mycompany.webapp.dto;

import java.util.Date;
import java.util.List;

public class Order {
	private int orderno;
	private String userid;
	private String oaddress;
	private String oreceiver;
	private String onumber;
	private String omessage;
	private String omethod;
	private Date odate;
	private String ostatus;
	private int ozipcode;
	private List<OrderProduct> orderproductlist;
	
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOaddress() {
		return oaddress;
	}
	public void setOaddress(String oaddress) {
		this.oaddress = oaddress;
	}
	public String getOreceiver() {
		return oreceiver;
	}
	public void setOreceiver(String oreceiver) {
		this.oreceiver = oreceiver;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public String getOmessage() {
		return omessage;
	}
	public void setOmessage(String omessage) {
		this.omessage = omessage;
	}
	public String getOmethod() {
		return omethod;
	}
	public void setOmethod(String omethod) {
		this.omethod = omethod;
	}
	public Date getOdate() {
		return odate;
	}
	public void setOdate(Date odate) {
		this.odate = odate;
	}
	public String getOstatus() {
		return ostatus;
	}
	public void setOstatus(String ostatus) {
		this.ostatus = ostatus;
	}
	public int getOzipcode() {
		return ozipcode;
	}
	public void setOzipcode(int ozipcode) {
		this.ozipcode = ozipcode;
	}
	public List<OrderProduct> getOrderproductlist() {
		return orderproductlist;
	}
	public void setOrderproductlist(List<OrderProduct> orderproductlist) {
		this.orderproductlist = orderproductlist;
	}
	@Override
	public String toString() {
		return "Order [orderno=" + orderno + ", userid=" + userid + ", oaddress=" + oaddress + ", oreceiver="
				+ oreceiver + ", onumber=" + onumber + ", omessage=" + omessage + ", omethod=" + omethod + ", odate="
				+ odate + ", ostatus=" + ostatus + ", ozipcode=" + ozipcode + ", orderproductlist=" + orderproductlist
				+ "]";
	}
	
	
	
	
	
	
	
	
	
}
