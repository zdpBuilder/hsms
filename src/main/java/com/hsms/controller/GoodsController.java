package com.hsms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.GoodsMapper;
import com.hsms.model.Goods;
import com.hsms.model.GoodsExample;
import com.hsms.model.SysUser;
import com.hsms.utils.DateUtil;
import com.hsms.utils.JsonPrintUtil;






@Controller
@RequestMapping("goods")
public class GoodsController  {
  @Autowired
  private GoodsMapper goodsMapper;

  // 商品列表分页查询
 	@RequestMapping("list")
 	@ResponseBody
 	public void getList(HttpServletRequest request, HttpServletResponse response, String keywords,int limit,
 			int page) {
 		// limit 每页显示数量
 		// page 当前页码
 		GoodsExample example = new GoodsExample();
 		// 设置分页查询参数
 		example.setStartRow((page - 1) * limit);
 		example.setPageSize(limit);
 		example.setOrderByClause("create_time desc,update_time desc");
 		GoodsExample.Criteria criteria = example.createCriteria();
 		if (keywords!=null&&keywords!="") {
 			keywords = keywords.trim();
 			keywords = "%" + keywords + "%";
 			// and or联合查询
 			example.or().andTitleEqualTo(keywords).andStatusEqualTo(1);
 			example.or().andCodeLike(keywords).andStatusEqualTo(1);
 		} else {
 			criteria.andStatusEqualTo(1);// 正常状态
 		}
 		// 分页查询
 		List<Goods> goodsList = goodsMapper.selectByExample(example);
 		int count = (int) goodsMapper.countByExample(example);

 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
 		listBean.setCode(0);
 		listBean.setCount(count);
 		listBean.setMsg("商品列表");
 		listBean.setData(goodsList);

 		// 日志记录及输出前台Json
 		if (null != goodsList && goodsList.size() > 0) {
 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
 		} else {
 			JsonPrintUtil.printObjDataWithoutKey(response, null);
 		}
 	}
 	
 // 商品新增 编辑
 	@RequestMapping(value = "save", method = RequestMethod.POST)
 	@ResponseBody
 	public void save(Goods goods, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 		
 		int count = 0;
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		// 编辑商品
 		if (null != goods.getId()&& goods.getId() > 0) {		
 			goods.setUpdater(currentLoginUser.getLoginId() + "");
 			goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.updateByPrimaryKeySelective(goods);

 			
 		} else {
 			// 新增商品
 			goods.setStatus(1);
 			goods.setCreater(currentLoginUser.getLoginId()+ "");
 			goods.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 			count = goodsMapper.insertSelective(goods);
 			//输出前台Json
 			
 		} 		
 			JsonPrintUtil.printObjDataWithKey(response, count, "data");		
 	}

 	// 商品批量删除
 	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
 	@ResponseBody
 	public void deleteBatch(String idStr, HttpServletRequest request, HttpServletResponse response,
 			HttpSession session) {
 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
 		if (StringUtils.isNotBlank(idStr)) {
 			String[] idArr = idStr.split(",");
 			for (int i = 0; i < idArr.length; i++) {
 				// 更新所选设备分类为删除状态
 				int id = Integer.parseInt(idArr[i]);
 				Goods goods = goodsMapper.selectByPrimaryKey(id);
 				goods.setStatus(0);//  0已删除
 				goods.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
 				goods.setUpdater(currentLoginUser.getLoginId() + "");
 				goodsMapper.updateByPrimaryKeySelective(goods);
 			}
 			// 输出前台Json
 			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
 		} else {
 			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
 		}
 	}

 	// 商品查看
 	@RequestMapping("show")
 	@ResponseBody
 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
 		Goods goods= goodsMapper.selectByPrimaryKey(id);
 		if (null != goods) {		
 			JsonPrintUtil.printObjDataWithKey(response, goods, "data");
 		} else {
 			JsonPrintUtil.printObjDataWithKey(response, null, "data");
 		}
 	}	
  
}
