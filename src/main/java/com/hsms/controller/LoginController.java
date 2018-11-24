package com.hsms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.model.SysUser;
import com.hsms.service.UsersService;
import com.hsms.utils.Const;
import com.hsms.utils.JsonPrintUtil;




@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;
	
     //�û���¼
	@RequestMapping("login")
	@ResponseBody
	public void login(String loginId, String password, HttpServletResponse response,
			HttpServletRequest request, HttpSession session) {	
		SysUser sysUser= usersService.login(loginId, password);	
	  if(null!=sysUser) {
		// ��½�ɹ�
		  JsonPrintUtil.printObjDataWithKey(response, 1, "data");
		  session.setAttribute(Const.SESSION_USER, sysUser);
	  }else{
		  session.setAttribute(Const.SESSION_USER, null);
		  JsonPrintUtil.printObjDataWithKey(response, 0, "data");
	  }	  
}

	// �˳�
	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "login";
	}	
	 
}
