package com.hsms.utils;

import java.util.List;
import java.util.Map;


/**
 * 
 * @ClassName:  Empty4jUtils   
 * @Description:   鍒ょ┖宸ュ叿鍖�
 * @author: 娌冲寳鐪佸缓绛戠瀛︾爺绌堕櫌鍒涚爺宸ヤ綔瀹� - 寮犲織浼� 
 * @date:   2018骞�4鏈�10鏃� 涓嬪崍11:27:40   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 娉ㄦ剰锛氭湰鍐呭浠呴檺浜庢渤鍖楃渷寤虹瓚绉戝鐮旂┒闄㈠垱鐮斿伐浣滃鍐呴儴浼犻槄锛岀姝㈠娉勪互鍙婄敤浜庡叾浠栫殑鍟嗕笟鐩�
 */
public class Empty4jUtils {
	
	/**
	 * 鍒ゆ柇瀛楃涓蹭负绌�
	 * 
	 * @param str 瀛楃涓�
	 * @return 鑻ュ瓧绗︿覆涓嶅瓨鍦� 鎴栬�� 瀛楃涓插幓绌烘牸鍚庝负绌�(length涓�0),杩斿洖true
	 */
	public static boolean stringIsEmpty(String str) {
		/**
		 * isEmpty()浠嶫DK1.6寮�濮�
		 */
		return str == null || str.trim().isEmpty();
	}
	
	/**
	 * 鍒ゆ柇瀛楃涓蹭笉涓虹┖
	 * 
	 * @param str 瀛楃涓�
	 * @return 鑻ュ瓧绗︿覆瀛樺湪 骞朵笖 瀛楃涓插幓绌烘牸鍚庝笉涓虹┖(length>0),杩斿洖true
	 */
	public static boolean stringIsNotEmpty(String str) {
		return !stringIsEmpty(str);
	}
	
	/**
	 * 鍒ゆ柇鏁板�间负绌�
	 * 
	 * @param number 瀛楃涓�
	 * @return 鑻ユ暟鍊间负绌�,杩斿洖true
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static boolean intIsEmpty(Integer number) {
		return  null == number || "".equals(number);
	}
	
	/**
	 * 鍒ゆ柇鏁板�间笉涓虹┖
	 * 
	 * @param number 瀛楃涓�
	 * @return 鑻ユ暟鍊间笉涓虹┖,杩斿洖true
	 */
	public static boolean intIsNotEmpty(Integer number) {
		return !intIsEmpty(number);
	}
	
	/**
	 * 鍒ゆ柇list鍒楄〃涓虹┖
	 * @param <T> 娉涘瀷
	 * 
	 * @param list List鍒楄〃
	 * @return 鑻ist鍒楄〃涓嶅瓨鍦� 鎴栬�� list鍒楄〃涓嶅寘鍚厓绱�,杩斿洖true
	 */
	public static <T> boolean listIsEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}
	
	/**
	 * 鍒ゆ柇list鍒楄〃涓嶄负绌�
	 * @param <T> 娉涘瀷
	 * 
	 * @param list List鍒楄〃
	 * @return 鑻ist鍒楄〃瀛樺湪 骞朵笖 list鍒楄〃鍖呭惈鍏冪礌,杩斿洖true
	 */
	public static <T> boolean listIsNotEmpty(List<T> list) {
		return !listIsEmpty(list);
	}
	
	/**
	 * 鍒ゆ柇map鏄犲皠涓虹┖
	 * @param <K> 娉涘瀷
	 * @param <V> 娉涘瀷
	 * 
	 * @param map Map鏄犲皠
	 * @return 鑻ap鏄犲皠涓嶅瓨鍦� 鎴栬�卪ap鏄犲皠鏈寘鍚敭-鍊兼槧灏勫叧绯�,杩斿洖true
	 */
	public static <K, V> boolean mapIsEmpty(Map<K, V> map) {
		return map == null || map.isEmpty();
	}
	
	/**
	 * 鍒ゆ柇map鏄犲皠涓嶄负绌�
	 * @param <K> 娉涘瀷
	 * @param <V> 娉涘瀷
	 * 
	 * @param map Map鏄犲皠
	 * @return 鑻ap鏄犲皠瀛樺湪 骞朵笖map鏄犲皠鍖呭惈閿�-鍊兼槧灏勫叧绯�,杩斿洖true
	 */
	public static <K, V> boolean mapIsNotEmpty(Map<K, V> map) {
		return !mapIsEmpty(map);
	}
}
