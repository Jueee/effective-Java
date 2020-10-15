package com.jueee.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Item39Example06 {

	public static void main(String[] args) throws Exception {
		String testClassName = "com.jueee.item39.Item39Example05";

		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(testClassName);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Item39Example04.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (InvocationTargetException wrappedEx) {
					Throwable exc = wrappedEx.getCause();
					Class<? extends Throwable> excType = m.getAnnotation(Item39Example04.class).value();
					if (excType.isInstance(exc)) {
						passed++;
					} else {
						System.out.printf("Test %s failed: expected %s, got %s%n", m, excType.getName(), exc);
					}
				} catch (Exception exc) {
					System.out.println("Invalid @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}

	/*
	 * 打印结果： 
	 * Test public static void com.jueee.item39.Item39Example05.m3() failed: no exception
	 * Test public static void com.jueee.item39.Item39Example05.m2() failed: expected java.lang.ArithmeticException, got java.lang.ArrayIndexOutOfBoundsException: 1
	 * Passed: 1, Failed: 2
	 */

}
