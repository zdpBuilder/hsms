package com.hsms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Store;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.StoreService;
import com.hsms.utils.Empty4jUtils;

/**
 * 
 *仓库处理
 */
@Controller
@RequestMapping("store")
public class StoreController {

	@Autowired
	private StoreService storeService;

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

		return storeService.list(keywords, limit, page);

	}

	/**
	 * 
	 * @Description: 保存
	 * @param store
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Store store, HttpSession session) {
		int count = storeService.save(store, session);

		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}

	/**
	 * 
	 * @Description: 获取某项商品的仓储信息
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		Store store = storeService.getOneById(id);

		if (store != null) {
			return new ResultPojo(1, store);
		}

		return new ResultPojo(0, "操作失败");

	}
	
	// 收入/支出统计
	@RequestMapping("dataCount")
	@ResponseBody
	public ResultPojo intoOutCount(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		return new ResultPojo(1, storeService.dataCount(), "操作成功");
	}
	
	@RequestMapping("validateStore")
	@ResponseBody
	public Boolean validateStore(String goodsCode, Integer specification, Integer boxNum, Integer branchNum) {
		if(Empty4jUtils.stringIsEmpty(goodsCode))
			return false;
		Store store = storeService.getStoreByCode(goodsCode.trim());
		if(null == store)
			return false;
		int balance = store.getRemainBranchNum() + store.getRemainBoxNum()*specification;
		int buySum = branchNum + boxNum * specification;
		if(balance >= buySum)
			return true;
		return false;
	}
}
