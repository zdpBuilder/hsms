package com.hsms.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.CustomerMapper;
import com.hsms.model.Customer;
import com.hsms.model.CustomerExample;
import com.hsms.model.SysUser;
import com.hsms.utils.DateUtil;
import com.hsms.utils.JsonPrintUtil;




@Controller
@RequestMapping("/adminCustomer")
public class AdminCustomerController {
	@Autowired
	private  CustomerMapper customerMapper;
	

	  // 客户列表分页查询
	 	@RequestMapping("list")
	 	@ResponseBody
	 	public void equipmentList(HttpServletRequest request, HttpServletResponse response, String keywords, int limit,
	 			int page) {
	 		// limit 每页显示数量
	 		// page 当前页码
	 		CustomerExample example = new CustomerExample();
	 		// 设置分页查询参数
	 		example.setStartRow((page - 1) * limit);
	 		example.setPageSize(limit);
	 		example.setOrderByClause("create_time desc,update_time desc");
	 		CustomerExample.Criteria criteria = example.createCriteria();
	 		if (keywords!=null&&keywords!="") {
	 			keywords = keywords.trim();
	 			keywords = "%" + keywords + "%";
	 			// and or联合查询
	 			example.or().andNameLike(keywords).andStatusNotEqualTo(0);
	 			example.or().andLoginIdLike(keywords).andStatusNotEqualTo(0);
	 		} else {
	 			criteria.andStatusNotEqualTo(0);// 正常状态
	 		}
	 		// 分页查询
	 		List<Customer> customers = customerMapper.selectByExample(example);
	 		int count = (int) customerMapper.countByExample(example);

	 		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
	 		listBean.setCode(0);
	 		listBean.setCount(count);
	 		listBean.setMsg("客户列表");
	 		listBean.setData(customers);

	 		// 日志记录及输出前台Json
	 		if (null != customers && customers.size() > 0) {
	 			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
	 		} else {
	 			JsonPrintUtil.printObjDataWithoutKey(response, null);
	 		}
	 	}
	 	
	 // 客户新增 编辑
	 	@RequestMapping(value = "save", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void save(Customer customer, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		int count = 0;
	 		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
	 		// 编辑客户
	 		if (null != customer.getId()&& customer.getId() > 0) {
	 			Customer customerOld = customerMapper.selectByPrimaryKey(customer.getId());
	 			customer.setUpdater(currentLoginUser.getLoginId() + "");
	 			customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			if (!customerOld.getLoginPassword().equals(customer.getLoginPassword())) {
	 				customer.setLoginPassword(DigestUtils.md5DigestAsHex(customer.getLoginPassword().getBytes()));
	 			}
	 			count = customerMapper.updateByPrimaryKeySelective(customer);

	 			
	 		} else {
	 			// 新增客户
	 			customer.setCreater(currentLoginUser.getLoginId());
	 			customer.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 			customer.setLoginPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
	 			count = customerMapper.insert(customer);
	 			//输出前台Json
	 			
	 		} 		
 				JsonPrintUtil.printObjDataWithKey(response, count, "data");		
	 	}

	 	// 客户批量删除
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
	 				Customer customer= customerMapper.selectByPrimaryKey(id);
	 				customer.setStatus(0);// 1正常 0已删除
	 				customer.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
	 				customer.setUpdater(currentLoginUser.getLoginId() + "");
	 				customerMapper.updateByPrimaryKeySelective(customer);
	 			}
	 			// 输出前台Json
	 			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
	 		}
	 	}

	 	// 客户查看
	 	@RequestMapping(value = "show", method = RequestMethod.POST)
	 	@ResponseBody
	 	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		Customer customer = customerMapper.selectByPrimaryKey(id);
	 		if (null != customer) {		
	 			JsonPrintUtil.printObjDataWithKey(response, customer, "data");
	 		} else {
	 			JsonPrintUtil.printObjDataWithKey(response, null, "data");
	 		}
	 	}	
		// 登录名校验
	 	@RequestMapping(value = "loginIdCheck", method = RequestMethod.POST)
	 	@ResponseBody
	 	public boolean loginIdCheck(String loginId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
	 		CustomerExample example=  new CustomerExample();
	 		CustomerExample.Criteria criteria = example.createCriteria();
	 		criteria.andLoginIdEqualTo(loginId);
	 		List<Customer> list =customerMapper.selectByExample(example);
	 		if(list.size()>0&&list!=null) {
	 			return false;
	 		}
	 		return true;
	 	}
}
