package com.libarary.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.libarary.Base.Locator;
import com.libarary.Base.Enum.ByType;


public class LocatorXMLUtil {
	/**
	 * @author Young
	 * @param path
	 * @param pageName
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, Locator> readLocatorXMLDocument(String path) throws Exception {
		HashMap<String, Locator> locatorMap = new HashMap<String, Locator>();
//		locatorMap.clear();
		File file = new File(path);
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				String type = null;
				String timeOut = "3";
				String value = null;
				String locatorName = null;
				Element locator = (Element) i.next();
			 for (Iterator<?> j = locator.attributeIterator(); j.hasNext();) {
						Attribute attribute = (Attribute) j.next();
						if (attribute.getName().equals("type")) {
							type = attribute.getValue();
						} else if (attribute.getName().equals("timeOut")) {
							timeOut = attribute.getValue();
						} else {
							value = attribute.getValue();
						}

					}
					Locator temp = new Locator(value,
							Integer.parseInt(timeOut), getByType(type));
					locatorName = locator.getText();
					locatorMap.put(locatorName, temp);
				}
				return locatorMap;
	}
		


	/**
	 * @param type
	 */
	public static ByType getByType(String type) {
		ByType byType = ByType.id;
		if (type == null || type.equalsIgnoreCase("id")) {
			byType = ByType.id;
		} else if (type.equalsIgnoreCase("xpath")) {
			byType = ByType.xpath;
		} else if (type.equalsIgnoreCase("linkText")) {
			byType = ByType.linkText;
		} else if (type.equalsIgnoreCase("name")) {
			byType = ByType.name;
		} else if (type.equalsIgnoreCase("className")) {
			byType = ByType.className;
		} else if (type.equalsIgnoreCase("cssSelector")) {
			byType = ByType.cssSelector;
		} else if (type.equalsIgnoreCase("partialLinkText")) {
			byType = ByType.partialLinkText;
		} else if (type.equalsIgnoreCase("tagName")) {
			byType = ByType.tagName;
		}
		return byType;
	}
	

	

}
