package com.hsms.service;

import javax.servlet.http.HttpSession;
import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.DbBackup;

public interface DbBackupService {
	/**
	 * @Description: 数据库备份列表查询
	 * @param keywords
	 * @param limit
	 * @param page
	 * @return
	 */
	ResponseJsonPageListBean list(String startTime,String endTime, int limit, int page);

	/**
	 * @Description: 数据库备份 新增 编辑
	 * @param brand
	 * @param session
	 * @return
	 */
	int save(DbBackup dbBackup, HttpSession session);

	/**
	 * @Description: 数据库备份批量删除
	 * @param idStr
	 * @param session
	 * @return
	 */
	int deleteBatch(String idStr, HttpSession session);
}
