package com.hsms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.model.SysUser;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.UsersService;
import com.hsms.utils.Const;
import com.hsms.utils.Empty4jUtils;
import com.hsms.utils.JsonPrintUtil;

/**
 * 登陆、退出逻辑
 *
 */
@Controller
public class LoginController {

	@Autowired
	private UsersService usersService;

	/**
	 * 
	 * @Description: 登陆
	 * @param loginId  登陆id
	 * @param password 密码
	 * @param response
	 * @param request
	 * @param session
	 */
	@RequestMapping("login")
	@ResponseBody
	public ResultPojo login(String loginId, String password, HttpServletResponse response, HttpServletRequest request,
			HttpSession session) {
		//数据校验
		if(Empty4jUtils.stringIsEmpty(loginId) || Empty4jUtils.stringIsEmpty(password)) {
			return new ResultPojo(0, "数据不合法");
		}
		return usersService.login(session, loginId.trim(), password);
	}

	/**
	 * 
	 * @Description: 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
