package com.hsms.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BillMapper;
import com.hsms.model.BillExample.Criteria;
import com.hsms.model.Bill;
import com.hsms.model.BillExample;
import com.hsms.model.SysUser;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billMapper;
	
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		// TODO Auto-generated method stub
		BillExample  example = new BillExample();
		//分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria  =example.createCriteria();
		//条件查询 参数配置
		if(Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andCodeLike(keywords).andStatusNotEqualTo(0);
		}else {
			criteria.andStatusNotEqualTo(0);
		}
		//结果处理
		List<Bill> list =billMapper.selectByExample(example);
		int count =(int) billMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("账单列表信息");
		return listBean;
	}

	public int save(Bill bill, HttpSession session) {
		int result=0;
		SysUser currentLoginUser =(SysUser)session.getAttribute(Const.SESSION_USER);
		//修改账单信息
		if(Empty4jUtils.intIsNotEmpty(bill.getId())) {
			bill.setUpdater(currentLoginUser.getLoginId());
			bill.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result  = billMapper.updateByPrimaryKey(bill);
		}//新增账单信息
		else{
			bill.setCreater(currentLoginUser.getLoginPassword());
			bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
	        result = billMapper.insert(bill);
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
				//更新账单状态
				int id = Integer.parseInt(idArr[i]);
				Bill bill = billMapper.selectByPrimaryKey(id);
				bill.setStatus(0);
				bill.setUpdater(currentLoginUser.getLoginId());
				bill.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				billMapper.updateByPrimaryKeySelective(bill);			
			 }	
			result=1;
			}
		return result;
	}

	public Bill Show(int id, HttpSession session) {
		
	    return billMapper.selectByPrimaryKey(id);
	    
	}

      
	
}
