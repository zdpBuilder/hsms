package com.hsms.mapper;

import java.util.List;

import com.hsms.model.BillDetail;

public interface BillDetailCustomMapper {

	int insertList(List<BillDetail> billDetailList);
}
