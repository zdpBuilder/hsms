package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Brand;

public interface BrandService {
	/**
	 * @Description: 品牌列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page);

	/**
	 * @Description: 品牌 新增 编辑
	 * @param brand
	 * @param session
	 * @return
	 */
	int save(Brand brand, HttpSession session);

	/**
	 * @Description: 品牌批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);

	/**
	 * @Description: 根据id 查询某个品牌的详细信息
	 * @param id
	 * @return
	 */
	Brand getOneById(int id);

	/**
	 * 
	 * @Description: 获取所有品牌
	 * @return
	 */
	List<Brand> getList();
}
