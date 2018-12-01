package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.SupplierMapper;
import com.hsms.model.Supplier;
import com.hsms.model.SupplierExample;
import com.hsms.model.SupplierExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.service.SupplierService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		SupplierExample example = new SupplierExample();
		// 分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		Criteria criteria = example.createCriteria();
		// 条件查询 参数配置
		if (Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andNameLike(keywords).andStatusEqualTo(1);
		} else {
			criteria.andStatusEqualTo(1);
		}
		// 结果处理
		List<Supplier> list = supplierMapper.selectByExample(example);
		int count = (int) supplierMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("库存列表信息");
		return listBean;
	}

	@Override
	public int save(Supplier supplier, HttpSession session) {
		int result = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		// 修改供应商信息
		if (Empty4jUtils.intIsNotEmpty(supplier.getId())) {
			supplier.setUpdater(currentLoginUser.getLoginId());
			supplier.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = supplierMapper.updateByPrimaryKeySelective(supplier);
		} // 新增供应商信息
		else {
			supplier.setStatus(1);
			supplier.setCreater(currentLoginUser.getLoginId());
			supplier.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = supplierMapper.insert(supplier);
		}
		return result;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(String idStr, HttpSession session) throws RuntimeException {
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		int result = 0;
		if (Empty4jUtils.stringIsNotEmpty(idStr)) {
			String[] idArr = idStr.split(",");
			for (int i = 0; i < idArr.length; i++) {
				result = 0;
				// 更新供应商状态
				int id = Integer.parseInt(idArr[i]);
				Supplier supplier = supplierMapper.selectByPrimaryKey(id);
				supplier.setStatus(0);
				supplier.setUpdater(currentLoginUser.getLoginId());
				supplier.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				result = supplierMapper.updateByPrimaryKeySelective(supplier);
			}
		}
		return result;
	}

	@Override
	public Supplier getOneById(int id) {

		return supplierMapper.selectByPrimaryKey(id);

	}

}
