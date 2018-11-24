package com.hsms.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.model.SysUser;
import com.hsms.service.UsersService;
import com.hsms.utils.JsonPrintUtil;




@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private  UsersService usersService;
	

	  // �û��б��ҳ��ѯ
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void equipmentList(HttpServletRequest request, HttpServletResponse response, String keywords, int limit,
	 			int page) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, usersService.list(request, response, keywords, limit, page)); 		
	 	}
	 	
	 // �û����� �༭
	 	@RequestMapping(value = "save", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		
 				JsonPrintUtil.printObjDataWithKey(response, usersService.save(sysUser, request, response, session), "data");		
	 	}

	 	// �û�����ɾ��
	 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
	 			HttpSession session) {
	 	
	 			JsonPrintUtil.printObjDataWithKey(response, usersService.deleteBatch(idStr, request, response, session), "data");
	 		
	 	}

	 	// �û��鿴
	 	@RequestMapping(value = "show", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 			
	 		JsonPrintUtil.printObjDataWithKey(response, usersService.show(id, request, response, session), "data");

	 	}	
		// ��¼��У��
	 	@RequestMapping(value = "loginIdCheck", method = RequestMethod.POST)
	 	@ResponseBody
	 	public boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		return usersService.loginIdCheck(loginId, request, response, session);
	 	}
}
