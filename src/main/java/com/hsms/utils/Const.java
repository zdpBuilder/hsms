package com.hsms.utils;

import org.springframework.context.ApplicationContext;

public class Const {
	    public static final String SESSION_USER_STATUS="loginStatus"; 
		public static final String SESSION_USER = "CurrentLoginUserInfo";
		public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(customer)|(appGoods)|(cart)|(appBill)|(code)).*";	
		public static ApplicationContext WEB_APP_CONTEXT = null; 
		public static final String SUN_GOODS_CODE="GO";
		public static final String SUN_SALE_CODE="SA";
	}



