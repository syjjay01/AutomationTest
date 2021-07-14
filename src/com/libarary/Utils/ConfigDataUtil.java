package com.libarary.Utils;

import java.util.HashMap;
import java.util.Map;


public class ConfigDataUtil {
	
	static HashMap<String, String> configMap;
	static Map<String, String> testDataMap;
	
	//获取config数据
	public static HashMap<String, String> getConfigMap() throws Exception {
		 configMap = ConfigXMLUtil.readConfigXMLDocument();
		 return configMap;
	}
	
	//在这个存储好的map里，根据key找到对应value
	public static String getConfig(String configDataKey) {
		String configName = null;
		try {
			configName = ConfigXMLUtil.readConfigXMLDocument().get(configDataKey);
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return configName;
	}	
}
