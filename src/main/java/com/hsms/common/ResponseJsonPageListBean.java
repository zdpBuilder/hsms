package com.hsms.common;

import java.util.List;

import lombok.Data;

//前台页面接收的分页json列表 

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

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
