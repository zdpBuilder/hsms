package com.hsms.service.impl;

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
import com.hsms.pojo.ResultPojo;
import com.hsms.service.UsersService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	SysUserMapper sysUserMapper;

	@Override
	public ResultPojo login(HttpSession session, String loginId, String password) {

		password = DigestUtils.md5DigestAsHex(password.getBytes());
		
		//拼装sql
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginIdEqualTo(loginId);
		
		List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
		
		if(Empty4jUtils.listIsNotEmpty(sysUsers)) {
			SysUser sysUser = sysUsers.get(0);
			if(password.equals(sysUser.getLoginPassword())) {
				session.setAttribute(Const.SESSION_USER, sysUser);
				return new ResultPojo(1, "登陆成功");
			}
			if(!password.equals(sysUser.getLoginPassword())) {
				return new ResultPojo(0, "请输入正确密码");
			}
		}
		return new ResultPojo(0, "未找到此用户");

	}

	public ResponseJsonPageListBean list(HttpServletRequest request, HttpServletResponse response, String keywords,
			int limit, int page) {
		// limit ÿҳ��ʾ����
		// page ��ǰҳ��
		SysUserExample example = new SysUserExample();
		// ���÷�ҳ��ѯ����
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria = example.createCriteria();
		if (keywords != null && keywords != "") {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			// and or���ϲ�ѯ
			example.or().andNameLike(keywords).andStatusNotEqualTo(0);
			example.or().andLoginIdLike(keywords).andStatusNotEqualTo(0);
		} else {
			criteria.andStatusNotEqualTo(0);// ����״̬
		}
		// ��ҳ��ѯ
		List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
		int count = (int) sysUserMapper.countByExample(example);

		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setMsg("�û��б�");
		listBean.setData(sysUsers);
		if (Empty4jUtils.listIsNotEmpty(sysUsers)) {
			return listBean;
		}
		return null;
	}

	public int save(SysUser sysUser, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		int count = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		// �༭�û�
		if (null != sysUser.getId() && sysUser.getId() > 0) {
			SysUser userOld = sysUserMapper.selectByPrimaryKey(sysUser.getId());
			sysUser.setUpdater(currentLoginUser.getLoginId() + "");
			sysUser.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			if (!userOld.getLoginPassword().equals(sysUser.getLoginPassword())) {
				sysUser.setLoginPassword(DigestUtils.md5DigestAsHex(sysUser.getLoginPassword().getBytes()));
			}
			count = sysUserMapper.updateByPrimaryKeySelective(sysUser);

		} else {
			// �����û�
			sysUser.setCreater(currentLoginUser.getLoginId() + "");
			sysUser.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			sysUser.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
			count = sysUserMapper.insert(sysUser);
			// ���ǰ̨Json

		}

		return count;
	}

	public int deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		if (StringUtils.isNotBlank(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				// ������ѡ�豸����Ϊɾ��״̬
				int id = Integer.parseInt(idArr[i]);
				SysUser user = sysUserMapper.selectByPrimaryKey(id);
				user.setStatus(0);// 1���� 0��ɾ��
				user.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				user.setUpdater(currentLoginUser.getLoginId() + "");
				sysUserMapper.updateByPrimaryKeySelective(user);
			}
			// ���ǰ̨Json
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

		SysUserExample example = new SysUserExample();
		SysUserExample.Criteria criteria = example.createCriteria();
		criteria.andLoginIdEqualTo(loginId);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if (list.size() > 0 && list != null) {
			return false;
		}
		return true;
	}

}
