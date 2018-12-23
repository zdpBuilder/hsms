package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.BillDetail;
import com.hsms.pojo.BillDetailPojo;

public interface BillDetailService {

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
	 * @param BillDetail
	 * @param session
	 * @return
	 */
	int save(BillDetail BillDetail, HttpSession session);

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
	BillDetail getOneById(int id);
	
	/**
	 * 
	 * @Description: 批量新增
	 * @param billCode
	 * @param billDetailList
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	boolean addList(String billCode, List<BillDetail> billDetailList, String loginId) throws Exception;
    /**
     * @Description: 根据billCode删除相应订单下的订单明细
     * @param billCode
     * @return
     */
	boolean delListByBillCode(String billCode);
	/**
     *  @Description: 根据账单code 查询该账单下的账单明细
     * @param billId
     * @return
     */
	List<BillDetail> getBillDetailBybillCode(String billCode);
	
	/**
	 * 
	 * @Description: 出库新增明细
	 * @param billCode
	 * @param billDetailList
	 * @param loginId
	 * @return
	 * @throws Exception
	 */
	boolean outStoreAddList(String billCode, List<BillDetail> billDetailList, String loginId) throws Exception;
}
