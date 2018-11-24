package com.hsms.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.SysUserMapper;
import com.hsms.model.SysUser;
import com.hsms.model.SysUserExample;
import com.hsms.model.SysUserExample.Criteria;
import com.hsms.service.UsersService;
import com.hsms.utils.DateUtil;
import com.hsms.utils.JsonPrintUtil;




@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private  UsersService usersService;
	

	  // 用户列表分页查询
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void equipmentList(HttpServletRequest request, HttpServletResponse response, String keywords, int limit,
	 			int page) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, usersService.list(request, response, keywords, limit, page)); 		
	 	}
	 	
	 // 用户新增 编辑
	 	@RequestMapping(value = "save", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		
 				JsonPrintUtil.printObjDataWithKey(response, usersService.save(sysUser, request, response, session), "data");		
	 	}

	 	// 用户批量删除
	 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
	 			HttpSession session) {
	 	
	 			JsonPrintUtil.printObjDataWithKey(response, usersService.deleteBatch(idStr, request, response, session), "data");
	 		
	 	}

	 	// 用户查看
	 	@RequestMapping(value = "show", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		
	 	}	
		// 登录名校验
	 	@RequestMapping(value = "loginIdCheck", method = RequestMethod.POST)
	 	@ResponseBody
	 	public boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		return usersService.loginIdCheck(loginId, request, response, session);
	 	}
}
