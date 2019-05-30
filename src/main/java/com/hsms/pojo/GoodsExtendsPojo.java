package com.hsms.pojo;

import com.hsms.model.Goods;

import lombok.Data;


public class GoodsExtendsPojo extends Goods{
	private String angName;

	@Override
	public String toString() {
		return "GoodsExtendsPojo [angName=" + angName + "]";
	}

	public String getAngName() {
		return angName;
	}

	public void setAngName(String angName) {
		this.angName = angName;
	}

}
