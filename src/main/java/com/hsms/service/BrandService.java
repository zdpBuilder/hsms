package com.hsms.service;



import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Brand;

public interface BrandService {
   /**
    * 品牌列表查询
    * @param keywords
    * @param limit
    * @param page
    * @return
    */
	ResponseJsonPageListBean list(String keywords, int limit,int page);
	/**
	 * 品牌 新增 编辑
	 * @param brand
	 * @param session
	 * @return
	 */
	int save(Brand brand,HttpSession session);
	/**
	 * 品牌批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr,HttpSession session);
	/**
	 * 根据id 查询某个品牌的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	Brand Show(int id,HttpSession session);
}