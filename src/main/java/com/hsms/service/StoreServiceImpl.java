package com.hsms.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.StoreMapper;
import com.hsms.model.Store;
import com.hsms.model.StoreExample;
import com.hsms.model.SysUser;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper storeMapper;
	
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		// TODO Auto-generated method stub
		StoreExample  example = new StoreExample();
		//分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		//条件查询 参数配置
		if(Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andTitleLike(keywords);
		}
		//结果处理
		List<Store> list =storeMapper.selectByExample(example);
		int count =(int) storeMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("库存列表信息");
		return listBean;
	}

	public int save(Store store, HttpSession session) {
		int result=0;
		SysUser currentLoginUser =(SysUser)session.getAttribute(Const.SESSION_USER);
		//修改库存信息
		if(Empty4jUtils.intIsNotEmpty(store.getId())) {
			store.setUpdater(currentLoginUser.getLoginId());
			store.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result  = storeMapper.updateByPrimaryKey(store);
		}//新增库存信息
		else{
			store.setCreater(currentLoginUser.getLoginPassword());
			store.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
	        result = storeMapper.insert(store);
		}
		return result;
	}

	

	public Store Show(int id, HttpSession session) {
		
	    return storeMapper.selectByPrimaryKey(id);
	    
	}

      
	
}
