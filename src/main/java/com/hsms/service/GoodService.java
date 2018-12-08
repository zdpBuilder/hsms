package com.hsms.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.model.Goods;

public interface GoodService {

	/**
	 * 
	 * @Description: 获取商品列表
	 * @param limit    每页数量
	 * @param page     第几页
	 * @param keywords 搜索关键字
	 * @return
	 */
	ResponseJsonPageListBean getList(int limit, int page, String keywords);

	/**
	 * 
	 * @Description: 新增或编辑商品
	 * @param session
	 * @param goods
	 * @return
	 */
	int save(HttpSession session, Goods goods);

	/**
	 * 
	 * @Description: 删除
	 * @param session
	 * @param idStr   删除商品的id字符串，以逗号分隔
	 * @return
	 */
	int deleteBatch(HttpSession session, String idStr);

	/**
	 * 
	 * @Description: 根据商品id获取商品信息
	 * @param goodsId 商品id
	 * @return
	 */
	Goods getOneById(int goodsId);
	
	/**
	 * 
	 * @Description: 根据商品编码获取商品信息
	 * @param code 商品编码
	 * @return
	 */
	Goods getOneByCode(String code);
	
	/**
	 * 
	 * @Description: 批量处理
	 * @param goodsList
	 * @param loginId
	 * @return
	 */
	boolean addList(List<Goods> goodsList, String loginId);
}
