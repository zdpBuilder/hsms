package com.hsms.pojo;

import java.util.List;

import com.hsms.model.Bill;
import com.hsms.model.BillDetail;
/**
 * 
 * 订单提交信息
 */
public class BillInfoPojo {

	private Bill bill;  //订单信息
	
	private List<BillDetail> billDetailList;  //明细信息

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<BillDetail> getBillDetailList() {
		return billDetailList;
	}

	public void setBillDetailList(List<BillDetail> billDetailList) {
		this.billDetailList = billDetailList;
	}


	
}
