package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.BillDetial;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.BillDetialService;

@Controller
@RequestMapping("billDetialDetial")
public class BillDetialController {
  
	@Autowired
	private BillDetialService billDetialService;
	
	@RequestMapping("list")
	public ResponseJsonPageListBean List(String keywords, Integer limit, Integer  page) {
		
		return billDetialService.list(keywords, limit, page);
		
	}
	@RequestMapping("save")
	public ResultPojo save(BillDetial billDetial, HttpSession session) {
		int count=billDetialService.save(billDetial, session);
		
		if(count==1) {
			return  new ResultPojo(1,"操作成功");
		}
			return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("show")
	public ResultPojo show(Integer id, HttpSession session) {
		 BillDetial billDetial = billDetialService.Show(id, session);
		 
		 if(billDetial!=null) {
			 return  new ResultPojo(1,billDetial);
		 }
		 
		 return  new ResultPojo(0,"操作失败");
		
	}
	@RequestMapping("deleteBatch")
	public ResultPojo deleteBatch(String idStr,HttpSession session) {
	    int result = billDetialService.deleteBatch(idStr, session);
		
	    if(result==1) {
			 return  new ResultPojo(1,"操作成功");	
	    }
		 return  new ResultPojo(0,"操作失败");
	}
}