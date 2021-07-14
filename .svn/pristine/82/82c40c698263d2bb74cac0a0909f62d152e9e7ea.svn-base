package com.libarary.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;



public class ConfigXMLUtil {
	/**
	 * @author Young
	 * @param path
	 * @param pageName
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, String> readConfigXMLDocument() throws Exception {
	    String path = System.getProperty("user.dir") + "\\setting\\"+"Config.xml";
		HashMap<String, String> configMap = new HashMap<String, String>();
		File file = new File(path);
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				String value = null;
				String configName = null;
				Element configElement = (Element) i.next();
			 for (Iterator<?> j = configElement.attributeIterator(); j.hasNext();) {
						Attribute attribute = (Attribute) j.next();
						value = attribute.getValue();
					}
			 configName = configElement.getText();	
			 configMap.put(configName, value);
				}
				return configMap;
	}

}
