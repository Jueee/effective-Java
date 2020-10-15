package com.jueee.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Item39Example03 {

	public static void main(String[] args) throws Exception {
		String testClassName = "com.jueee.item39.Item39Example02";
		
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(testClassName);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Item39Example01.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("Invalid @Item39Example01: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
	
	/* 
	 * 打印结果：
	 * public static void com.jueee.item39.Item39Example02.m3() failed: java.lang.RuntimeException: Boom
	 * public static void com.jueee.item39.Item39Example02.m7() failed: java.lang.RuntimeException: Crash
	 * Invalid @Item39Example01: public void com.jueee.item39.Item39Example02.m5()
	 * Passed: 1, Failed: 3
	 */

}
