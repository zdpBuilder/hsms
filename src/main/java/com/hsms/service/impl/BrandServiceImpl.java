package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BrandMapper;
import com.hsms.model.Brand;
import com.hsms.model.BrandExample;
import com.hsms.model.BrandExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.service.BrandService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandMapper brandMapper;
	
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		// TODO Auto-generated method stub
		BrandExample  example = new BrandExample();
		//分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria  =example.createCriteria();
		//条件查询 参数配置
		if(Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andTitleLike(keywords).andStatusNotEqualTo(0);
		}else {
			criteria.andStatusNotEqualTo(0);
		}
		//结果处理
		List<Brand> list =brandMapper.selectByExample(example);
		int count =(int) brandMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("品牌列表信息");
		return listBean;
	}

	public int save(Brand brand, HttpSession session) {
		int result=0;
		SysUser currentLoginUser =(SysUser)session.getAttribute(Const.SESSION_USER);
		//修改品牌信息
		if(Empty4jUtils.intIsNotEmpty(brand.getId())) {
			brand.setUpdater(currentLoginUser.getLoginId());
			brand.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result  = brandMapper.updateByPrimaryKeySelective(brand);
		}//新增品牌信息
		else{
			brand.setStatus(1);
			brand.setCreater(currentLoginUser.getLoginPassword());
			brand.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
	        result = brandMapper.insert(brand);
		}
		return result;
	}

	@Transactional(readOnly = false)
	public int deleteBatch(String idStr, HttpSession session) throws RuntimeException {
		SysUser currentLoginUser =(SysUser)session.getAttribute(Const.SESSION_USER);
        int result=0;
		if (Empty4jUtils.stringIsNotEmpty(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				//更新品牌状态
				int id = Integer.parseInt(idArr[i]);
				Brand brand = brandMapper.selectByPrimaryKey(id);
				brand.setStatus(0);
				brand.setUpdater(currentLoginUser.getLoginId());
				brand.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				brandMapper.updateByPrimaryKeySelective(brand);			
			 }	
			result=1;
			}
		return result;
	}

	public Brand Show(int id, HttpSession session) {
		
	    return brandMapper.selectByPrimaryKey(id);
	    
	}

      
	
}
