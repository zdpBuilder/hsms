package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BillDetailCustomMapper;
import com.hsms.mapper.BillDetailMapper;
import com.hsms.model.BillDetail;
import com.hsms.model.BillDetailExample;
import com.hsms.model.BillDetailExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.service.BillDetailService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class BillDetailServiceImpl implements BillDetailService {

	@Autowired
	private BillDetailMapper billDetailMapper;
	@Autowired
	private BillDetailCustomMapper billDetailCustomMapper;

	@Override
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		// TODO Auto-generated method stub
		BillDetailExample example = new BillDetailExample();
		// 分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria = example.createCriteria();
		// 条件查询 参数配置
		if (Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andBillCodeLike(keywords).andStatusNotEqualTo(0);
		} else {
			criteria.andStatusNotEqualTo(0);
		}
		// 结果处理
		List<BillDetail> list = billDetailMapper.selectByExample(example);
		int count = (int) billDetailMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("账单明细列表信息");
		return listBean;
	}

	@Override
	public int save(BillDetail billDetail, HttpSession session) {
		int result = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		// 修改账单明细信息
		if (Empty4jUtils.intIsNotEmpty(billDetail.getId())) {
			billDetail.setUpdater(currentLoginUser.getLoginId());
			billDetail.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = billDetailMapper.updateByPrimaryKeySelective(billDetail);
		} // 新增账单明细信息
		else {
			billDetail.setStatus(1);
			billDetail.setCreater(currentLoginUser.getLoginPassword());
			billDetail.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = billDetailMapper.insert(billDetail);
		}
		return result;
	}

	@Transactional(readOnly = false)
	@Override
	public int deleteBatch(String idStr, HttpSession session) throws RuntimeException {
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		int result = 0;
		if (Empty4jUtils.stringIsNotEmpty(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				// 更新账单明细状态
				int id = Integer.parseInt(idArr[i]);
				BillDetail billDetail = billDetailMapper.selectByPrimaryKey(id);
				billDetail.setStatus(0);
				billDetail.setUpdater(currentLoginUser.getLoginId());
				billDetail.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				billDetailMapper.updateByPrimaryKeySelective(billDetail);
			}
			result = 1;
		}
		return result;
	}

	@Override
	public BillDetail getOneById(int id) {

		return billDetailMapper.selectByPrimaryKey(id);

	}

	@Override
	public boolean addList(String billCode, List<BillDetail> billDetailList, String loginId) throws Exception {
		if (Empty4jUtils.listIsEmpty(billDetailList))
			return false;
		int result = 0;

		// 初始化数据
		for (BillDetail billDetail : billDetailList) {
			billDetail.setBillCode(billCode);
			billDetail.setCreater(loginId);
			billDetail.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			billDetail.setStatus(1);
		}

		try {
			result = billDetailCustomMapper.insertList(billDetailList);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return result == billDetailList.size() ? true : false;
	}

}
