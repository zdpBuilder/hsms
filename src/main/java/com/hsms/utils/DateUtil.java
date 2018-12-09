package com.hsms.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期工具
 *
 */
public class DateUtil {
   
	/**
	 * 将日期转换为指定格式的字符串 yyyy-MM-dd ||yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @param dateString
	 * @return
	 */
	public static String DateToString(Date date,String dateString) {
		 SimpleDateFormat formatter = new SimpleDateFormat(dateString);
		return formatter.format(date);
	}
	
	/**
	 * 将字符串转换为指定格式的日期
	 * @param dateString
	 * @param Dateformat
	 * @return
	 * @throws Exception
	 */
	public static Date StringToDate(String dateString,String Dateformat) throws Exception {
		 SimpleDateFormat formatter = new SimpleDateFormat(Dateformat);
			return formatter.parse(dateString);
	}
}
