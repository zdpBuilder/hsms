package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Bill;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.BillService;

@Controller
@RequestMapping("bill")
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer page) {

		return billService.list(keywords, limit, page);

	}

	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Bill bill, HttpSession session) {
		int count = billService.save(bill, session);

		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}

	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id) {
		Bill bill = billService.getOneById(id);

		if (bill != null) {
			return new ResultPojo(1, bill);
		}

		return new ResultPojo(0, "操作失败");

	}

	@RequestMapping("deleteBatch")
	@ResponseBody
	public ResultPojo deleteBatch(String idStr, HttpSession session) {
		int result = billService.deleteBatch(idStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
}
