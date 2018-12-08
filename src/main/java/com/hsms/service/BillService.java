package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Bill;
import com.hsms.pojo.BillDetailPojo;

public interface BillService {
	/**
	 * @Description: 账单列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @param status
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page, int status);

	/**
	 * @Description: 账单 新增 编辑
	 * @param bill
	 * @param session
	 * @return
	 */
	int save(Bill bill, HttpSession session);

	/**
	 * 账单批量删除
	 * 
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);

	/**
	 * @Description: 根据id 查询某个账单的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	Bill getOneById(int id);
	
	/**
	 * 
	 * @Description: 新增
	 * @param bill
	 * @param loginId
	 * @return
	 */
	boolean save(Bill bill, String loginId);
	
	/**
	 * 
	 * @Description: 入库处理
	 * @param loginId
	 * @param bill
	 * @param billDetailList
	 * @return
	 */
	boolean inStore(String loginId, Bill bill, List<BillDetailPojo> billDetailList) throws Exception;
}
