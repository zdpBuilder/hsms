package com.hsms.service;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.BillDetial;

public interface BillDetialService {

	/**
	 * 
	 * @Description: 账单明细列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page);

	/**
	 * 
	 * @Description: 账单明细 新增 编辑
	 * @param billDetial
	 * @param session
	 * @return
	 */
	int save(BillDetial billDetial, HttpSession session);

	/**
	 * @Description: 账单明细批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);

	/**
	 * @Description: 根据id 查询某个账单明细的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	BillDetial getOneById(int id);
}
