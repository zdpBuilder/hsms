package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BillMapper;
import com.hsms.model.Bill;
import com.hsms.model.BillDetail;
import com.hsms.model.BillExample;
import com.hsms.model.BillExample.Criteria;
import com.hsms.model.Goods;
import com.hsms.model.SysUser;
import com.hsms.pojo.BillInfoPojo;
import com.hsms.service.BillDetailService;
import com.hsms.service.BillService;
import com.hsms.service.GoodService;
import com.hsms.service.StoreService;
import com.hsms.utils.Const;
import com.hsms.utils.ConvertUtil;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billMapper;
	@Autowired
	private BillDetailService billDetailService;
	@Autowired
	private GoodService goodService;
	@Autowired
	private StoreService storeService;

	@Override
	public ResponseJsonPageListBean list(String keywords, int limit, int page, int status,String startDate,String endDate) {
		BillExample example = new BillExample();
		// 分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria = example.createCriteria();
		// 条件查询 参数配置
		if (Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			criteria.andCodeLike(keywords);
		} 
		
		if(Empty4jUtils.stringIsNotEmpty(startDate)) {
			
			criteria.andCreateTimeGreaterThanOrEqualTo(startDate);
			
		}
		if(Empty4jUtils.stringIsNotEmpty(endDate)) {
			
			criteria.andCreateTimeLessThanOrEqualTo(endDate);
		}
		
		criteria.andStatusNotEqualTo(0).andStatusEqualTo(status);
		// 结果处理
		List<Bill> list = billMapper.selectByExample(example);
		int count = (int) billMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("账单列表信息");
		return listBean;
	}

	@Override
	public int save(Bill bill, HttpSession session) {
		int result = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		// 修改账单信息
		if (Empty4jUtils.intIsNotEmpty(bill.getId())) {
			bill.setUpdater(currentLoginUser.getLoginId());
			bill.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = billMapper.updateByPrimaryKeySelective(bill);
		} // 新增账单信息
		else {
			bill.setStatus(1);
			bill.setCreater(currentLoginUser.getLoginPassword());
			bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = billMapper.insert(bill);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(String codeStr, HttpSession session) throws RuntimeException {
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		int result = 0;
		if (Empty4jUtils.stringIsNotEmpty(codeStr)) {
			String[] codeArr = codeStr.split(",");
			for (int i = 0; i < codeArr.length; i++) {
				// 更新账单状态
				BillExample example =new BillExample();
				Criteria criteria=example.createCriteria();
				criteria.andCodeEqualTo(codeArr[i]);
				List<Bill> bills = billMapper.selectByExample(example);
				if(bills.size()>0) {
					Bill bill =bills.get(0);
					bill.setStatus(0);
					bill.setUpdater(currentLoginUser.getLoginId());
					bill.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
					billMapper.updateByPrimaryKeySelective(bill);
				}
				//还原库存
			    storeService.restoreStoreList(codeArr[i], currentLoginUser.getLoginId());
				//删除账单明细
				billDetailService.delListByBillCode(codeArr[i]);
			}
			result = 1;
		}
		return result;
	}

	@Override
	public Bill getOneById(int id) {

		return billMapper.selectByPrimaryKey(id);

	}

	@Override
	public boolean inStore(String loginId, Bill bill, List<BillDetail> billDetailList) throws Exception {
		boolean result = false;
		
		// 转换为货物集合
		List<Goods> goodsList = ConvertUtil.convertList(billDetailList, Goods.class);
		// 入库单
		result = save(bill, loginId);
		
		//入库处理
        if(Empty4jUtils.intIsNotEmpty(bill.getId())) {	    
        	//还原库存
        	storeService.restoreStoreList(bill.getCode(), loginId);
        	//物理删除订单明细信息
        	 billDetailService.delListByBillCode(bill.getCode());  	  
        }
       
        if (Empty4jUtils.listIsNotEmpty(billDetailList) && Empty4jUtils.listIsNotEmpty(goodsList)) {
			// 新增订单明系
			result = false;
			result = billDetailService.addList(bill.getCode(), billDetailList, loginId);
			
			// 货品集合处理
			result = false;
			result = goodService.addList(goodsList, loginId);
			
			// 仓库处理
			result = false;
			result = storeService.addList(billDetailList, loginId);
		}
		return result;
	}

	@Override
	public boolean save(Bill bill, String loginId) {
		int result=0;
		//新增账单
		if(Empty4jUtils.intIsEmpty(bill.getId())) {
			bill.setStatus(1);
			bill.setCreater(loginId);
			bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = billMapper.insert(bill);	
		}//编辑保存
		else {
			
        	bill.setUpdater(loginId);
        	bill.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
        	result = billMapper.updateByPrimaryKeySelective(bill);
		}
		
		return result > 0 ? true : false;
	}

	@Override
	public BillInfoPojo getBillIncludeBillDetailByBillCode(String billCode) {
		BillInfoPojo billInfoPojo=new BillInfoPojo();
		//查询账单
		BillExample example=new BillExample();
		Criteria criteria=example.createCriteria();
		criteria.andCodeEqualTo(billCode);	
		billInfoPojo.setBill(billMapper.selectByExample(example).size()>0?billMapper.selectByExample(example).get(0):null);
		//查询明细
		billInfoPojo.setBillDetailList(billDetailService.getBillDetailBybillCode(billCode));	
		return billInfoPojo;
	}

}
