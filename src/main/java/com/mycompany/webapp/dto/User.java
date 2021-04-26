package com.mycompany.webapp.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class User {
	
	String userid;
	String upassword;
	String uname;
	String uzipcode;
	String uaddress;
	String uemail;
	String utel;
	Date ubirth;
	int uenabled;
	Date ujoindate;
	String uauthority;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUzipcode() {
		return uzipcode;
	}
	public void setUzipcode(String uzipcode) {
		this.uzipcode = uzipcode;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public Date getUbirth() {
		return ubirth;
	}
	public void setUbirth(Date ubirth) {
		this.ubirth = ubirth;
	}

	public Date getUjoindate() {
		return ujoindate;
	}
	public void setUjoindate(Date ujoindate) {
		this.ujoindate = ujoindate;
	}
	public int getUenabled() {
		return uenabled;
	}
	public void setUenabled(int uenabled) {
		this.uenabled = uenabled;
	}
	public String getUauthority() {
		return uauthority;
	}
	public void setUauthority(String uauthority) {
		this.uauthority = uauthority;
	}



	
	
}
