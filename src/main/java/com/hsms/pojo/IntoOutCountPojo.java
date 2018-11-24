package com.hsms.pojo;

import lombok.Data;

@Data
public class IntoOutCountPojo {
	private double intoCount;
	private double outCount;
	private double SumCount;
	private double intoCountPercent;
	private double outCountPercent;
	
	@Override
	public String toString() {
		return "IntoOutCountPojo [intoCount=" + intoCount + ", outCount=" + outCount + ", SumCount=" + SumCount
				+ ", intoCountPercent=" + intoCountPercent + ", outCountPercent=" + outCountPercent + "]";
	}
	
	

}
