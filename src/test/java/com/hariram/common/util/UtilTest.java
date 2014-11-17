/**
 * 
 */
package com.hariram.common.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hariram
 *
 */
public class UtilTest {
	
	private String filePath;
	private String fileName;
	private String key;
	
	enum TYPES {A, B, C, D};
	
	@Before
	public void setupPropertyFile() throws Exception {
		filePath = "/opt/ad2";
		fileName = "avfw";
		key = "restservice.url";
	}
	
	@After
	public void teardown() throws Exception {
	}
	
	@Test
	public void test() {
		System.out.println(Util.enumToList(Arrays.asList(TYPES.values())));
		assertTrue(true);
	}
	
	@Test
	public void getProperty() {
		String value = Util.getProperty(filePath, fileName, key);
		assertTrue(value != null && !value.equals(""));
	}
	
	@Test
	public void getProperties() {
		Map<String, String> propertiesMap = Util.getProperties(filePath, fileName);
		assertTrue(propertiesMap != null && propertiesMap.size() > 0);
	}
}
