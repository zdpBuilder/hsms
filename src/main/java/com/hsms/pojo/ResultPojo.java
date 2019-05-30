package com.hsms.pojo;

import lombok.Data;

/**
 * 杩斿洖鍊�
 *
 */

public class ResultPojo {

	private Integer status; //0澶辫触锛�1鎴愬姛
	
	private Object data; //杩斿洖鍊�
	
	private String msg; //杩斿洖淇℃伅
	
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ResultPojo() {
		super();
	}
	
	public ResultPojo(Integer status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public ResultPojo(Integer status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	public ResultPojo(Integer status, Object data, String msg) {
		super();
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	
}
