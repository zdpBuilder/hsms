package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BillDetialMapper;
import com.hsms.model.BillDetial;
import com.hsms.model.BillDetialExample;
import com.hsms.model.BillDetialExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.service.BillDetialService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class BillDetialServiceImpl implements BillDetialService {

	@Autowired
	private BillDetialMapper billDetialMapper;
	
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		// TODO Auto-generated method stub
		BillDetialExample  example = new BillDetialExample();
		//分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria  =example.createCriteria();
		//条件查询 参数配置
		if(Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andBillCodeLike(keywords).andStatusNotEqualTo(0);
		}else {
			criteria.andStatusNotEqualTo(0);
		}
		//结果处理
		List<BillDetial> list =billDetialMapper.selectByExample(example);
		int count =(int) billDetialMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("账单明细列表信息");
		return listBean;
	}

	public int save(BillDetial billDetial, HttpSession session) {
		int result=0;
		SysUser currentLoginUser =(SysUser)session.getAttribute(Const.SESSION_USER);
		//修改账单明细信息
		if(Empty4jUtils.intIsNotEmpty(billDetial.getId())) {
			billDetial.setUpdater(currentLoginUser.getLoginId());
			billDetial.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result  = billDetialMapper.updateByPrimaryKey(billDetial);
		}//新增账单明细信息
		else{
			billDetial.setCreater(currentLoginUser.getLoginPassword());
			billDetial.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
	        result = billDetialMapper.insert(billDetial);
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
				//更新账单明细状态
				int id = Integer.parseInt(idArr[i]);
				BillDetial billDetial = billDetialMapper.selectByPrimaryKey(id);
				billDetial.setStatus(0);
				billDetial.setUpdater(currentLoginUser.getLoginId());
				billDetial.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				billDetialMapper.updateByPrimaryKeySelective(billDetial);			
			 }	
			result=1;
			}
		return result;
	}

	public BillDetial Show(int id, HttpSession session) {
		
	    return billDetialMapper.selectByPrimaryKey(id);
	    
	}

      
	
}
