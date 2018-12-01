package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Supplier;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.SupplierService;
/**
 * 
 *供应商处理
 */
@Controller
@RequestMapping("supplier")
public class SuppilerController {

	@Autowired
	private SupplierService supplierService;

	/**
	 * 
	 * @Description: 分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer page) {

		return supplierService.list(keywords, limit, page);

	}

	/**
	 * 
	 * @Description: 保存
	 * @param supplier
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Supplier supplier, HttpSession session) {
		int count = supplierService.save(supplier, session);

		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}

	/**
	 * 
	 * @Description: 获取供应商信息
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		Supplier supplier = supplierService.getOneById(id);

		if (supplier != null) {
			return new ResultPojo(1, supplier);
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
		int result = supplierService.deleteBatch(idStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
}
