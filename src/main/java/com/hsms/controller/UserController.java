package com.hsms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.SysUser;
import com.hsms.pojo.ResultPojo;
import com.hsms.service.UsersService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UsersService usersService;

	/**
	 * 
	 * @Description: 获取用户的分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean equipmentList(String keywords, int limit, int page) {
		return usersService.list(keywords, limit, page);
	}

	/**
	 * 
	 * @Description: 保存用户
	 * @param sysUser
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(SysUser sysUser, HttpSession session) {
		int count = usersService.save(sysUser, session);
		if (count == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}

	/**
	 * 
	 * @Description: 批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	@RequestMapping("deleteBatch")
	@ResponseBody
	public ResultPojo deleteBatch(String idStr, HttpSession session) {
		int result = usersService.deleteBatch(idStr, session);
		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}

	/**
	 * 
	 * @Description: 获取用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResultPojo show(int id) {
		SysUser user = usersService.getOneById(id);
		if (user != null) {
			return new ResultPojo(1, user);
		}

		return new ResultPojo(0, "操作失败");
	}

	/**
	 * 
	 * @Description: 账号是否存在检测
	 * @param loginId
	 * @return
	 */
	@RequestMapping("loginIdCheck")
	@ResponseBody
	public boolean loginIdCheck(String loginId) {
		return usersService.loginIdCheck(loginId);
	}
}
