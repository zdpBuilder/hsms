package com.hsms.service;




import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hsms.mapper.AdminMapper;
import com.hsms.model.Admin;
import com.hsms.model.AdminExample;
import com.hsms.model.AdminExample.Criteria;






@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	AdminMapper sysUserMapper; 
	public Admin login(String loginId, String password,String roleStatus) {
		
			if (StringUtils.isNotBlank(loginId) && StringUtils.isNotBlank(password)&&roleStatus!=null) {
				password = DigestUtils.md5DigestAsHex(password.getBytes());		
					AdminExample example = new AdminExample();
					Criteria criteria = example.createCriteria();
					criteria.andLoginPasswordEqualTo(password).andLoginIdEqualTo(loginId).andStatusEqualTo(roleStatus);
					List<Admin> sysUsers = sysUserMapper.selectByExample(example);
			  if(sysUsers.size()>0&&sysUsers!=null) {
				  return sysUsers.get(0);
			  }
			
			}	
		return null;
	}

	
}
