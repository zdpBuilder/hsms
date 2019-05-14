package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.BillDetail;
import com.hsms.model.Store;
import com.hsms.pojo.DataCountPojo;

public interface StoreService {
	/**
	 * @Description: 库存列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page);

	/**
	 * @Description: 库存 新增 编辑
	 * @param store
	 * @param session
	 * @return
	 */
	int save(Store store, HttpSession session);

	/**
	 * @Description: 根据id 查询某个库存的详细信息
	 * @param id
	 * @param session
	 * @return
	 */
	Store getOneById(int id);
	
	/**
	 * 
	 * @Description: 商品入库
	 * @param billDetailList
	 * @param loginId
	 * @return
	 */
	boolean addList(List<BillDetail> billDetailList, String loginId);
	
	boolean restoreStoreList(String billCode, String loginId);
	
	/**
	 * 
	 * @Description: 商品出库
	 * @param billDetailList
	 * @param loginId
	 * @param sumTransaction
	 * @return
	 */
	boolean outStoreAddList(List<BillDetail> billDetailList, String loginId, Double sumTransaction);
   
	/**
	 * 
	 * @Description: 收入支出数据统计
	 * @return 
	 */
	DataCountPojo dataCount();
	
	Store getStoreByCode(String goodsCode);

}
