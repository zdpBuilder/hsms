package com.hsms.service;




import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hsms.mapper.SysUserMapper;
import com.hsms.model.SysUser;
import com.hsms.model.SysUserExample;
import com.hsms.model.SysUserExample.Criteria;




@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	SysUserMapper sysUserMapper; 
	public SysUser login(String loginId, String password,Integer roleStatus) {
		
			if (StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(password)&&roleStatus!=null) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());		
					SysUserExample example = new SysUserExample();
					Criteria criteria = example.createCriteria();
					criteria.andLoginPasswordEqualTo(password).andLoginIdEqualTo(loginId).andStatusEqualTo(roleStatus);
					List<SysUser> sysUsers = sysUserMapper.selectByExample(example);
			  if(sysUsers.size()>0&&sysUsers!=null) {
				  return sysUsers.get(0);
			  }
			
			}	
		return null;
	}

	
}
