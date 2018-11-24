package com.hsms.service;




import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.SysUserMapper;
import com.hsms.model.SysUser;
import com.hsms.model.SysUserExample;
import com.hsms.model.SysUserExample.Criteria;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;
import com.hsms.utils.JsonPrintUtil;






@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	SysUserMapper sysUserMapper; 
	public SysUser login(String loginId, String password) {
		
			if (StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(password)) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());		
					SysUserExample example = new SysUserExample();
					Criteria criteria = example.createCriteria();
					criteria.andLoginPasswordEqualTo(password).andLoginIdEqualTo(loginId);
					List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
			  if(sysUsers.size()>0&&sysUsers!=null) {
				  return sysUsers.get(0);
			  }
			
			}	
		return null;
	}
	public ResponseJsonPageListBean list(HttpServletRequest request, HttpServletResponse response, String keywords,
			int limit, int page) {
		// limit 每页显示数量
 		// page 当前页码
 		SysUserExample example = new SysUserExample();
 		// 设置分页查询参数
 		example.setStartRow((page - 1) * limit);
 		example.setPageSize(limit);
 		example.setOrderByClause("create_time desc,update_time desc");
 		Criteria criteria = example.createCriteria();
 		if (keywords!=null&&keywords!="") {
 			keywords = keywords.trim();
 			keywords = "%" + keywords + "%";
 			// and or联合查询
 			example.or().andNameLike(keywords).andStatusNotEqualTo(0);
 			example.or().andLoginIdLike(keywords).andStatusNotEqualTo(0);
 		} else {
 			criteria.andStatusNotEqualTo(0);// 正常状态
 		}
 		// 分页查询
 		List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
 		int count = (int) sysUserMapper.countByExample(example);

 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
 		listBean.setCode(0);
 		listBean.setCount(count);
 		listBean.setMsg("用户列表");
 		listBean.setData(sysUsers);
 		if(Empty4jUtils.listIsNotEmpty(sysUsers)) {
 			return  listBean;
 		}
		return null;
	}
	public int save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int count = 0;
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		// 编辑用户
 		if (null != sysUser.getId()&& sysUser.getId() > 0) {
 			SysUser userOld = sysUserMapper.selectByPrimaryKey(sysUser.getId());
 			sysUser.setUpdater(currentLoginUser.getLoginId() + "");
 			sysUser.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			if (!userOld.getLoginPassword().equals(sysUser.getLoginPassword())) {
 				sysUser.setLoginPassword(DigestUtils.md5DigestAsHex(sysUser.getLoginPassword().getBytes()));
 			}
 			count = sysUserMapper.updateByPrimaryKeySelective(sysUser);

 			
 		} else {
 			// 新增用户
 			sysUser.setCreater(currentLoginUser.getLoginId() + "");
 			sysUser.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			sysUser.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
 			count = sysUserMapper.insert(sysUser);
 			//输出前台Json
 			
 		} 		
 		
		return count;
	}
	public int deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		if (StringUtils.isNotBlank(idStr)) {
 			String[] idArr = idStr.split(",");
 			for (int i = 0; i < idArr.length; i++) {
 				// 更新所选设备分类为删除状态
 				int id = Integer.parseInt(idArr[i]);
 				SysUser user = sysUserMapper.selectByPrimaryKey(id);
 				user.setStatus(0);// 1正常 0已删除
 				user.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 				user.setUpdater(currentLoginUser.getLoginId() + "");
 				sysUserMapper.updateByPrimaryKeySelective(user);
 			}
 			// 输出前台Json
 			return 1;
 		} 
		return 0;
	}
	public SysUser show(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		SysUser user = sysUserMapper.selectByPrimaryKey(id);
 		if (null != user) {		
         return user;
 		}
		return null;
	}
	public boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		
		SysUserExample example=  new SysUserExample();
 		SysUserExample.Criteria criteria = example.createCriteria();
 		criteria.andLoginIdEqualTo(loginId);
 		List<SysUser> list =sysUserMapper.selectByExample(example);
 		if(list.size()>0&&list!=null) {
 			return false;
 		}
 		return true;
	}

	
}
