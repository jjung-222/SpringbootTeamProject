package com.mycompany.webapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class ImgList {
	private MultipartFile pattach1;
	private MultipartFile pattach2;
	private MultipartFile pattach3;
	private MultipartFile pattach4;
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

	
	
	
}
