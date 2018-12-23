package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Bill;
import com.hsms.model.SysUser;
import com.hsms.pojo.BillInfoPojo;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.BillService;
import com.hsms.utils.Const;
import com.hsms.utils.Empty4jUtils;
import com.hsms.utils.JsonUtils;

/**
 * 
 * 订单处理
 */
@Controller
@RequestMapping("bill")
public class BillController {

	@Autowired
	private BillService billService;
	
	/**
	 * 
	 * @Description: 获取订单分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @param status
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer page, Integer status,String startDate,String endDate) {

		return billService.list(keywords, limit, page, status,startDate,endDate);

	}

	/**
	 * 
	 * @Description: 保存订单
	 * @param bill
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Bill bill, HttpSession session) {
		int count = billService.save(bill, session);

		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}
	
	
	/**
	 * @Description: 根据订单code查询订单和订单详细信息
	 * @param billCode
	 * @return
	 */
	@RequestMapping("getBillIncludeBillDetailByBillCode")
	@ResponseBody
	public ResultPojo getBillIncludeBillDetailByBillCode(String billCode) {
		BillInfoPojo billInfoPojo = billService.getBillIncludeBillDetailByBillCode(billCode);

		if (billInfoPojo != null) {
			return new ResultPojo(1, billInfoPojo);
		}

		return new ResultPojo(0, "操作失败");

	}
	
	/**
	 * 
	 * @Description: 获取订单信息
	 * @param id
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id) {
		Bill bill = billService.getOneById(id);

		if (bill != null) {
			return new ResultPojo(1, bill);
		}

		return new ResultPojo(0, "操作失败");

	}

	/**
	 * 
	 * @Description: 批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteBatch")
	@ResponseBody
	public ResultPojo deleteBatch(String codeStr, HttpSession session) {
		int result = billService.deleteBatch(codeStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
	
	/**
	 * 
	 * @Description: 入库订单
	 * @param formData
	 * @param session
	 * @return
	 */
	@RequestMapping("inStore")
	@ResponseBody
	public ResultPojo inStore(String formData, HttpSession session) {
		if(Empty4jUtils.stringIsNotEmpty(formData)) {
			SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
			BillInfoPojo billInfo = JsonUtils.jsonToPojo(formData, BillInfoPojo.class);
			if(null !=billInfo && null != billInfo.getBill() 
					&& Empty4jUtils.listIsNotEmpty(billInfo.getBillDetailList())) {
				boolean result = false;
				//异常处理
				try {
					result = billService.inStore(currentLoginUser.getLoginId(), billInfo.getBill(), billInfo.getBillDetailList());
				} catch (Exception e) {
					e.printStackTrace();
					new ResultPojo(0, "操作失败");
				}
				
				if(result)
					return new ResultPojo(1, "操作成功");
			}
		}
		return new ResultPojo(0, "操作失败");
	}
	
	/**
	 * 商品出库
	 * @Description: 
	 * @param formData
	 * @param session
	 * @return
	 */
	@RequestMapping("outStore")
	@ResponseBody
	public ResultPojo outStore(String formData, HttpSession session) {
		if(Empty4jUtils.stringIsNotEmpty(formData)) {
			SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
			BillInfoPojo billInfo = JsonUtils.jsonToPojo(formData, BillInfoPojo.class);
			if(null !=billInfo && null != billInfo.getBill() 
					&& Empty4jUtils.listIsNotEmpty(billInfo.getBillDetailList())) {
				boolean result = false;
				//异常处理
				try {
					result = billService.inStore(currentLoginUser.getLoginId(), billInfo.getBill(), billInfo.getBillDetailList());
				} catch (Exception e) {
					e.printStackTrace();
					new ResultPojo(0, "操作失败");
				}
				
				if(result)
					return new ResultPojo(1, "操作成功");
			}
		}
		return new ResultPojo(0, "操作失败");
	}
}
