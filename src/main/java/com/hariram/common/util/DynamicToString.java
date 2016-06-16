/**
 * 
 */
package com.hariram.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Class overriding toString method and
 * dynamically prints out the values of
 * variables
 * 
 * @author hariram
 * date 16-Jun-2016
 */
public interface DynamicToString {
	/**
	 * Dynamically fetches the variables and values of the super class
	 * 
	 * @return String of variables and their values
	 */
	default String printString() {
		final StringBuffer strBuff = new StringBuffer();
		Field[] fields = this.getClass().getDeclaredFields();
		Arrays.asList(fields).stream()
			.filter(e -> !e.getName().contains("this"))
			.forEach(field-> {
				String name = field.getName();
				String getterName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
				System.out.println(getterName);
				strBuff.append(field.getName() + ": ");
				String value = "";
				try {
					Method method = this.getClass().getMethod("getA", new Class[] {});
					value = (String) method.invoke(this, new Object[] {});
				} catch (Exception e) {
					e.printStackTrace();
					value = "";
				}
				strBuff.append(value + ",\n");
			});
		
		return strBuff.toString();
	}
}
