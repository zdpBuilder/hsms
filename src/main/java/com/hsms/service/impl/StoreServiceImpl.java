package com.hsms.service.impl;

import java.lang.ref.SoftReference;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.ptg.TblPtg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.StoreCustomMapper;
import com.hsms.mapper.StoreMapper;
import com.hsms.model.Bill;
import com.hsms.model.BillDetail;
import com.hsms.model.BillExample;
import com.hsms.model.Store;
import com.hsms.model.StoreExample;
import com.hsms.model.StoreExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.pojo.DataCountPojo;
import com.hsms.service.BillDetailService;
import com.hsms.service.StoreService;
import com.hsms.utils.Const;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper storeMapper;
	@Autowired
	private StoreCustomMapper storeCustomMapper;
	@Autowired
	private BillDetailService billDetailService;

	@Override
	public ResponseJsonPageListBean list(String keywords, int limit, int page) {
		StoreExample example = new StoreExample();
		// 分页配置
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		// 条件查询 参数配置
		if (Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			example.or().andTitleLike(keywords);
		}
		// 结果处理
		List<Store> list = storeMapper.selectByExample(example);
		int count = (int) storeMapper.countByExample(example);
		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setData(list);
		listBean.setMsg("库存列表信息");
		return listBean;
	}

	@Override
	public int save(Store store, HttpSession session) {
		int result = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute(Const.SESSION_USER);
		// 修改库存信息
		if (Empty4jUtils.intIsNotEmpty(store.getId())) {
			store.setUpdater(currentLoginUser.getLoginId());
			store.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = storeMapper.updateByPrimaryKeySelective(store);
		} // 新增库存信息
		else {
			store.setCreater(currentLoginUser.getLoginPassword());
			store.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
			result = storeMapper.insert(store);
		}
		return result;
	}

	@Override
	public Store getOneById(int id) {

		return storeMapper.selectByPrimaryKey(id);

	}

	@Override
	public boolean addList(List<BillDetail> billDetailList, String loginId) {
		if (Empty4jUtils.listIsEmpty(billDetailList))
			return false;
		int result = 0;
		Store store;
		BillDetail billDetail;
		for (int i = 0; i < billDetailList.size(); i++) {
			result = 0;
			store = storeCustomMapper.getOneByGoodsCode(billDetailList.get(i).getGoodsCode());
			billDetail = billDetailList.get(i);
			if (null != store) {
				// 更新
				store.setTitle(billDetail.getTitle());
				store.setRemainBoxNum(store.getRemainBoxNum() + billDetail.getBoxNum());
				store.setPurchaseTransaction(store.getPurchaseTransaction() + billDetail.getTransaction());
				store.setUpdater(loginId);
				store.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				result = this.storeMapper.updateByPrimaryKey(store);
			} else {
				// 插入
				store = new Store();
				store.setGoodsCode(billDetail.getGoodsCode());
				store.setTitle(billDetail.getTitle());
				store.setRemainBranchNum(0);
				store.setRemainBoxNum(billDetail.getBoxNum());
				store.setSellBoxNum(0);
				store.setSellBranchNum(0);
				store.setPurchaseTransaction(billDetail.getTransaction());
				store.setSaleTransaction(Double.valueOf(0));
				store.setCreater(loginId);
				store.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				result = this.storeMapper.insert(store);
			}
		}
		if (1 == result)
			return true;
		return false;
	}

	@Override
	public boolean restoreStoreList(String billCode, String loginId) {

		List<BillDetail> billDetailList = billDetailService.getBillDetailBybillCode(billCode);

		if (Empty4jUtils.listIsEmpty(billDetailList))
			return false;
		int result = 0;
		Store store;
		BillDetail billDetail;

		for (int i = 0; i < billDetailList.size(); i++) {
			result = 0;
			store = storeCustomMapper.getOneByGoodsCode(billDetailList.get(i).getGoodsCode());
			billDetail = billDetailList.get(i);
			if (null != store) {
				// 更新
				store.setTitle(billDetail.getTitle());
				store.setRemainBoxNum(store.getRemainBoxNum() - billDetail.getBoxNum());
				store.setPurchaseTransaction(store.getPurchaseTransaction() - billDetail.getTransaction());
				store.setUpdater(loginId);
				store.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));
				result = this.storeMapper.updateByPrimaryKey(store);
			}
		}
		if (1 == result)
			return true;

		return false;
	}

	@Override
	public boolean outStoreAddList(List<BillDetail> billDetailList, String loginId, Double sumTransaction) {
		if (Empty4jUtils.listIsEmpty(billDetailList))
			return false;
		for (BillDetail billDetail : billDetailList) {
			Store store = storeCustomMapper.getOneByGoodsCode(billDetail.getGoodsCode());
			if (null == store)
				return false;
			if (null != billDetail.getBoxNum()) {
				if (store.getRemainBoxNum() < billDetail.getBoxNum())
					return false;
			}

			if(billDetail.getBoxNum() != null) {
				// 补全仓库信息
				store.setRemainBoxNum(store.getRemainBoxNum() - billDetail.getBoxNum());
				store.setSellBoxNum(store.getSellBoxNum() + billDetail.getBoxNum());
			}
			
			if (billDetail.getBranchNum() !=null) {
				
				// 库存支数量不够，向箱数量借一
				if (store.getRemainBranchNum() < billDetail.getBranchNum()) {
					store.setRemainBoxNum(store.getRemainBoxNum() - 1);
					store.setRemainBranchNum(store.getRemainBranchNum() + billDetail.getSpecification());
				}
				store.setRemainBranchNum(store.getRemainBranchNum() - billDetail.getBranchNum());
				store.setSellBranchNum(store.getSellBranchNum() + billDetail.getBranchNum());

				// 如果已销售的支数量，大于等于规格，则需处理
				if (store.getSellBranchNum() >= billDetail.getSpecification()) {
					store.setSellBoxNum(store.getSellBoxNum() + (int)Math.floor(store.getRemainBranchNum() / billDetail.getSpecification()));
					store.setSellBranchNum(store.getSellBranchNum() % billDetail.getSpecification());
				}
			}
			store.setSaleTransaction(store.getSaleTransaction() + sumTransaction);
			store.setUpdater(loginId);
			store.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd"));

			storeMapper.updateByPrimaryKey(store);
		}
		return true;
	}

	
	@Override
	public DataCountPojo dataCount() {
		DataCountPojo dataCountPojo = new DataCountPojo();
		DecimalFormat df = new DecimalFormat("#.0000");
		
	   List<Store> stores= storeMapper.selectByExample(null);
       for (Store store : stores) {
		dataCountPojo.setPurchaseCount(dataCountPojo.getPurchaseCount()+store.getPurchaseTransaction());
		dataCountPojo.setSaleCount(dataCountPojo.getSaleCount()+store.getSaleTransaction());
	}
       dataCountPojo.setSumCount(dataCountPojo.getPurchaseCount()+dataCountPojo.getSaleCount());
       dataCountPojo.setSaleCountPercent(Double.parseDouble(df.format(dataCountPojo.getSaleCount()/dataCountPojo.getSumCount())));
       dataCountPojo.setPurchaseCountPercent(Double.parseDouble(df.format(dataCountPojo.getPurchaseCount()/dataCountPojo.getSumCount())));

		return dataCountPojo;
	}

	@Override
	public Store getStoreByCode(String goodsCode) {
		StoreExample example = new StoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodsCodeEqualTo(goodsCode);
		List<Store> storeList = storeMapper.selectByExample(example);
		if(Empty4jUtils.listIsNotEmpty(storeList))
			return storeList.get(0);
		return null;
	}
}
