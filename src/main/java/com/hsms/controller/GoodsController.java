package com.hsms.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.GoodsMapper;
import com.hsms.model.Goods;
import com.hsms.model.SysUser;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.GoodService;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;
import com.hsms.utils.JsonPrintUtil;

/**
 * 商品处理
 *
 */
@Controller
@RequestMapping("goods")
public class GoodsController {
	@Autowired
	private GoodService goodService;

	/**
	 * 
	 * @Description: 获取商品列表
	 * @param limit
	 * @param page
	 * @param keywords
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean getList(int limit, int page, String keywords) {
		return goodService.getList(limit, page, keywords);
	}

	/**
	 * 
	 * @Description: 新增和编辑
	 * @param session
	 * @param goods
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(HttpSession session, Goods goods) {
		int count = goodService.save(session, goods);
		if (1 == count)
			return new ResultPojo(1, "操作成功");
		else
			return new ResultPojo(0, "操作失败");
	}

	/**
	 * 
	 * @Description: 删除
	 * @param idStr
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteBatch")
	@ResponseBody
	public ResultPojo deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		if (Empty4jUtils.stringIsNotEmpty(idStr)) {
			try {
				int count = goodService.deleteBatch(session, idStr);
				if (1 == count) {
					return new ResultPojo(1, "操作成功");
				}
				return new ResultPojo(0, "操作失败");
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResultPojo(0, "操作失败");
			}

		}
		return new ResultPojo(0, "数据异常");
	}

	/**
	 * 
	 * @Description: 展示商品信息
	 * @param id
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(int id) {
		Goods goods = goodService.getOneById(id);
		if (null != goods) {
			return new ResultPojo(1, goods);
		}
		return new ResultPojo(0, "未找到此商品信息");
	}
	
	/**
	 * 
	 * @Description: 根据商品编码，获取商品信息
	 * @param code
	 * @return
	 */
	@RequestMapping("getOneByCode")
	@ResponseBody
	public ResultPojo getOneByCode(String code) {
		if(Empty4jUtils.stringIsNotEmpty(code)) {
			Goods goods = goodService.getOneByCode(code);
			if(null != goods)
				return new ResultPojo(1, goods);
		}
		return new ResultPojo(0, "未找到此商品信息");
			
	}

}
