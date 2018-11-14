package com.hsms.service;



import com.hsms.model.SysUser;


public interface UsersService {
	 public SysUser login(String loginId , String password,Integer roleStatus);	
}
