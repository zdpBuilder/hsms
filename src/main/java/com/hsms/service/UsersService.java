package com.hsms.service;

import com.hsms.model.Admin;

public interface UsersService {
	 public Admin login(String loginId , String password,String roleStatus);	
}
