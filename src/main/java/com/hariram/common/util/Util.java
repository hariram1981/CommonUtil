package com.hariram.common.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Utility class with common functionalities.
 * 
 * @author hariram
 * date 05-Nov-2014
 */
public final class Util {

	private static final Logger LOGGER = Logger.getLogger(Util.class);

	/**
	 * Private constructor as utility class.
	 */
	private Util() {
	}

	/**
	 * Convert list of enum objects to list of string
	 * 
	 * @param enumList
	 *            list of enum objects
	 * @return list of string
	 */
	public static List<String> enumToList(List<Object> enumList) {
		LOGGER.info("Util.enumToList - enumList: " + enumList);
		List<String> list = new ArrayList<String>();

		enumList.stream().forEach(e -> {
			list.add(e.toString());
		});

		LOGGER.info("Util.enumToList - enumList: " + enumList + ", list: "
				+ list);
		return list;
	}

	/**
	 * Get all properties (key-value) of a resource bundle
	 * 
	 * @param filePath path of bundle file
	 * @param fileName name of bundle file
	 * @return map (key, value) of all properites in the resource bundle
	 */
	
	public static Map<String, String> getProperties(String filePath, String fileName) {
		LOGGER.info("Util.getProperties, filePath: " + filePath + ", fileName: " + fileName);
		Map<String, String> propertiesMap = new HashMap<String, String>();
		try {
			ResourceBundle bundle = getBundle(filePath, fileName);
			Enumeration<String> keys = bundle.getKeys();
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = bundle.getString(key);
				propertiesMap.put(key, value);
			}
		} catch (MissingResourceException e) {
			LOGGER.error("Util.getProperties MissingResourceException, message : " + e.getMessage());
		}
		LOGGER.info("Util.getProperties, propertiesMap: ");
		LOGGER.info(propertiesMap);
		return propertiesMap;
	}
	
	/**
	 * Get value for a key in a resource bundle
	 * 
	 * @param filePath path of bundle file
	 * @param fileName name of bundle file
	 * @param key key in the bundle
	 * @return value of the particular key
	 */
	public static String getProperty(String filePath, String fileName, String key) {
		LOGGER.info("Util.getProperty, filePath: " + filePath + ", fileName: " + fileName + ", key: " + key);
		String value = "";
		try {
			ResourceBundle bundle = getBundle(filePath, fileName);
			value = bundle.getString(key);
		} catch (MissingResourceException e) {
			LOGGER.error("Util.getProperty MissingResourceException, message : " + e.getMessage());
			value = "";
		}
		LOGGER.info("Util.getProperty, key: " + key + ", value: " + value);
		return value;
	}
	
	/**
	 * Get bundle for particular path and file name
	 * 
	 * @param filePath path of bundle file
	 * @param fileName name of bundle file
	 * @return bundle bundle for particular path and name
	 */
	public static ResourceBundle getBundle(String filePath, String fileName) {
		LOGGER.info("Util.getBundle, filePath: " + filePath + ", fileName: " + fileName);
		if(!Objects.isNull(fileName)) {
			if(fileName.contains(".properties")) {
				fileName = fileName.split(".properties")[0];
			}
		}
		
		if(Objects.isNull(filePath)) {
		}
		
		ResourceBundle bundle = null;
		try {
			File file = new File(filePath);
			URL[] urls = { file.toURI().toURL() };
			ClassLoader loader = new URLClassLoader(urls);
			bundle = ResourceBundle.getBundle(fileName,
					Locale.getDefault(), loader);
		} catch (MalformedURLException e) {
			LOGGER.error("Util.getBundle MalformedURLException, message : " + e.getMessage());
		}
		LOGGER.info("Util.getBundle, bundle: " + bundle);
		return bundle;
	}
}
