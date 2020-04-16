package com.jueee.item38;

public class Item38Example01 {

	private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
		for (Operation op : opEnumType.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
		}
	}

	public static void main(String[] args) {
		String[] testArgs = new String[] {"3.6", "4.9"}; 
		
		double x = Double.parseDouble(testArgs[0]);
		double y = Double.parseDouble(testArgs[1]);
		test(ExtendedOperation.class, x, y);
	}

}
