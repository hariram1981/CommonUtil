package com.hariram.common.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Utility class with common functionalities.
 * 
 * @author hariram
 * @date 05-Nov-2014
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
	 * @param enumList list of enum objects
	 * @return list of string
	 */
	public static List<String> enumToList(List<Object> enumList) {
		LOGGER.info("Util.enumToList - enumList: " + enumList);
		List<String> list = new ArrayList<String>();

		enumList.stream().forEach(e -> {
			list.add(e.toString());
		});
		
		LOGGER.info("Util.enumToList - enumList: " + enumList + ", list: " + list);
		return list;
	}
}
