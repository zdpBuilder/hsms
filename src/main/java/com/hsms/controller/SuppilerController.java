package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Supplier;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.SupplierService;

@Controller
@RequestMapping("supplier")
public class SuppilerController {
  
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("list")
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer  page) {
		
		return supplierService.list(keywords, limit, page);
		
	}
	@RequestMapping("save")
	public ResultPojo save(Supplier supplier, HttpSession session) {
		int count=supplierService.save(supplier, session);
		
		if(count==1) {
			return  new ResultPojo(1,"操作成功");
		}
			return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("show")
	public ResultPojo show(Integer id, HttpSession session) {
		Supplier supplier = supplierService.Show(id, session);
		 
		 if(supplier!=null) {
			 return  new ResultPojo(1,supplier);
		 }
		 
		 return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("deleteBatch")
	public ResultPojo deleteBatch(String idStr,HttpSession session) {
	    int result = supplierService.deleteBatch(idStr, session);
		
	    if(result==1) {
			 return  new ResultPojo(1,"操作成功");	
	    }
		 return  new ResultPojo(0,"操作失败");
	}
}
