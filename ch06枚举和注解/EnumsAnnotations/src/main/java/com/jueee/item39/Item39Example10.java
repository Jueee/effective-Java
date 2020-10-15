package com.jueee.item39;

import java.lang.reflect.Method;

public class Item39Example10 {

	public static void main(String[] args) throws Exception {
		String testClassName = "com.jueee.item39.Item39Example09";

		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(testClassName);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Item39Example07.class) || m.isAnnotationPresent(Item39Example08.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed: no exception%n", m);
				} catch (Throwable wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					int oldPassed = passed;
					Item39Example07[] excTests = m.getAnnotationsByType(Item39Example07.class);
					for (Item39Example07 excTest : excTests) {
						if (excTest.value().isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed) {
						System.out.printf("Test %s failed: %s %n", m, exc);
					}
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}

	/*
	 * 打印结果： 
	 * Test public static void com.jueee.item39.Item39Example09.doublyBad() failed: no exception
	 * Passed: 0, Failed: 1
	 */

}
