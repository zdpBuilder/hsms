package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.BillDetail;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.BillDetailService;

/**
 * 订单明细处理
 *
 */
@Controller
@RequestMapping("billDetail")
public class BillDetailController {

	@Autowired
	private BillDetailService billDetailService;

	/**
	 * 
	 * @Description: 获取分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer page) {

		return billDetailService.list(keywords, limit, page);

	}

	/**
	 * 
	 * @Description: 保存
	 * @param billDetail
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(BillDetail billDetail, HttpSession session) {
		int count = billDetailService.save(billDetail, session);

		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}

	/**
	 * 
	 * @Description: 获取明细信息
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		BillDetail billDetail = billDetailService.getOneById(id);

		if (billDetail != null) {
			return new ResultPojo(1, billDetail);
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
	public ResultPojo deleteBatch(String idStr, HttpSession session) {
		int result = billDetailService.deleteBatch(idStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
}
