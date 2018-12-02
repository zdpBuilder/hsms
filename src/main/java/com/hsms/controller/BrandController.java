package com.hsms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Brand;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.BrandService;
import com.hsms.utils.Empty4jUtils;

/**
 * 品牌处理
 *
 */
@Controller
@RequestMapping("brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

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

		return brandService.list(keywords, limit, page);

	}

	/**
	 * 
	 * @Description: 保存
	 * @param brand
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Brand brand, HttpSession session) {
		int count = brandService.save(brand, session);

		if (count == 1) {
			return new ResultPojo(1, brand.getId(), "操作成功");
		}
		return new ResultPojo(0, "操作失败");

	}

	/**
	 * 
	 * @Description: 获取品牌信息
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		Brand brand = brandService.getOneById(id);

		if (brand != null) {
			return new ResultPojo(1, brand);
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
		int result = brandService.deleteBatch(idStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
	
	/**
	 * 
	 * @Description: 获取所有品牌
	 * @return
	 */
	@RequestMapping("getList")
	@ResponseBody
	public ResultPojo getList() {
		List<Brand> brandList = brandService.getList();
		if(Empty4jUtils.listIsNotEmpty(brandList))
			return new ResultPojo(1, brandList);
		return new ResultPojo(0, "未找到品牌信息"); 
	}
}
