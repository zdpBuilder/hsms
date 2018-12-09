package com.hsms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 读取Properties文件 File: PropertiesUtils.java
 */
public final class PropertiesUtils {
    private static Properties prop = new Properties();
    
    private static PropertiesUtils proClass = null;
    /**
     * 属性文件全名,需要的时候请重新配置PFILE
     */
    private static String PFILE = "classpath:db.properties";

    /**
     * 私有构造方法，不需要创建对象
     */
    private PropertiesUtils() {

    }
    static{
        if (proClass == null) {
            proClass = new PropertiesUtils();
            proClass.load();
        }
    }

    /**
     * 获取对象实例。
     * 
     * @return
     */
    public static PropertiesUtils getInstance() {
        if (proClass == null) {
            proClass = new PropertiesUtils();
            proClass.load();
        }
        return proClass;
    }

    /**
     * 重新加载配置文件。
     * 
     * @param pathName
     * @return
     */
    public boolean load() {
    	String pathName1 = PropertiesUtils.class.getClassLoader().getClass().getName();
        String pathName = PropertiesUtils.class.getClassLoader().getResource(PFILE).getPath();
        System.out.println(pathName);
        return load(pathName);
    }

    /**
     * 重新加载配置文件。
     * 
     * @param pathName
     * @return
     */
    public boolean load(String pathName) {
        boolean flg = false;
        if (pathName != null && pathName.trim().length() > 0) {
            try {
                InputStream in = new FileInputStream(pathName);
                prop.load(new InputStreamReader(in, "UTF-8"));
                flg = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flg;
    }

    /**
     * 根据主键获取值。
     * 
     * @param key
     *            主键
     * @return
     */
    public String getConfigItem(String key) {
        String value = prop.getProperty(key);
        if (value == null)
            value = "";

        return value;
    }

}