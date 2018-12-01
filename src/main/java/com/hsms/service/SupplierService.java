package com.hsms.service;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Supplier;

public interface SupplierService {
	/**
	 * @Description: 供应商列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page);

	/**
	 * @Description: 供应商 新增 编辑
	 * @param supplier
	 * @param session
	 * @return
	 */
	int save(Supplier supplier, HttpSession session);

	/**
	 * @Description: 供应商批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);

	/**
	 * @Description: 根据id 查询某个供应商的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	Supplier getOneById(int id);
}
