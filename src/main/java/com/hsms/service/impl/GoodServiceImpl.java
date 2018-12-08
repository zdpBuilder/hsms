package com.hsms.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.GoodsMapper;
import com.hsms.model.Goods;
import com.hsms.model.GoodsExample;
import com.hsms.model.GoodsExample.Criteria;
import com.hsms.model.SysUser;
import com.hsms.service.GoodService;
import com.hsms.utils.DateUtil;
import com.hsms.utils.Empty4jUtils;

@Service
public class GoodServiceImpl implements GoodService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public ResponseJsonPageListBean getList(int limit, int page, String keywords) {
		// limit 每页数量
		// page 第几页
		GoodsExample example = new GoodsExample();
		// 动态拼装sql
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		GoodsExample.Criteria criteria = example.createCriteria();
		if (Empty4jUtils.stringIsNotEmpty(keywords)) {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			// and or拼装
			example.or().andTitleLike(keywords).andStatusEqualTo(1);
			example.or().andGoodsCodeLike(keywords).andStatusEqualTo(1);
		} else {
			criteria.andStatusEqualTo(1);
		}
		
		List<Goods> goodsList = goodsMapper.selectByExample(example);
		int count = 0;
		if(Empty4jUtils.listIsNotEmpty(goodsList)) {
			count = (int) goodsMapper.countByExample(example);
		}
		return  new ResponseJsonPageListBean(0, "商品列表", count, goodsList);
	}

	@Override
	public int save(HttpSession session, Goods goods) {
		int count = 0;
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		// 新增
 		if (Empty4jUtils.intIsNotEmpty(goods.getId())) {		
 			goods.setUpdater(currentLoginUser.getLoginId() + "");
 			goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.updateByPrimaryKeySelective(goods);

 		//编辑	
 		} else {
 			goods.setStatus(1);
 			goods.setCreater(currentLoginUser.getLoginId()+ "");
 			goods.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.insertSelective(goods);
 		} 	
 		return count;
	}

	@Override
	@Transactional(readOnly = false)
	public int deleteBatch(HttpSession session, String idStr) throws RuntimeException {
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		String[] idArr = idStr.split(",");
		int id;
		int count = 0;
		for (int i = 0; i < idArr.length; i++) {
			count = 0;
			id = Integer.parseInt(idArr[i]);
			Goods goods = goodsMapper.selectByPrimaryKey(id);
			goods.setStatus(0);//  0表示删除
			goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			goods.setUpdater(currentLoginUser.getLoginId() + "");
			count = goodsMapper.updateByPrimaryKeySelective(goods);
		}
		return count;
	}

	@Override
	public Goods getOneById(int goodsId) {
		return goodsMapper.selectByPrimaryKey(goodsId);
	}

	@Override
	public Goods getOneByCode(String code) {
		GoodsExample example = new  GoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodsCodeEqualTo(code).andStatusEqualTo(1);
		List<Goods> goodsList = goodsMapper.selectByExample(example);
		if(Empty4jUtils.listIsNotEmpty(goodsList)) {
			return goodsList.get(0);
		}
		return null;
	}

	@Override
	public boolean addList(List<Goods> goodsList, String loginId) {
		if(Empty4jUtils.listIsEmpty(goodsList))
			return false;
		int result = 0;
		for (Goods goods : goodsList) {
			result = 0;
			//数据库已经存在
			if(null != goods.getId()) {
				goods.setUpdater(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				goods.setUpdater(loginId);
				result = this.goodsMapper.updateByPrimaryKey(goods);
			}else {
				//数据库不存在
				goods.setStatus(1);
				goods.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				goods.setCreater(loginId);
				result = this.goodsMapper.insert(goods);
			}
			
		}
		//设置返回值
		if(1 == result)
			return true;
		return false;
	}

}
