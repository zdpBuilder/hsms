package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Store;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.StoreService;

@Controller
@RequestMapping("store")
public class StoreController {
  
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer  page) {
		
		return storeService.list(keywords, limit, page);
		
	}
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(Store store, HttpSession session) {
		int count=storeService.save(store, session);
		
		if(count==1) {
			return  new ResultPojo(1,"操作成功");
		}
			return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(Integer id, HttpSession session) {
		 Store store = storeService.Show(id, session);
		 
		 if(store!=null) {
			 return  new ResultPojo(1,store);
		 }
		 
		 return  new ResultPojo(0,"操作失败");
		
	}
}
