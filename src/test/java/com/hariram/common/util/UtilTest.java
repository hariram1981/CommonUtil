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
	//For property file
	private String filePath;
	private String fileName;
	private String key;
	//For dynamically invoking method of class
	private String jarPath;
	private String className;
	private String methodName;
	private Object[] methodArgs;
	
	enum TYPES {A, B, C, D};
	
	@Before
	public void setupPropertyFile() throws Exception {
		filePath = "/opt/ad2";
		fileName = "avfw";
		key = "restservice.url";
/*		filePath = "/home/hariram/Personal/github/PropertyAnnotation/src/main/resources/";
		fileName = "log4j.properties";
		key = "log4j.rootLogger";
		System.out.println(fileName.split("."));
		System.out.println(fileName.split(".properties")[0]);
*/	
		jarPath = "/home/hariram/git/avfw_10Oct2014/AD2DBReport/build/libs/ad2dbreport-0.5.jar";
		className = "edu.am.iotm.ad2.report.db.MyClass";
		methodName = "get";
		methodArgs = new Object[]{};
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
	
	@Test
	public void invokeMethodOfClassInJar() {
		Object returnObj = Util.invokeMethodOfClassInJar(jarPath, className, methodName, methodArgs);
		
		assertTrue(returnObj != null);
	}
}
