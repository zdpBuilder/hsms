package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.hsms.model.Brand;
import com.hsms.pojo.ResultPojo;

@Service
public class BrandServiceImpl implements BrandService {

	public ResultPojo list(String keywords, int limit, int page) {
	   
		return null;
	}

	public ResultPojo save(Brand brand, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultPojo deleteBatch(String idStr, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultPojo Show(int id, HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}
     
      
	
}
