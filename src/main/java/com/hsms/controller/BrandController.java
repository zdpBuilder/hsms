package com.hsms.controller;

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

@Controller
@RequestMapping("brand")
public class BrandController {
  
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer  page) {
		
		return brandService.list(keywords, limit, page);
		
	}
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Brand brand, HttpSession session) {
		int count=brandService.save(brand, session);
		
		if(count==1) {
			return  new ResultPojo(1,"操作成功");
		}
			return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		 Brand brand = brandService.Show(id, session);
		 
		 if(brand!=null) {
			 return  new ResultPojo(1,brand);
		 }
		 
		 return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("deleteBatch")
	@ResponseBody
	public ResultPojo deleteBatch(String idStr,HttpSession session) {
	    int result = brandService.deleteBatch(idStr, session);
		
	    if(result==1) {
			 return  new ResultPojo(1,"操作成功");	
	    }
		 return  new ResultPojo(0,"操作失败");
	}
}
