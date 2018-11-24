package com.hsms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.SysUser;

public interface UsersService {
	 SysUser login(String loginId , String password);
	 ResponseJsonPageListBean list(HttpServletRequest request, HttpServletResponse response, String keywords,int limit,
	 			int page);
	 boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response, HttpSession session);
	 int save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session);
	 int deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
	 			HttpSession session);
	 SysUser show(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
