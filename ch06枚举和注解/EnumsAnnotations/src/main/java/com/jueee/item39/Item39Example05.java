package com.jueee.item39;

public class Item39Example05 {

	@Item39Example04(ArithmeticException.class)
	public static void m1() { // Test should pass
		int i = 0;
		i = i / i;
	}

	@Item39Example04(ArithmeticException.class)
	public static void m2() { // Should fail (wrong exception)
		int[] a = new int[0];
		int i = a[1];
	}

	@Item39Example04(ArithmeticException.class)
	public static void m3() {
	} // Should fail (no exception)
}
