package com.hsms.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.hsms.model.Goods;
/**
 * List类型转换
 *
 */
public class ConvertUtil {
	
	private final static String getStrPrefix = "get";
	
	private final static String setStrSuffix = "set";
	
	private static Method getMethod;
	
	private static Method setMethod;
	
	/**
	 * 
	 * @Description: 将list中数据和目标对象属性相同的，进行复制
	 * @param list
	 * @param targetBeanType
	 * @return
	 */
	public static <T> List<T> convertList(List<?> list, Class<T> targetBeanType){
		if(Empty4jUtils.listIsNotEmpty(list)) {
			List<T> resultList = new ArrayList<T>();
			T t = null;
			for (int i = 0; i < list.size(); i++) {
				try {
					t = targetBeanType.newInstance();
				} catch (InstantiationException | IllegalAccessException e) { 
					e.printStackTrace();
					return null;
				}
				//相同属性，值进行拷贝
				BeanUtils.copyProperties(list.get(i), t);
				resultList.add(t);
			}
			return resultList;
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: 转化为特定的goods对象
	 * @param list
	 * @param targetBeanType
	 * @param sourceAttributeName
	 * @param targetAttributeName
	 * @return
	 */
	public static <T> List<T> convert2GoodsList(List<?> list, Class<T> targetBeanType, String sourceSetSuffix,String targetSetSuffix ){
		if(Empty4jUtils.listIsNotEmpty(list)) {
			List<T> resultList = convertList(list, targetBeanType);
			if(Empty4jUtils.listIsNotEmpty(resultList)) {
				//特殊字段处理
				convert2GoodsSpecialAtrribute(list, resultList, targetBeanType, sourceSetSuffix,targetSetSuffix);
				return resultList;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Description: 特殊字段处理
	 * @param sourceList
	 * @param targeList
	 * @param targetBeanType
	 * @return
	 */
	private static <T> List<T> convert2GoodsSpecialAtrribute(List<?> sourceList, List<T> targeList,Class<T> targetBeanType,
			String sourceSetSuffix, String targetSetSuffix){
		if(Empty4jUtils.listIsEmpty(sourceList) || Empty4jUtils.listIsEmpty(targeList) || sourceList.size() != targeList.size())
			return null;
		
		Integer result = null;
		try {
			getMethod = sourceList.get(0).getClass().getMethod(getStrPrefix + sourceSetSuffix, null);
			setMethod = targetBeanType.getMethod(setStrSuffix + targetSetSuffix, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		if(Goods.class.equals(targetBeanType)) {
			for (int i = 0; i < sourceList.size(); i++) {
				try {
					result = (Integer)getMethod.invoke(sourceList.get(i), null);
					if(null != result)
						setMethod.invoke(targeList.get(i), result);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	

}
