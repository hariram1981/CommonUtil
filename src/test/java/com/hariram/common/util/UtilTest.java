/**
 * 
 */
package com.hariram.common.util;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author hariram
 *
 */
public class UtilTest {
	
	enum TYPES {A, B, C, D};
	
	@Test
	public void test() {
		System.out.println(Util.enumToList(Arrays.asList(TYPES.values())));
		fail("Not yet implemented");
	}

}
