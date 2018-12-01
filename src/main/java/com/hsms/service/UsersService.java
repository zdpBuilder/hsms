package com.hsms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.SysUser;
import com.hsms.pojo.ResultPojo;

public interface UsersService {

	/**
	 * 
	 * @Description: 登陆
	 * @param session
	 * @param loginId
	 * @param password
	 * @return
	 */
	ResultPojo login(HttpSession session, String loginId, String password);

	/**
	 * 
	 * @Description: 分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String keywords, int limit, int page);

	/**
	 * 
	 * @Description: 登陆账号是否存在
	 * @param loginId
	 * @return
	 */
	boolean loginIdCheck(String loginId);

	/**
	 * 
	 * @Description: 新增用户
	 * @param sysUser
	 * @param session
	 * @return
	 */
	int save(SysUser sysUser, HttpSession session);

	/**
	 * 
	 * @Description: 批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);

	/**
	 * 
	 * @Description: 获取用户信息
	 * @param id
	 * @return
	 */
	SysUser getOneById(int id);
}
