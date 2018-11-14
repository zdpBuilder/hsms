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

import com.hsms.common.ResponseJsonPageListBean;
import com.hsms.mapper.BraAgnTypMapper;
import com.hsms.model.BraAgnTyp;
import com.hsms.model.BraAgnTypExample;
import com.hsms.model.SysUser;
import com.hsms.utils.DateUtil;
import com.hsms.utils.JsonPrintUtil;


@Controller
@RequestMapping("braagntyp")
public class BraAgnTypController {

 @Autowired
 private BraAgnTypMapper braAgnTypMapper;
 
 // 品牌||种类||供应商||列表分页查询
	@RequestMapping("list")
	@ResponseBody
	public void getList(HttpServletRequest request, HttpServletResponse response, String keywords, Integer roleStatus,int limit,
			int page) {
		if(roleStatus==null) {
			JsonPrintUtil.printObjDataWithoutKey(response, null);	
		}
		// limit 每页显示数量
		// page 当前页码
		BraAgnTypExample example = new BraAgnTypExample();
		// 设置分页查询参数
		example.setStartRow((page - 1) * limit);
		example.setPageSize(limit);
		example.setOrderByClause("create_time desc,update_time desc");
		BraAgnTypExample.Criteria criteria = example.createCriteria();
		if (keywords!=null&&keywords!="") {
			keywords = keywords.trim();
			keywords = "%" + keywords + "%";
			// and or联合查询
			example.or().andNameLike(keywords).andStatusEqualTo(roleStatus);
		} else {
			criteria.andStatusEqualTo(roleStatus);// 正常状态
		}
		// 分页查询
		List<BraAgnTyp> sysUsers = braAgnTypMapper.selectByExample(example);
		int count = (int) braAgnTypMapper.countByExample(example);

		ResponseJsonPageListBean listBean = new ResponseJsonPageListBean();
		listBean.setCode(0);
		listBean.setCount(count);
		listBean.setMsg("品牌||种类||供应商||列表");
		listBean.setData(sysUsers);

		// 日志记录及输出前台Json
		if (null != sysUsers && sysUsers.size() > 0) {
			JsonPrintUtil.printObjDataWithoutKey(response, listBean);
		} else {
			JsonPrintUtil.printObjDataWithoutKey(response, null);
		}
	}
	
// 品牌||种类||供应商||新增 编辑
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public void save( Integer id,BraAgnTyp braAgnTyp, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		int count = 0;
		SysUser currentLoginUser = (SysUser) session.getAttribute("CurrentLoginUserInfo");
		// 编辑品牌||种类||供应商||
		if (null != braAgnTyp.getId()&& braAgnTyp.getId() > 0) {
			braAgnTyp.setId(id);
			braAgnTyp.setUpdater(currentLoginUser.getLoginId() + "");
			braAgnTyp.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			count = braAgnTypMapper.updateByPrimaryKeySelective(braAgnTyp);

			
		} else {
			// 新增品牌||种类||供应商||
			braAgnTyp.setCreater(currentLoginUser.getLoginId()+ "");
			braAgnTyp.setCreateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
			count = braAgnTypMapper.insert(braAgnTyp);
			//输出前台Json
			
		} 		
			JsonPrintUtil.printObjDataWithKey(response, count, "data");		
	}

	// 品牌||种类||供应商||批量删除
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
				BraAgnTyp braAgnTyp = braAgnTypMapper.selectByPrimaryKey(id);
				braAgnTyp.setStatus(0);//  0已删除
				braAgnTyp.setUpdateTime(DateUtil.DateToString(new Date(), "yyyy-MM-dd "));
				braAgnTyp.setUpdater(currentLoginUser.getLoginId() + "");
				braAgnTypMapper.updateByPrimaryKeySelective(braAgnTyp);
			}
			// 输出前台Json
			JsonPrintUtil.printObjDataWithKey(response, 1, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, 0, "data");
		}
	}

	// 品牌||种类||供应商||查看
	@RequestMapping(value = "show", method = RequestMethod.POST)
	@ResponseBody
	public void showWH(int id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		BraAgnTyp braAgnTyp= braAgnTypMapper.selectByPrimaryKey(id);
		if (null != braAgnTyp) {		
			JsonPrintUtil.printObjDataWithKey(response, braAgnTyp, "data");
		} else {
			JsonPrintUtil.printObjDataWithKey(response, null, "data");
		}
	}	
 
}
