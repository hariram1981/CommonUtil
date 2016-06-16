package com.hariram.common.util;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DynamicToStringTest {

	@Test
	public void test() {
		class Obj implements DynamicToString {
			private String a;
			private int b;
			Obj() {
				a = "";
				b = 0;
			}
			Obj(String a, int b) {
				this.a = a;
				this.b = b;
			}
			public String getA() {
				return a;
			}
			public void setA(String a) {
				this.a = a;
			}
			public int getB() {
				return b;
			}
			public void setB(int b) {
				this.b = b;
			}
		}
		
		Obj obj = new Obj("testing", 100);
		System.out.println(obj.printString());
		Assert.assertTrue(true);
	}

}
