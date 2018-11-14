package com.hsms.utils;

import java.util.Random;

/**
*
* 流水号生成器
*
* @project
* @version v1.0
* @author wangboak (wangboak@126.com)
* @createDate 2014年10月7日 下午2:01:00
* @company (C) Copyright 迅谨（北京）科技有限公司 2014-2114<br/>
* @since JDK 1.7
*
*/
public class SNUtil {

	 /**
     * 生成16位随机数字
     * @param type 序号前缀
     * @return
     */
    public static String getSNNumber(String type){
    	Random rand=new Random();
        String cardNnumer= type+"";
        for(int a=0;a<16;a++){
        	cardNnumer+=rand.nextInt(10);
        }
        return cardNnumer;
    }
    
    public static void main(String[] args) {
		
        System.out.println(getSNNumber("CK"));
        
    	
	}
}
