package com.hsms.utils;

import java.lang.reflect.Field;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json工具
 *
 */
public class JsonUtils {

	private static final ObjectMapper MAPPER = ignoreUnknown();
	
	public static ObjectMapper ignoreUnknown() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   return mapper;
	}
	/**
	 * 将对象转换为json字符串
	 * 
	 * @param data
	 * @return
	 */
	public static String objectToJson(Object data) {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json字符串转换为对象
	 * 
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将json字符串转换为list
	 * 
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 将list转换为json字符串
	 * 
	 * @param list
	 * @return
	 */
	public static String listToJson(List<?> list) {
		// 变量
		StringBuffer jsonStr = new StringBuffer();
		// 前提条件
		if (null == list || 0 == list.size()) {
			return null;
		}
		// class对象
		Class<?> classType = list.get(0).getClass();
		// 得到javabean的名字
		String javaBeanClassName = classType.getSimpleName();

		jsonStr.append("[");
		// 此JavaBean中所声明的所有字段
		Field[] fields = classType.getDeclaredFields();
		for (int i = 0; i < list.size(); i++) {
			jsonStr.append("{");
			for (Field field : fields) {
				// 得到字段名
				String fieldName = field.getName();
				field.setAccessible(true);
				// 得到指定对象上此 Field 表示的字段的值
				Object fieldValue;
				try {
					fieldValue = field.get(list.get(i));
					jsonStr.append("\"").append(fieldName.toLowerCase()).append("\":").append("\"").append(fieldValue)
							.append("\"").append(",");
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			jsonStr.deleteCharAt(jsonStr.length() - 1);
			jsonStr.append("},");
		}
		jsonStr.deleteCharAt(jsonStr.length() - 1);
		jsonStr.append("]");
		return jsonStr.toString();
	}
}
