package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.DbBackupMapper;
import com.hsms.model.DbBackupExample.Criteria;
import com.hsms.model.DbBackup;
import com.hsms.model.DbBackupExample;
import com.hsms.model.SysUser;
import com.hsms.service.DbBackupService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.DbBackupUtils;
import com.hsms.utils.Empty4jUtils;

@Service
public class DbBackupServiceImpl implements DbBackupService {

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.databaseName}")
	private String dataBaseName;

	@Value("${jdbc.host}")
	private String host;

	@Value("${jdbc.port}")
	private String port;

	@Value("${jdbc.dbBackupBasePath}")
	private String dbBackupBasePath;

	@Autowired
	private DbBackupMapper dbBackupMapper;

	@Override
	public ResponseJsonPageListBean list(String startTime, String endTime, int limit, int page) {
		// TODO Auto-generated method stub
		DbBackupExample example = new DbBackupExample();
		// 分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,restore_time desc");
		Criteria criteria = example.createCriteria();
		// 条件查询 参数配置
		if (Empty4jUtils.stringIsNotEmpty(startTime)) {
			criteria.andCreateTimeGreaterThan(startTime);
		}
		if (Empty4jUtils.stringIsNotEmpty(endTime)) {
			criteria.andCreateTimeLessThan(endTime);
		}
		// 结果处理
		List<DbBackup> list = dbBackupMapper.selectByExample(example);
		int count = (int) dbBackupMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("备份列表信息");
		return listBean;
	}

	@Override
	public int save(DbBackup dbBackup, HttpSession session) {
		int result = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		// 还原数据库备份信息
		if (Empty4jUtils.intIsNotEmpty(dbBackup.getId())) {
			//还原数据库
			boolean dbResult=DbBackupUtils.importSql(username, password, dataBaseName, host, port, dbBackup.getBackupPath());
			// dbResult==false 备份数据库失败
			if(dbResult==false) {
				return result;
			}
			dbBackup.setTitle("您在"+DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+"进行了数据库还原！");
			dbBackup.setRestorer(currentLoginUser.getLoginId());
			dbBackup.setRestoreTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = dbBackupMapper.updateByPrimaryKeySelective(dbBackup);
		} // 备份数据库备份信息
		else {
			// 数据备份
			String exportPath=DbBackupUtils.export(username, password, dataBaseName, host, port, dbBackupBasePath);
			//exportPath==null 备份失败
			if(exportPath==null) {
				return result;
			}
			dbBackup.setBackupPath(exportPath);
			dbBackup.setTitle("您在"+DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss")+"对数据进行了备份！");
			dbBackup.setCreater(currentLoginUser.getLoginId());
			dbBackup.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = dbBackupMapper.insert(dbBackup);
		}
		return result;
	}

	@Override
	public int deleteBatch(String idStr, HttpSession session) throws RuntimeException {

		int result = 0;
		if (Empty4jUtils.stringIsNotEmpty(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				// 删除备份信息
				int id = Integer.parseInt(idArr[i]);
				dbBackupMapper.deleteByPrimaryKey(id);
			}
			result = 1;
		}
		return result;
	}

	
}
