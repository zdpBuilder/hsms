package com.hsms.pojo;

import com.hsms.model.Goods;

import lombok.Data;

@Data
public class GoodsExtendsPojo extends Goods{
	private String angName;

	@Override
	public String toString() {
		return "GoodsExtendsPojo [angName=" + angName + "]";
	}

}
