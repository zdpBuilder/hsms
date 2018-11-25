package com.hsms.service;



import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Store;

public interface StoreService {
   /**
    * 库存列表查询
    * @param keywords
    * @param limit
    * @param page
    * @return
    */
	ResponseJsonPageListBean list(String keywords, int limit,int page);
	/**
	 * 库存 新增 编辑
	 * @param store
	 * @param session
	 * @return
	 */
	int save(Store store,HttpSession session);
	/**
	 * 根据id 查询某个库存的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	Store Show(int id,HttpSession session);
}
