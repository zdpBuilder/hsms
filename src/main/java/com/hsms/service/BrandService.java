package com.hsms.service;



import javax.servlet.http.HttpSession;

import com.hsms.model.Brand;
import com.hsms.pojo.ResultPojo;

public interface BrandService {
   
	ResultPojo list(String keywords, int limit,int page);
	ResultPojo save(Brand brand,HttpSession session);
	ResultPojo deleteBatch(String idStr,HttpSession session);
	ResultPojo Show(int id,HttpSession session);
}
