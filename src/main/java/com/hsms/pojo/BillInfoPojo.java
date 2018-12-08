package com.hsms.pojo;

import java.util.List;

import com.hsms.model.Bill;
/**
 * 
 * 订单提交信息
 */
public class BillInfoPojo {

	private Bill bill;  //订单信息
	
	private List<BillDetailPojo> billDetailPojoList;  //明细信息

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<BillDetailPojo> getBillDetailPojoList() {
		return billDetailPojoList;
	}

	public void setBillDetailList(List<BillDetailPojo> billDetailPojoList) {
		this.billDetailPojoList = billDetailPojoList;
	}
	
}
