package com.hsms.common;

import java.util.List;

import lombok.Data;

//前台页面接收的分页json列表 
@Data
public class ResponseJsonPageListBean {

	private int code;
	private String msg;
	private int count;
	private List<?> data;
	
	public ResponseJsonPageListBean() {
		super();
	}
	
	public ResponseJsonPageListBean(int code, String msg, int count, List<?> data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

}
