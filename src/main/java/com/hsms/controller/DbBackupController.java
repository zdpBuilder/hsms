package com.hsms.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;

import com.hsms.model.DbBackup;
import com.hsms.pojo.ResultPojo;

import com.hsms.service.DbBackupService;
/**
 * 数据库备份处理
 *
 */
@Controller
@RequestMapping("dbBackup")
public class DbBackupController {

	@Autowired
	private DbBackupService dbBackupService;

	/**
	 * 
	 * @Description: 获取分页数据
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public ResponseJsonPageListBean List(String startTime,String endTime, Integer limit, Integer page) {

		return dbBackupService.list(startTime, endTime, limit, page);

	}

	/**
	 * 
	 * @Description: 保存
	 * @param brand
	 * @param session
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public ResultPojo save(DbBackup dbBackup, HttpSession session) {
		int count = dbBackupService.save(dbBackup, session);

		if (count == 1) {
			return new ResultPojo(1, dbBackup.getId(), "操作成功");
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
		int result = dbBackupService.deleteBatch(idStr, session);

		if (result == 1) {
			return new ResultPojo(1, "操作成功");
		}
		return new ResultPojo(0, "操作失败");
	}
}
