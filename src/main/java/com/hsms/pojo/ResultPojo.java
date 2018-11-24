package com.hsms.pojo;

import lombok.Data;

/**
 * 返回值
 *
 */
@Data
public class ResultPojo {

	private Integer status; //0失败，1成功
	
	private Object data; //返回值
	
	private String msg; //返回信息
	
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
	
}
